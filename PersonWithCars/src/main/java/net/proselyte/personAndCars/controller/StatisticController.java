package net.proselyte.personAndCars.controller;

import java.util.List;
import net.proselyte.personAndCars.model.Statistic;
import net.proselyte.personAndCars.servise.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statistic")
public class StatisticController {

  @Autowired
  private StatisticService statisticService;

  @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<List<Statistic>> getStatistic(){
    return new ResponseEntity<>(statisticService.get(), HttpStatus.OK);
  }

}
