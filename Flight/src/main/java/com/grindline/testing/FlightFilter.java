package com.grindline.testing;

import java.util.List;

public interface FlightFilter {

  List<Flight> getAllFlight(List<Flight> flights);

  List<Flight> getFlightsWithoutDepartureTimeBeforePresentMoment(List<Flight> flights);

  List<Flight> getFlightsWithoutArrivalDateEarlierDepartureDate(List<Flight> flights);

  List<Flight> getFlightsWithoutGroundTimeMoreThanTwoHours(List<Flight> flights);

}
