package com.mpp.project.datasource.api;

import com.mpp.project.datasource.json.JsonPaser;
import com.mpp.project.datasource.redis.RedisHelper;
import com.mpp.project.datasource.staff.Staff;

/**
 * Created by hongleyou on 2017/3/7.
 */

public class DefaultAuthAPIImpl implements AuthAPI {
    private RedisHelper reditHelper;
    private JsonPaser jsonPaser;

    public DefaultAuthAPIImpl(RedisHelper reditHelper, JsonPaser jsonPaser) {
        this.reditHelper = reditHelper;
        this.jsonPaser = jsonPaser;
    }

    @Override
    public String changePasswd(Staff staff, String newPasswd) {
        if(!reditHelper.HasKey(staff.getStaffID()))
            return null;

        String jsonStr = reditHelper.GetInfo(staff.getStaffID());
        if(jsonStr == null)
            return null;

        Staff s = jsonPaser.JsonToStaff(jsonStr);
        if(s == null || !s.getPasswd().equals(staff.getPasswd()))
            return null;

        s.setPasswd(newPasswd);
        jsonStr = jsonPaser.StaffToJson(s);
        reditHelper.SetInfo(s.getStaffID(), jsonStr);

        return "Password is changed.";
    }

    @Override //You can use a Staff instance with staffID and passwd to login, I'll fill the list.
    public Staff login(Staff staff) {
        if(!reditHelper.HasKey(staff.getStaffID()))
            return null;

        String jsonStr = reditHelper.GetInfo(staff.getStaffID());
        if(jsonStr == null)
            return null;

        Staff s = jsonPaser.JsonToStaff(jsonStr);
        if(s == null || !s.getPasswd().equals(staff.getPasswd()))
            return null;

        return s;
    }

    @Override
    public String logout() {
        return "Logout successfully.";
    }
}
