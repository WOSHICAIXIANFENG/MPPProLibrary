package com.mpp.project.datasource;

import com.google.gson.Gson;
import com.mpp.project.datasource.api.DefaultCheckOutAPIImpl;
import com.mpp.project.datasource.json.JsonPaser;
import com.mpp.project.datasource.memberEntity.MemberEntity;
import com.mpp.project.datasource.redis.RedisHelper;

/**
 * Created by hongleyou on 2017/3/6.
 */

public class RecordAPITest {
    public static void main(String args[]) {
        RedisHelper reditHelper = new RedisHelper("localhost", 6379);
        JsonPaser jsonPaser = new JsonPaser();

        DefaultCheckOutAPIImpl defaultCheckOutAPI = new DefaultCheckOutAPIImpl(reditHelper, jsonPaser);
        String jsonStr1 = "{\"memberID\":\"890\",\"phone\":\"641-12345\",\"address\":\"1000 N st, Faired, IA USA\",\"records\":[{\"isbn\":\"223456\",\"checkOutDay\":\"2017-2-1\",\"dueDay\":\"2017-2-8\",\"laterDays\":0,\"fine\":0},{\"isbn\":\"223456\",\"checkOutDay\":\"2017-2-2\",\"dueDay\":\"2017-2-9\",\"laterDays\":0,\"fine\":0},{\"isbn\":\"223457\",\"checkOutDay\":\"2017-2-3\",\"dueDay\":\"2017-2-10\",\"laterDays\":0,\"fine\":0}]}";
        String jsonStr2 = "{\"memberID\":\"891\",\"phone\":\"641-12345\",\"address\":\"1000 N st, Faired, IA USA\",\"records\":[{\"isbn\":\"223456\",\"checkOutDay\":\"2017-2-1\",\"dueDay\":\"2017-2-8\",\"laterDays\":0,\"fine\":0},{\"isbn\":\"223456\",\"checkOutDay\":\"2017-2-2\",\"dueDay\":\"2017-2-9\",\"laterDays\":0,\"fine\":0},{\"isbn\":\"223457\",\"checkOutDay\":\"2017-2-3\",\"dueDay\":\"2017-2-10\",\"laterDays\":0,\"fine\":0}]}";
        String jsonStr3 = "{\"memberID\":\"892\",\"phone\":\"641-12345\",\"address\":\"1000 N st, Faired, IA USA\",\"records\":[{\"isbn\":\"223456\",\"checkOutDay\":\"2017-2-1\",\"dueDay\":\"2017-2-8\",\"laterDays\":0,\"fine\":0},{\"isbn\":\"223456\",\"checkOutDay\":\"2017-2-2\",\"dueDay\":\"2017-2-9\",\"laterDays\":0,\"fine\":0},{\"isbn\":\"223457\",\"checkOutDay\":\"2017-2-3\",\"dueDay\":\"2017-2-10\",\"laterDays\":0,\"fine\":0}]}";
        MemberEntity memberEntity1 = new Gson().fromJson(jsonStr1, MemberEntity.class);
        MemberEntity memberEntity2 = new Gson().fromJson(jsonStr2, MemberEntity.class);
        MemberEntity memberEntity3 = new Gson().fromJson(jsonStr3, MemberEntity.class);

        defaultCheckOutAPI.addMember(memberEntity1);
        defaultCheckOutAPI.addMember(memberEntity2);
        defaultCheckOutAPI.addMember(memberEntity3);

        memberEntity1.setPhone("641-23456");
        defaultCheckOutAPI.editMember(memberEntity1);

        System.out.println("CheckMemberID" + defaultCheckOutAPI.checkMemberID(memberEntity2.getMemberID()));

        MemberEntity memberEntity = defaultCheckOutAPI.getMemberRecord(memberEntity1.getMemberID());
        System.out.println("memberEntity" + memberEntity);
    }

}
