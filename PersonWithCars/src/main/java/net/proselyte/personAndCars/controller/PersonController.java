package net.proselyte.personAndCars.controller;

import java.util.List;
import net.proselyte.personAndCars.exception.PersonAlreadyExistException;
import net.proselyte.personAndCars.exception.PersonFromTheFutureException;
import net.proselyte.personAndCars.exception.PersonNotFoundException;
import net.proselyte.personAndCars.model.Person;
import net.proselyte.personAndCars.servise.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
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
  public ResponseEntity getPerson(@PathVariable("id") Long personId) {
    try {
      return new ResponseEntity<>(personService.getById(personId), HttpStatus.OK);
    } catch (PersonNotFoundException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }


  @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity savePerson(@RequestBody Person person) {
    try {
      personService.save(person);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (PersonAlreadyExistException | PersonFromTheFutureException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity updatePerson(@RequestBody Person person) {
    try {
      personService.save(person);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (PersonAlreadyExistException | PersonFromTheFutureException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity deletePerson(@PathVariable("id") Long personId) {
    try {
      personService.delete(personId);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (PersonNotFoundException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
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