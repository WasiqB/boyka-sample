package com.github.wasiqb.api.requests;

import static com.github.wasiqb.boyka.actions.api.ApiActions.withRequest;

import com.github.wasiqb.api.pojos.AddressType;
import com.github.wasiqb.api.pojos.City;
import com.github.wasiqb.api.pojos.Contact;
import com.github.wasiqb.api.pojos.UdpAddress;
import com.github.wasiqb.boyka.builders.ApiRequest;
import com.github.wasiqb.boyka.enums.ContentType;
import com.github.wasiqb.boyka.enums.RequestMethod;
import lombok.Getter;
import net.datafaker.Faker;

@Getter
public class UdpAddressRequest {
    private String ContactNumber;

    public ApiRequest createAddressRequest () {
        var faker = new Faker ();

        ContactNumber = faker.phoneNumber ().phoneNumber ();

        var address = UdpAddress.builder ()
            .NickName (faker.name ().fullName ())
            .AddressType (new AddressType (1, "Permanent"))
            .Id (2)
            .Floor ("1st Floor")
            .Building (faker.address ().streetAddress ())
            .Area (faker.address ().streetAddress ())
            .City (new City (faker.address ().cityPrefix (), faker.address ().cityName ()))
            .Status ("Done")
            .ApartmentNo ("102")
            .Contact (Contact.builder ()
                .ContactNumber (ContactNumber)
                .build ())
            .build ();

        return ApiRequest.createRequest ()
            .configKey ("test_address")
            .bodyObject (address)
            .contentType (ContentType.JSON)
            .method (RequestMethod.POST)
            .header ("Authorization", "Bearer eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJ1dWlkIjoiZmYxNDI0OTQtNjI0NC00MWEzLWI0YWUtMDZhZTM4YzA5MDhmIiwibmJmIjoxNjc4MzQ3NDY0LCJleHAiOjE2Nzg0MzM4NjQsImlhdCI6MTY3ODM0NzQ2NCwiaXNzIjoiVGVsZWNvbW11bmljYXRpb25zIGFuZCBEaWdpdGFsIEdvdmVybm1lbnQgUmVndWxhdG9yeSBBdXRob3JpdHkiLCJhdWQiOiJVbmlmaWVkIERpZ2l0YWwgUGxhdGZvcm0ifQ.ZX73rU26yXFiwX5deXhZRvwhx_PkoQFMkZ4hL3nCitUIvTLjeDxN1L2hyFGjmCneftglr9zsc-jLNCisdZkx1A")
            .header ("UseUdpCoreLogin", "True")
            .header ("lang", "en")
            .path ("/udp/v1/addresses")
            .create ();
    }
}
