package com.mpp.project.datasource.entity;

import java.io.Serializable;

/**
 * Created by hongleyou on 2017/3/6.
 */

public class Author implements Serializable {
    private String First_name;
    private String Last_name;
    private String Address;
    private String Phone;
    private String Credentials;
    private String Short_bio;

    Author(String first_name, String last_name, String address, String phone, String credentials, String short_bio) {
        First_name = first_name;
        Last_name = last_name;
        Address = address;
        Phone = phone;
        Credentials = credentials;
        Short_bio = short_bio;
    }

    @Override
    public String toString() {
        return "Author{" +
                "First_name='" + First_name + '\'' +
                ", Last_name='" + Last_name + '\'' +
                ", Address='" + Address + '\'' +
                ", Phone='" + Phone + '\'' +
                ", Credentials='" + Credentials + '\'' +
                ", Short_bio='" + Short_bio + '\'' +
                '}';
    }
}
