package com.grindline.testing;

import java.util.List;

public interface FlightFilter {

  void getAllFlight(List<Flight> flights);

  void getFlightsWithoutDepartureTimeBeforePresentMoment(List<Flight> flights);

  void getFlightsWithoutArrivalDateEarlierDepartureDate(List<Flight> flights);

  void getFlightsWithoutGroundTimeMoreThanTwoHours(List<Flight> flights);

}
