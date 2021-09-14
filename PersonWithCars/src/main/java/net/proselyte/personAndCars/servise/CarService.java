package net.proselyte.personAndCars.servise;

import net.proselyte.personAndCars.exception.PersonNotFoundException;
import net.proselyte.personAndCars.exception.UnderagePersonException;

import net.proselyte.personAndCars.exception.ZeroHorsepowerException;
import net.proselyte.personAndCars.model.Car;

public interface CarService {

  Car save(Car car)
      throws ZeroHorsepowerException, UnderagePersonException, PersonNotFoundException;
}
