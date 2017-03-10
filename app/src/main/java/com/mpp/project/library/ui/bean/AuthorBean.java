package com.mpp.project.library.ui.bean;

/**
 * Created by Samuel on 7/3/17.
 */

public class AuthorBean {
    private String firstName;
    private String lastName;
    private String phone;
    private String credentials;
    private String shortbio;

    private String street;
    private String state;
    private String city;
    private String zip;

    public AuthorBean(String firstName, String lastName, String phone, String credentials, String shortbio) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.credentials = credentials;
        this.shortbio = shortbio;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCredentials() {
        return credentials;
    }

    public void setCredentials(String credentials) {
        this.credentials = credentials;
    }

    public String getShortbio() {
        return shortbio;
    }

    public void setShortbio(String shortbio) {
        this.shortbio = shortbio;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
