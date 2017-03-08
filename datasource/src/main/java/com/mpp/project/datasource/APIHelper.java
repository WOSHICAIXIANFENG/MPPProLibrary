package com.mpp.project.datasource;

import com.mpp.project.datasource.api.DefaultAuthAPIImpl;
import com.mpp.project.datasource.json.JsonPaser;
import com.mpp.project.datasource.redis.RedisHelper;
import com.mpp.project.datasource.staff.Staff;

/**
 * Created by Samuel on 7/3/17.
 */

public class APIHelper {
    private RedisHelper reditHelper;
    private JsonPaser jsonPaser;
    private static APIHelper instance;

    private APIHelper() {
        reditHelper = new RedisHelper("10.10.22.200", 6379);
        jsonPaser = new JsonPaser();
    }

    public static APIHelper getInstance() {
        if (instance == null) {
            instance = new APIHelper();
        }

        return instance;
    }

    public Staff login(String userName, String pwd) {
        DefaultAuthAPIImpl defaultAuthAPI = new DefaultAuthAPIImpl(reditHelper, jsonPaser);
        Staff staff = new Staff(userName, pwd);
        return defaultAuthAPI.login(staff);
    }
}
