package com.mpp.project.library.presenter;

import com.mpp.project.datasource.APIHelper;
import com.mpp.project.datasource.memberEntity.MemberEntity;
import com.mpp.project.library.ui.IMemberView;

/**
 * Created by Samuel on 7/3/17.
 */

public class MemberPresenter {
    private IMemberView mView;

    public MemberPresenter(IMemberView context) {
        this.mView = context;
    }

    public void addOneMember(String memberId, String firstName, String lastName, String phone, String street, String state, String city, String zip) {
//        MemberEntity memberEntity = new MemberEntity();
//        memberEntity.setMemberID(memberId);
//
//        APIHelper.getInstance().addMember();
    }

    public MemberEntity getMemberById(String memberId) {
        return APIHelper.getInstance().getMemberRecord(memberId);
    }

//    public void udpateMember(String memberId, String firstName, String lastName, String phone, String street, String state, String city, String zip) {
//        APIHelper.getInstance().
//        mMemberService.editOneMember(memberId, city);
//    }
}
