package net.proselyte.personAndCars.repository;

import net.proselyte.personAndCars.model.Statistic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticRepositopy extends CrudRepository<Statistic,Long> {

}
