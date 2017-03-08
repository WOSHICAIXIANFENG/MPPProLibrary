package com.mpp.project.datasource.memberEntity;

import java.util.List;

/**
 * Created by hongleyou on 2017/3/6.
 */

public class MemberEntity {
    private String memberID;
    private String phone;
    private String address;
    private List<Record> records;

    public MemberEntity(String memberID, String phone, String address, List<Record> records) {
        this.memberID = memberID;
        this.phone = phone;
        this.address = address;
        this.records = records;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

    @Override
    public String toString() {
        return "MemberEntity{" +
                "memberID='" + memberID + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", records=" + records +
                '}';
    }
}
