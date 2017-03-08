package com.mpp.project.library.db.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Samuel on 8/3/17.
 */
@Entity
public class StaffEntity {
    @Id(autoincrement = true)
    private Long id;

    private String userName;
    private String password;

    private String firstName;
    private String lastName;

    private String permits; // permit1,permit2,permit3

    public String getPermits() {
        return this.permits;
    }

    public void setPermits(String permits) {
        this.permits = permits;
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

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Generated(hash = 1102585900)
    public StaffEntity(Long id, String userName, String password, String firstName,
            String lastName, String permits) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.permits = permits;
    }

    @Generated(hash = 623314536)
    public StaffEntity() {
    }

}
