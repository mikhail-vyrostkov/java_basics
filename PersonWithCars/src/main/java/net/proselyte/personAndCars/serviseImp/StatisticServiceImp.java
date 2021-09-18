package net.proselyte.personAndCars.serviseImp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import lombok.extern.slf4j.Slf4j;
import net.proselyte.personAndCars.model.Car;
import net.proselyte.personAndCars.model.Person;
import net.proselyte.personAndCars.model.Statistic;
import net.proselyte.personAndCars.repository.CarRepository;
import net.proselyte.personAndCars.repository.PersonRepository;
import net.proselyte.personAndCars.repository.StatisticRepositopy;
import net.proselyte.personAndCars.servise.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StatisticServiceImp implements StatisticService {
  private Long personCount = 0L;
  private Long cerCount = 0L;
  @Autowired
  private StatisticRepositopy statisticRepositopy;

  @Autowired
  private PersonRepository personRepository;

  @Autowired
  private CarRepository carRepository;

  @Override
  public Statistic get() {
    Iterable<Person> personIterable = personRepository.findAll();
    List<Person> personList = new ArrayList<>();
    for (Person person : personIterable){
      personList.add(person);
      personCount++;
    }
    Iterable<Car> carIterable = carRepository.findAll();
    List<Car> carList = new ArrayList<>();
    for (Car car : carIterable){
      carList.add(car);
      cerCount++;
      }

    return ;
      }

}
