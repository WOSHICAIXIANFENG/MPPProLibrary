package com.mpp.project.datasource.api;

import com.mpp.project.datasource.json.JsonPaser;
import com.mpp.project.datasource.memberEntity.MemberEntity;
import com.mpp.project.datasource.memberEntity.Record;
import com.mpp.project.datasource.redis.RedisHelper;

import java.util.List;

/**
 * Created by hongleyou on 2017/3/6.
 */

public class DefaultCheckOutAPIImpl implements CheckOutAPI {
    private RedisHelper reditHelper;
    private JsonPaser jsonPaser;

    public DefaultCheckOutAPIImpl(RedisHelper reditHelper, JsonPaser jsonPaser) {
        this.reditHelper = reditHelper;
        this.jsonPaser = jsonPaser;
    }

    @Override
    public void addMember(MemberEntity memberEntity) {
        if(memberEntity == null || checkMemberID(memberEntity.getMemberID()))
            return;

        String jsonStr = jsonPaser.MemberEntityToJson(memberEntity);
        reditHelper.SetInfo(memberEntity.getMemberID(), jsonStr);
    }

    public void editMember(MemberEntity memberEntity) {
        if (memberEntity == null)
            return;

        String jsonStr = jsonPaser.MemberEntityToJson(memberEntity);
        reditHelper.SetInfo(memberEntity.getMemberID(), jsonStr);
    }

    @Override
    public void removeMember(String memberID) {
        if (memberID == null || !checkMemberID(memberID))
            return;

        reditHelper.RemoveInfo(memberID);
    }

    @Override
    public boolean checkMemberID(String memberID) {
        return reditHelper.HasKey(memberID);
    }

    public MemberEntity getMemberRecord(String memberID) {
        if(!checkMemberID(memberID))
            return null;

        String jsonStr = reditHelper.GetInfo(memberID);
        return jsonPaser.JsonToMemberEntity(jsonStr);
    }
}
