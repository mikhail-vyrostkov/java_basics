package com.grindline.testing;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FlightBuilder {
   // private Integer flightId = 0;
   // private Integer segmentId = 0;

    public List<Flight> createFlights() {
      LocalDateTime threeDaysFromNow = LocalDateTime.now().plusDays(3);
      return Arrays.asList(
          //A normal flight with two hour duration
          createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2)),
          //A normal multi segment flight
          createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
              threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(5)),
          //A flight departing in the past
          createFlight(threeDaysFromNow.minusDays(6), threeDaysFromNow),
          //A flight that departs before it arrives
          createFlight(threeDaysFromNow, threeDaysFromNow.minusHours(6)),
          //A flight with more than two hours ground time
          createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
              threeDaysFromNow.plusHours(5), threeDaysFromNow.plusHours(6)),
          //Another flight with more than two hours ground time
          createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
              threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(4),
              threeDaysFromNow.plusHours(6), threeDaysFromNow.plusHours(7)));
    }


    protected Flight createFlight(final LocalDateTime... dates) {
      if ((dates.length % 2) != 0) {
        throw new IllegalArgumentException(
            "you must pass an even number of dates");
      }
      List<Segment> segments = new ArrayList<>(dates.length / 2);
      for (int i = 0; i < (dates.length - 1); i += 2) {
        segments.add(new Segment(dates[i], dates[i + 1]));
      }
      return new Flight(segments);
    }

}
