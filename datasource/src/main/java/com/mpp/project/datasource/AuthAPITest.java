package com.mpp.project.datasource;

import com.mpp.project.datasource.api.DefaultAuthAPIImpl;
import com.mpp.project.datasource.json.JsonPaser;
import com.mpp.project.datasource.redis.RedisHelper;
import com.mpp.project.datasource.staff.Staff;

/**
 * Created by hongleyou on 2017/3/7.
 */

public class AuthAPITest {
    // permission list
    public static final String PERMISSION_CHECKOUT = "PERMIT_CHECKOUT";
    public static final String PERMISSION_ADD_MEMBER = "PERMIT_ADD_MEMBER";
    public static final String PERMISSION_EDIT_MEMBER = "PERMIT_EDIT_MEMBER";
    public static final String PERMISSION_ADD_BOOK = "PERMIT_ADD_BOOK";
    public static final String PERMISSION_ADD_COPY_BOOK = "PERMIT_ADD_COPY";
    public static final String PERMISSION_HUMAN_MANAGER = "PERMIT_MANAGER_STAFF";
    public static final String PERMISSION_ALL = "PERMIT_ALL";


    public static void main(String[] args) {
        RedisHelper reditHelper = new RedisHelper("localhost", 6379);
        JsonPaser jsonPaser = new JsonPaser();

        DefaultAuthAPIImpl defaultAuthAPI = new DefaultAuthAPIImpl(reditHelper, jsonPaser);

        String jsonStr = "{\"staffID\":\"samuel@gmail.com\",\"passwd\":\"123456\",\"permits\":[\"PERMIT_CHECKOUT\",\"PERMIT_ADD_MEMBER\", \"PERMIT_EDIT_MEMBER\"]}";
        reditHelper.SetInfo("123", jsonStr);
        Staff staff = jsonPaser.JsonToStaff(jsonStr);
        System.out.println(defaultAuthAPI.login(staff).toString());
    }
}
