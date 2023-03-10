package com.github.wasiqb.api;

import static com.github.wasiqb.boyka.actions.api.ApiActions.withRequest;

import com.github.wasiqb.boyka.builders.ApiRequest;
import com.github.wasiqb.boyka.builders.ApiResponse;
import com.github.wasiqb.boyka.enums.ContentType;
import com.github.wasiqb.boyka.enums.RequestMethod;
import org.testng.annotations.Test;

public class ApiTest {
    private String bookingId;

    @Test
    public void testCreateBooking () {
        var requestBooking = Booking.builder ()
            .firstname ("Wasiq")
            .lastname ("Bhamla")
            .totalprice (1000)
            .depositpaid (true)
            .bookingdates (new BookingDates ("2023-02-23", "2023-02-24"))
            .additionalneeds ("Lunch")
            .build ();

        final ApiRequest request = ApiRequest.createRequest ()
            .configKey ("test_booking")
            .method (RequestMethod.POST)
            .contentType (ContentType.JSON)
            .header ("Accept", "application/json")
            .bodyObject (requestBooking)
            .create ();

        ApiResponse response = withRequest (request).execute ();

        response.verifyStatusCode ().isEqualTo (200);
        response.verifySchema ("booking-response.json");

        bookingId = response.getResponseData ("bookingid");

        response.verifyIntField ("bookingid").isNotNull ();
        response.verifyTextField ("booking.firstname").isEqualTo ("Wasiq");
    }

    @Test (dependsOnMethods = "testCreateBooking")
    public void testGetBooking () {
        final ApiRequest request = ApiRequest.createRequest ()
            .configKey ("test_booking")
            .method (RequestMethod.GET)
            .contentType (ContentType.JSON)
            .header ("Accept", "application/json")
            .path ("/${bookingId}")
            .pathParam ("bookingId", bookingId)
            .create ();

        var response = withRequest (request).execute ();

        response.verifyStatusCode ().isEqualTo (200);
        response.verifyTextField ("firstname").isEqualTo ("Wasiq");
    }

    @Test (dependsOnMethods = "testGetBooking")
    public void testUpdateBooking () {
        var requestBooking = Booking.builder ()
            .firstname ("Wasiq")
            .lastname ("Bhamla")
            .totalprice (2000)
            .depositpaid (true)
            .bookingdates (new BookingDates ("2023-02-23", "2023-02-24"))
            .additionalneeds ("Breakfast")
            .build ();

        final ApiRequest request = ApiRequest.createRequest ()
            .configKey ("test_booking")
            .method (RequestMethod.PUT)
            .contentType (ContentType.JSON)
            .header ("Accept", "application/json")
            .bodyObject (requestBooking)
            .path ("/${bookingId}")
            .pathParam ("bookingId", bookingId)
            .create ();

        var response = withRequest (request).execute ();

        response.verifyStatusCode ().isEqualTo (200);
        response.verifyTextField ("firstname").isEqualTo ("Wasiq");
        response.verifyTextField ("totalprice").isEqualTo (2000);
        response.verifyTextField ("additionalneeds").isEqualTo ("Breakfast");
    }
}
