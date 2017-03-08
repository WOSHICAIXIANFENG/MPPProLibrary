package com.mpp.project.datasource.memberEntity;

import java.util.List;

/**
 * Created by hongleyou on 2017/3/6.
 */

public class MemberEntity {
    private String memberID;
    private String firstName;
    private String lastName;
    private String phone;

    // address info...
    private String street;
    private String zip;
    private String city;
    private String state;

    private List<Record> records;

    public MemberEntity(String memberID, String firstName, String lastName, String phone,
                        String street, String zip, String city, String state, List<Record> records) {
        this.memberID = memberID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.street = street;
        this.zip = zip;
        this.city = city;
        this.state = state;
        this.records = records;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void addRecord(Record record) {
        records.add(record);
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getPhone() {
        return phone;
    }

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
