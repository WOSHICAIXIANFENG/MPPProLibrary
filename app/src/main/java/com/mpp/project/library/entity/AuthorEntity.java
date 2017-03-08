package com.mpp.project.library.entity;

/**
 * Created by yangyangli on 3/6/17.
 */

public class AuthorEntity {
    private int auorder;
    private String aufname;
    private String aulname;
    private String addstreet;
    private String addcity;
    private String addstate;
    private int addzip;
    private int phoneNum;
    private String credentials;
    private String boi;

    public AuthorEntity(String aufname, String aulname) {
        this.aufname = aufname;
        this.aulname = aulname;
    }

    public String getAddstreet() {
        return addstreet;
    }

    public void setAddstreet(String addstreet) {
        this.addstreet = addstreet;
    }

    public String getAddcity() {
        return addcity;
    }

    public void setAddcity(String addcity) {
        this.addcity = addcity;
    }

    public String getAddstate() {
        return addstate;
    }

    public void setAddstate(String addstate) {
        this.addstate = addstate;
    }

    public int getAddzip() {
        return addzip;
    }

    public void setAddzip(int addzip) {
        this.addzip = addzip;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getCredentials() {
        return credentials;
    }

    public void setCredentials(String credentials) {
        this.credentials = credentials;
    }

    public String getBoi() {
        return boi;
    }

    public void setBoi(String boi) {
        this.boi = boi;
    }

    public int getAuorder() {

        return auorder;
    }

    public void setAuorder(int auorder) {
        this.auorder = auorder;
    }
}
