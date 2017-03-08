package com.mpp.project.datasource.api;

import com.mpp.project.datasource.staff.Staff;

/**
 * Created by hongleyou on 2017/3/7.
 */

public abstract interface AuthAPI {
    Staff login(Staff staff);

    String changePasswd(Staff staff, String newPasswd);

    String logout();
}
