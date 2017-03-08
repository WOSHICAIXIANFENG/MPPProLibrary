package com.mpp.project.library.db.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by yangyangli on 3/6/17.
 */
@Entity
public class AuthorEntity {
    @Id(autoincrement = true)
    private Long id;

    private String firstName;
    private String lastName;
    private String phone;
    private String credentials;
    private String shortBio;

    private String street;
    private String zip;
    private String city;
    private String state;

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }
    public String getCity() {
        return this.city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getZip() {
        return this.zip;
    }
    public void setZip(String zip) {
        this.zip = zip;
    }
    public String getStreet() {
        return this.street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getShortBio() {
        return this.shortBio;
    }
    public void setShortBio(String shortBio) {
        this.shortBio = shortBio;
    }
    public String getCredentials() {
        return this.credentials;
    }
    public void setCredentials(String credentials) {
        this.credentials = credentials;
    }
    public String getPhone() {
        return this.phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getLastName() {
        return this.lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFirstName() {
        return this.firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 1322224945)
    public AuthorEntity(Long id, String firstName, String lastName, String phone,
            String credentials, String shortBio, String street, String zip,
            String city, String state) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.credentials = credentials;
        this.shortBio = shortBio;
        this.street = street;
        this.zip = zip;
        this.city = city;
        this.state = state;
    }
    @Generated(hash = 1571134052)
    public AuthorEntity() {
    }

}
