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
