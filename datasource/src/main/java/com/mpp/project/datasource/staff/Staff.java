package com.mpp.project.datasource.staff;

import java.util.List;

/**
 * Created by hongleyou on 2017/3/7.
 */

public class Staff {
    private String staffID;
    private String passwd;
    private List<String> permits;

    public Staff(String staffID, String passwd, List<String> permits) {
        this.staffID = staffID;
        this.passwd = passwd;
        this.permits = permits;
    }

    public String getStaffID() {
        return staffID;
    }

    public List<String> getPermits() {
        return permits;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffID='" + staffID + '\'' +
                ", passwd='" + passwd + '\'' +
                ", permits=" + permits +
                '}';
    }
}
