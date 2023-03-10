package com.github.wasiqb.api;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Booking {
    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private BookingDates bookingdates;
    private String additionalneeds;
}
