package com.ngsharma.SpringApp.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.Email;

@Embeddable
public class Address {

    private String streetNo;
    private String pinNo;

    @Email(message = "{employee.address.email}")
    private String email;

    public Address() {}

    public Address(String streetNo, String pinNo, String email) {
        this.streetNo = streetNo;
        this.pinNo = pinNo;
        this.email = email;
    }

    public String getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(String streetNo) {
        this.streetNo = streetNo;
    }

    public String getPinNo() {
        return pinNo;
    }

    public void setPinNo(String pinNo) {
        this.pinNo = pinNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
