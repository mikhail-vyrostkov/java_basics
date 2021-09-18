package com.grindline.testing;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class FlightFilterImp implements FlightFilter {

  @Override
  public void getAllFlight(List<Flight> flights) {
    StringBuilder stringBuilder = new StringBuilder();
    flights.forEach(flight -> stringBuilder.append(flight).append("\n"));
    System.out.println(stringBuilder);
  }

  @Override
  public void getFlightsWithoutDepartureTimeBeforePresentMoment(List<Flight> flights) {
    StringBuilder stringBuilder = new StringBuilder();
    flights.forEach(flight -> flight.getSegments()
        .stream()
        .filter(segment -> segment.getDepartureDate().isAfter(LocalDateTime.now())).limit(1)
        .forEach(segment -> stringBuilder.append(flight).append("\n")));
    System.out.println(stringBuilder.toString());
  }

  @Override
  public void getFlightsWithoutArrivalDateEarlierDepartureDate(List<Flight> flights) {
    StringBuilder stringBuilder = new StringBuilder();
    flights.forEach(flight -> flight.getSegments()
        .stream()
        .filter(segment -> segment.getArrivalDate().isAfter(segment.getDepartureDate())).limit(1)
        .forEach(segment -> stringBuilder.append(flight).append("\n")));
    System.out.println(stringBuilder.toString());
  }

  @Override
  public void getFlightsWithoutGroundTimeMoreThanTwoHours(List<Flight> flights) {
    StringBuilder stringBuilder = new StringBuilder();
    for (Flight flight : flights) {
      List<Segment> segments = flight.getSegments();
      if (segments.size() > 0) {
        int groundTime = 0;
        for (int i = 1; i < segments.size(); i++) {
          groundTime += ChronoUnit.HOURS.between(flight.getSegments().get(i - 1).getArrivalDate(),
              flight.getSegments().get(i).getDepartureDate());
        }
        if (groundTime <= 2) {
          stringBuilder.append(flight).append("\n");
        }
      } else {
        stringBuilder.append(flight).append("\n");
      }
    }
    System.out.println(stringBuilder.toString());
  }
}
