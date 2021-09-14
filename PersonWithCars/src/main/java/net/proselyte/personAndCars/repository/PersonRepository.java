package net.proselyte.personAndCars.repository;

import java.util.Date;
import net.proselyte.personAndCars.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

  Person findByName(String name);
  Person findByBirthdate(Date birthdate);

}
