package com.mpp.project.library.presenter;

import android.app.Fragment;

import com.mpp.project.library.db.entity.MemberEntity;
import com.mpp.project.library.db.service.MemberService;
import com.mpp.project.library.db.service.ServiceFactory;

/**
 * Created by Samuel on 7/3/17.
 */

public class MemberPresenter {
    private Fragment mContext;
    private MemberService mMemberService;

    public MemberPresenter(Fragment context) {
        this.mContext = context;
        this.mMemberService = ServiceFactory.getMemberService();
    }

    public void addOneMember(String memberId, String firstName, String lastName, String phone, String street, String state, String city, String zip) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setMemberId(memberId);
        memberEntity.setFirstName(firstName);
        memberEntity.setLastName(lastName);
        memberEntity.setPhone(phone);

        memberEntity.setState(state);
        memberEntity.setStreet(street);
        memberEntity.setCity(city);
        memberEntity.setZip(zip);

        mMemberService.addOneMember(memberEntity);
    }

    public MemberEntity getMemberById(String memberId) {
        MemberEntity memberEntity = mMemberService.getMemberById(memberId);
        if (memberEntity == null) {
            // not found memberId
        } else {

        }

        return  memberEntity;
    }
}
