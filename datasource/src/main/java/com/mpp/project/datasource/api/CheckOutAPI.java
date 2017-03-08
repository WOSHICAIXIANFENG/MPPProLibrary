package com.mpp.project.datasource.api;

import com.mpp.project.datasource.memberEntity.MemberEntity;
import com.mpp.project.datasource.memberEntity.Record;

import java.util.List;

/**
 * Created by hongleyou on 2017/3/6.
 */

public abstract interface CheckOutAPI {
    boolean checkMemberID(String memberID);

    void addMember(MemberEntity memberEntity);

    void editMember(MemberEntity memberEntity);

    void removeMember(String memberID);

    MemberEntity getMemberRecord(String memberID);
}
