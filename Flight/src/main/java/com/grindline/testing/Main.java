package com.grindline.testing;

import java.util.List;

public class Main {

  public static void main(String[] args) {
    FlightBuilder flightBuilder = new FlightBuilder();
    StringBuilder stringBuilder = new StringBuilder();
    List<Flight> flights = flightBuilder.createFlights();
    FlightFilterImp flightFilterImp = new FlightFilterImp();

    System.out.println("All flights without using a filter: ");
    flightFilterImp.getAllFlight(flights);
    System.out.println("-----------------------//----------------------------" + "\n");
    System.out.println("Flights with filter "
        + "(excluding flights whose departure time before present moment): ");
    flightFilterImp.getFlightsWithoutDepartureTimeBeforePresentMoment(flights);
    System.out.println("-----------------------//----------------------------" + "\n");
    System.out.println("Flights with a filter "
        + "(excluding flights whose arrival date is earlier than the departure date): ");
    flightFilterImp.getFlightsWithoutArrivalDateEarlierDepartureDate(flights);
    System.out.println("-----------------------//----------------------------" + "\n");
    System.out.println("Flights with filter "
        + "(excluding flights whose ground time more than two hours): ");
    flightFilterImp.getFlightsWithoutGroundTimeMoreThanTwoHours(flights);

  }
}
