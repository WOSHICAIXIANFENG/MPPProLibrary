package com.mpp.project.datasource;

import com.mpp.project.datasource.json.JsonPaser;
import com.mpp.project.datasource.redis.RedisHelper;

/**
 * Created by hongleyou on 2017/3/6.
 */

public class RecordAPITest {
    RedisHelper reditHelper = new RedisHelper("localhost", 6379);
    JsonPaser jsonPaser = new JsonPaser();
}
