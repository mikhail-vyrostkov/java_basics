package net.proselyte.personAndCars.servise;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import net.proselyte.personAndCars.exception.PersonAlreadyExistException;
import net.proselyte.personAndCars.exception.PersonFromTheFutureException;
import net.proselyte.personAndCars.exception.PersonNotFoundException;
import net.proselyte.personAndCars.model.Person;
import net.proselyte.personAndCars.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PersonServiceImp implements PersonService {

  @Autowired
  private PersonRepository personRepository;


  @Override
  public Person save(Person person)
      throws PersonAlreadyExistException, PersonFromTheFutureException {
    LocalDate today = LocalDate.now();
    log.info("IN PersonServiceImp save {}", person);
    if (personRepository.findByName(person.getName()) != null) {
      throw new PersonAlreadyExistException("This person already exists!");
    }
    if (person.getBirthdate().isAfter(today)) {
      throw new PersonFromTheFutureException("Oops!This person from future!");
    }
    return personRepository.save(person);
  }

  @Override
  public Person getById(Long id) throws PersonNotFoundException {
    log.info("IN PersonServiceImp getById {}", id);
    Person person = personRepository.findById(id).get();
    if (person == null) {
      throw new PersonNotFoundException("Person is not found");
    }
    return person;
  }

  @Override
  public void delete(Long id) throws PersonNotFoundException {
    log.info("IN PersonServiceImp delete {}", id);
    Person person = personRepository.findById(id).get();
    if (person == null) {
      throw new PersonNotFoundException("Person is not found");
    }
    personRepository.deleteById(id);
  }

  @Override
  public List<Person> getAll() {
    log.info("IN PersonServiceImp getAll");
    Iterable<Person> personIterable = personRepository.findAll();
    List<Person> persons = new ArrayList<>();
    for (Person person : personIterable) {
      persons.add(person);
    }
    return persons;
  }
}