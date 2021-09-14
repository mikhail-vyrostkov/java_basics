package net.proselyte.personAndCars.repository;

import net.proselyte.personAndCars.model.PersonWithCars;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonWithCarsRepository extends CrudRepository<PersonWithCars, Long> {

}
