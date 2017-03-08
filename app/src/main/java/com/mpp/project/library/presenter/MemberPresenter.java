package com.mpp.project.library.presenter;

import com.mpp.project.datasource.APIHelper;
import com.mpp.project.datasource.memberEntity.MemberEntity;
import com.mpp.project.datasource.memberEntity.Record;
import com.mpp.project.library.R;
import com.mpp.project.library.ui.IMemberView;

import java.util.ArrayList;

/**
 * Created by Samuel on 7/3/17.
 */

public class MemberPresenter {
    private IMemberView mMemberView;

    public MemberPresenter(IMemberView context) {
        this.mMemberView = context;
    }

    public void addOneMember(final String memberId, final String firstName, final String lastName, final String phone,
                             final String street, final String state, final String city, final String zip) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                MemberEntity memberEntity = new MemberEntity(memberId, firstName, lastName, phone,
                        street, zip, city, state, new ArrayList<Record>());

                APIHelper.getInstance().addMember(memberEntity);
                mMemberView.showMsg(R.string.str_tip_add_member_success);
                mMemberView.clearInputData();
            }
        }).start();
    }

    public MemberEntity getMemberById(String memberId) {
        return APIHelper.getInstance().getMemberRecord(memberId);
    }

//    public void udpateMember(String memberId, String firstName, String lastName, String phone, String street, String state, String city, String zip) {
//        APIHelper.getInstance().
//        mMemberService.editOneMember(memberId, city);
//    }
}
