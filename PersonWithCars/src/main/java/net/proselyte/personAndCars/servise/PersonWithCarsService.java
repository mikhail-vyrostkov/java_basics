package net.proselyte.personAndCars.servise;

import net.proselyte.personAndCars.exception.PersonNotFoundException;
import net.proselyte.personAndCars.model.PersonWithCars;

public interface PersonWithCarsService {

  PersonWithCars getById(Long id);

}
