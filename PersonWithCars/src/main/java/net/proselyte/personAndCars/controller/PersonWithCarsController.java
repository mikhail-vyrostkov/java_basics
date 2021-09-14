package net.proselyte.personAndCars.controller;

import net.proselyte.personAndCars.model.PersonWithCars;
import net.proselyte.personAndCars.servise.PersonWithCarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personwithcars")
public class PersonWithCarsController {

  @Autowired
  private PersonWithCarsService personWithCarsService;

  @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<PersonWithCars> getPersonWithCars(@RequestParam Long personId) {
    if (personId == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    PersonWithCars personWithCars = personWithCarsService.getById(personId);
    if (personWithCars == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(personWithCars,HttpStatus.OK);
  }
}
