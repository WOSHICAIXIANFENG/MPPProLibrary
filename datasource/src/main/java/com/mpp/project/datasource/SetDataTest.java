package com.mpp.project.datasource;

import com.mpp.project.datasource.json.JsonPaser;
import com.mpp.project.datasource.redis.RedisHelper;

public class SetDataTest {
    public static void main(String[] args) {
        RedisHelper reditHelper = new RedisHelper("localhost", 6379);

        String administrator1 = "{\"staffID\":\"administrator1\",\"passwd\":\"123456\",\"permits\":[\"PERMIT_ALL\"]}";
        String administrator2 = "{\"staffID\":\"administrator2\",\"passwd\":\"123456\",\"permits\":[\"PERMIT_ADD_MEMBER\",\"PERMIT_EDIT_MEMBER\", \"PERMIT_ADD_BOOK\", \"PERMIT_ADD_COPY\"]}";
        String librarian1 = "{\"staffID\":\"librarian1\",\"passwd\":\"123456\",\"permits\":[\"PERMIT_CHECKOUT\"]}";
        String librarian2 = "{\"staffID\":\"librarian2\",\"passwd\":\"123456\",\"permits\":[\"PERMIT_CHECKOUT\",\"PERMIT_ADD_BOOK\", \"PERMIT_ADD_MEMBER\", \"PERMIT_EDIT_MEMBER\"]}";

        reditHelper.SetInfo("administrator1", administrator1);
        reditHelper.SetInfo("administrator2", administrator2);
        reditHelper.SetInfo("librarian1", librarian1);
        reditHelper.SetInfo("librarian2", librarian2);
    }
}
