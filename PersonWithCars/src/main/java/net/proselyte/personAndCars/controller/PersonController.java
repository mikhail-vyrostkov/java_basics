package net.proselyte.personAndCars.controller;

import java.util.List;
import net.proselyte.personAndCars.exception.PersonAlreadyExistException;
import net.proselyte.personAndCars.exception.PersonFromTheFutureException;
import net.proselyte.personAndCars.model.Person;
import net.proselyte.personAndCars.servise.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

  @Autowired
  private PersonService personService;

  @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<Person> getPerson(@PathVariable("id") Long personId) {
    if (personId == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    Person person = this.personService.getById(personId);
    if (person == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(person,HttpStatus.OK);
  }

  @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<Person> savePerson(@RequestBody Person person)
      throws PersonAlreadyExistException, PersonFromTheFutureException {
     if (person == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    this.personService.save(person);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<Person> updatePerson(@RequestBody Person person)
      throws PersonAlreadyExistException, PersonFromTheFutureException {
    HttpHeaders headers = new HttpHeaders();

    if (person == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    this.personService.save(person);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<Person> deletePerson(@PathVariable("id") Long personId) {
    Person person = this.personService.getById(personId);

    if (person == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    this.personService.delete(personId);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<List<Person>> getAllCustomers() {
    List<Person> customers = this.personService.getAll();
    if (customers.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(customers, HttpStatus.OK);
  }
}
