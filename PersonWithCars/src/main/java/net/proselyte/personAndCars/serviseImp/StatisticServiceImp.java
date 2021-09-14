package net.proselyte.personAndCars.serviseImp;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import net.proselyte.personAndCars.model.Statistic;
import net.proselyte.personAndCars.repository.StatisticRepositopy;
import net.proselyte.personAndCars.servise.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StatisticServiceImp implements StatisticService {

  @Autowired
  private StatisticRepositopy statisticRepositopy;

  @Override
  public List<Statistic> get() {
    Iterable<Statistic> statisticIterable = statisticRepositopy.findAll();
    List<Statistic> statistics = new ArrayList<>();
    for (Statistic statistic : statisticIterable){
      statistics.add(statistic);
    }
    return statistics;
  }
}
