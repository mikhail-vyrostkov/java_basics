package net.proselyte.personAndCars.servise;

import java.util.List;
import net.proselyte.personAndCars.exception.PersonAlreadyExistException;
import net.proselyte.personAndCars.exception.PersonFromTheFutureException;
import net.proselyte.personAndCars.exception.PersonNotFoundException;
import net.proselyte.personAndCars.model.Person;


public interface PersonService {

  Person save(Person person) throws PersonAlreadyExistException, PersonFromTheFutureException;

  Person getById(Long id) throws PersonNotFoundException;

  List<Person> getAll();

  void delete(Long id) throws PersonNotFoundException;

  void   deleteAll();

}