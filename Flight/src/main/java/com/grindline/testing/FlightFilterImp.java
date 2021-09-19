package com.grindline.testing;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class FlightFilterImp implements FlightFilter {

  @Override
  public List<Flight> getAllFlight(List<Flight> flights) {
    List<Flight> flightList = new ArrayList<>();
    flightList.addAll(flights);
    return flightList;
  }

  @Override
  public List<Flight> getFlightsWithoutDepartureTimeBeforePresentMoment(List<Flight> flights) {
    List<Flight> flightList = new ArrayList<>();
    flights.forEach(flight -> flight.getSegments()
        .stream()
        .filter(segment -> segment.getDepartureDate().isAfter(LocalDateTime.now())).limit(1)
        .forEach(segment -> flightList.add(flight)));
  return flightList;
  }

  @Override
  public List<Flight> getFlightsWithoutArrivalDateEarlierDepartureDate(List<Flight> flights) {
    List<Flight> flightList = new ArrayList<>();
    flights.forEach(flight -> flight.getSegments()
        .stream()
        .filter(segment -> segment.getArrivalDate().isAfter(segment.getDepartureDate())).limit(1)
        .forEach(segment -> flightList.add(flight)));
    return flightList;
  }

  @Override
  public List<Flight> getFlightsWithoutGroundTimeMoreThanTwoHours(List<Flight> flights) {
    List<Flight> flightList = new ArrayList<>();
    for (Flight flight : flights) {
      List<Segment> segments = flight.getSegments();
      if (segments.size() > 0) {
        int groundTime = 0;
        for (int i = 1; i < segments.size(); i++) {
          groundTime += ChronoUnit.HOURS.between(flight.getSegments().get(i - 1).getArrivalDate(),
              flight.getSegments().get(i).getDepartureDate());
        }
        if (groundTime <= 2) {
          flightList.add(flight);
        }
      } else {
        flightList.add(flight);
      }
    }
    return flightList;
  }
}
