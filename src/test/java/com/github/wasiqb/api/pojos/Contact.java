package com.github.wasiqb.api.pojos;

import lombok.Builder;

@Builder
public class Contact {
    private int ID;
    private String RelationshipType;
    private String RelationshipName;
    private String ContactNumber;
}
