package net.proselyte.personAndCars.servise;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import lombok.extern.slf4j.Slf4j;
import net.proselyte.personAndCars.exception.PersonNotFoundException;
import net.proselyte.personAndCars.exception.UnderagePersonException;
import net.proselyte.personAndCars.exception.ZeroHorsepowerException;
import net.proselyte.personAndCars.model.Car;
import net.proselyte.personAndCars.model.Person;
import net.proselyte.personAndCars.repository.CarRepository;
import net.proselyte.personAndCars.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CarServiceImp implements CarService {

  private static final int ageOfMajority = 18;

  @Autowired
  private CarRepository carRepository;
  @Autowired
  private PersonRepository personRepository;


  @Override
  public Car save(Car car, Long personId)
      throws ZeroHorsepowerException, UnderagePersonException, PersonNotFoundException {
    LocalDate today = LocalDate.now();

    Person person = personRepository.findById(personId).get();
    if (person == null) {
      throw new PersonNotFoundException("Person not found!");
    }
    car.setPerson(person);
    log.info("IN CarServiceImp save {}", car);
    if (car.getHorsepower() <= 0) {
      throw new ZeroHorsepowerException("This car has zero horsepower!");
    }
    if (LocalDate.from(person.getBirthdate()).until(today, ChronoUnit.YEARS) < ageOfMajority) {
      throw new UnderagePersonException("Oops!Person is underage!");
    }
    return carRepository.save(car);

  }

}
