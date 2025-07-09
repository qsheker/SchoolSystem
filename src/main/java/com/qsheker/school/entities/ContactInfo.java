package com.qsheker.school.entities;


import javax.persistence.Embeddable;

@Embeddable
public class ContactInfo {
    private String city;
    private String street;
    private String phoneNumber;
}
