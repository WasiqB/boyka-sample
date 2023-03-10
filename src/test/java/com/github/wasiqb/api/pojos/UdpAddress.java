package com.github.wasiqb.api.pojos;

import lombok.Builder;

@Builder
public class UdpAddress {
    private AddressType AddressType;
    private int Id;
    private String NickName;
    private String ApartmentNo;
    private String Building;
    private String Street;
    private String Floor;
    private String Area;
    private String Status;
    private Contact Contact;
    private City City;
    private int Version;
}
