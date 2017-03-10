package com.mpp.project.library.ui.bean;

/**
 * Created by yangyangli on 3/6/17.
 */

public class LoginBean {
    // user input value, you can get from LoginActivity...
    private String userName;
    private String password;

    public LoginBean(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
