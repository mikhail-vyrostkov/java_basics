package com.grindline.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import junit.framework.TestCase;

public class FlightFilterTest extends TestCase {

  private static final LocalDateTime threeDaysFromNow = LocalDateTime.now().plusDays(3);
  protected static final List<Flight> flights = new ArrayList<>();

  private static final Segment segment1 = new Segment(threeDaysFromNow,
      threeDaysFromNow.plusHours(2));
  private static final Segment segment2 = new Segment(threeDaysFromNow.plusHours(3),
      threeDaysFromNow.plusHours(4));
  private static final Segment segment3 = new Segment(threeDaysFromNow.plusHours(6),
      threeDaysFromNow.plusHours(7));
  private static final Segment segment4 = new Segment(threeDaysFromNow.minusDays(3),
      threeDaysFromNow);
  private static final Segment segment5 = new Segment(threeDaysFromNow,
      threeDaysFromNow.minusHours(3));
  protected static final Flight flight1 = new Flight(List.of(segment1));
  protected static final Flight flight2 = new Flight(Arrays.asList(segment1, segment2));
  protected static final Flight flight3 = new Flight(List.of(segment4));
  protected static final Flight flight4 = new Flight(List.of(segment5));
  protected static final Flight flight5 = new Flight(Arrays.asList(segment1, segment2, segment3));
  FlightFilterImp filterImp = new FlightFilterImp();

  @Override
  protected void setUp() throws Exception {

    flights.add(flight1);
    flights.add(flight2);
    flights.add(flight3);
    flights.add(flight4);
    flights.add(flight5);

  }

  public void testGetAllFlight() {
    List<Flight> actualList = filterImp.getAllFlight(flights);
    List<Flight> expectedList = Arrays.asList(flight1, flight2, flight3, flight4, flight5);
    assertEquals(expectedList, actualList);
  }

  public void testGetFlightsWithoutDepartureTimeBeforePresentMoment() {
    List<Flight> actualList = filterImp.getFlightsWithoutDepartureTimeBeforePresentMoment(flights);
    List<Flight> expectedList = Arrays.asList(flight1, flight2, flight4, flight5);
    assertEquals(expectedList, actualList);
  }

  public void testGetFlightsWithoutArrivalDateEarlierDepartureDate() {
    List<Flight> actualList1 = filterImp.getFlightsWithoutArrivalDateEarlierDepartureDate(flights);
    List<Flight> expectedList = Arrays.asList(flight1, flight2, flight3, flight5);
    assertEquals(expectedList, actualList1);
  }

  public void testGetFlightsWithoutGroundTimeMoreThanTwoHours() {
    List<Flight> actualList = filterImp.getFlightsWithoutGroundTimeMoreThanTwoHours(flights);
    List<Flight> expectedList = Arrays.asList(flight1, flight2, flight3, flight4);
    assertEquals(expectedList, actualList);
  }

  @Override
  protected void tearDown() throws Exception {
    super.tearDown();
  }
}
