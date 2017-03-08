package com.mpp.project.datasource;

import com.mpp.project.datasource.api.DefaultAuthAPIImpl;
import com.mpp.project.datasource.json.JsonPaser;
import com.mpp.project.datasource.redis.RedisHelper;
import com.mpp.project.datasource.staff.Staff;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hongleyou on 2017/3/7.
 */

public class AuthAPITest {
    public static void main(String[] args) {
        RedisHelper reditHelper = new RedisHelper("localhost", 6379);
        JsonPaser jsonPaser = new JsonPaser();

        DefaultAuthAPIImpl defaultAuthAPI = new DefaultAuthAPIImpl(reditHelper, jsonPaser);

        String jsonStr = "{\"staffID\":\"123\",\"passwd\":\"456\",\"permits\":[\"root\",\"guest\"]}";
        reditHelper.SetInfo("123", jsonStr);
        Staff staff = jsonPaser.JsonToStaff(jsonStr);
        System.out.println(defaultAuthAPI.login(staff).toString());
        System.out.println(defaultAuthAPI.changePasswd(staff, "789"));
    }
}
