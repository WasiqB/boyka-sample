package com.github.wasiqb.api;

import static com.github.wasiqb.boyka.actions.api.ApiActions.withRequest;

import com.github.wasiqb.api.requests.UdpAddressRequest;
import org.testng.annotations.Test;

public class UdpTests {
    @Test
    public void testCreateUdpAddress () {
        var addressRequest = new UdpAddressRequest ();
        var response = withRequest (addressRequest.createAddressRequest ()).execute ();

        response.verifyStatusCode ().isEqualTo (200);
        response.verifySchema ("udp-address.json");
        response.verifyTextField ("EmployeeDetail.Contact.EmailId")
            .isEqualTo (addressRequest.getContactNumber ());
    }
}
