package com.mpp.project.datasource.bookEntity;

import java.io.Serializable;

/**
 * Created by hongleyou on 2017/3/6.
 */

public class Author implements Serializable {
    private String first_name;
    private String last_name;
    private String address;
    private String phone;
    private String credentials;
    private String short_bio;

    Author(String first_name, String last_name, String address, String phone, String credentials, String short_bio) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.phone = phone;
        this.credentials = credentials;
        this.short_bio = short_bio;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getShort_bio() {
        return short_bio;
    }

    public void setShort_bio(String short_bio) {
        this.short_bio = short_bio;
    }

    @Override
    public String toString() {
        return "Author{" +
                "First_name='" + first_name + '\'' +
                ", Last_name='" + last_name + '\'' +
                ", Address='" + address + '\'' +
                ", Phone='" + phone + '\'' +
                ", Credentials='" + credentials + '\'' +
                ", Short_bio='" + short_bio + '\'' +
                '}';
    }
}
