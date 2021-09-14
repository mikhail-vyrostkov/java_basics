package net.proselyte.personAndCars.serviseImp;

import lombok.extern.slf4j.Slf4j;
import net.proselyte.personAndCars.exception.PersonNotFoundException;
import net.proselyte.personAndCars.model.Person;
import net.proselyte.personAndCars.model.PersonWithCars;
import net.proselyte.personAndCars.repository.PersonRepository;
import net.proselyte.personAndCars.repository.PersonWithCarsRepository;
import net.proselyte.personAndCars.servise.PersonWithCarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PersonWithCarsServiceImp implements PersonWithCarsService {

  @Autowired
  private PersonWithCarsRepository personWithCarsRepository;

  @Autowired
  private PersonRepository personRepository;


  @Override
  public PersonWithCars getById(Long personId) {

    return personWithCarsRepository.findById(personId).get();
  }
}
