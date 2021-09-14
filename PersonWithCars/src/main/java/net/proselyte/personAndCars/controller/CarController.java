package net.proselyte.personAndCars.controller;
import net.proselyte.personAndCars.exception.PersonNotFoundException;
import net.proselyte.personAndCars.exception.UnderagePersonException;
import net.proselyte.personAndCars.exception.ZeroHorsepowerException;
import net.proselyte.personAndCars.model.Car;
import net.proselyte.personAndCars.model.Person;
import net.proselyte.personAndCars.servise.CarService;
import net.proselyte.personAndCars.servise.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class CarController {

  private CarService carService;

  @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity saveCar(@RequestBody Car car, @RequestParam Long personId) {
    try {
      return ResponseEntity.ok(carService.save(car, personId));
    } catch (UnderagePersonException | ZeroHorsepowerException | PersonNotFoundException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
}
