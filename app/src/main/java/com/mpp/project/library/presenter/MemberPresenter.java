package com.mpp.project.library.presenter;

import com.mpp.project.library.R;
import com.mpp.project.library.db.entity.MemberEntity;
import com.mpp.project.library.db.service.MemberService;
import com.mpp.project.library.db.service.ServiceFactory;
import com.mpp.project.library.ui.IMemberView;

/**
 * Created by Samuel on 7/3/17.
 */

public class MemberPresenter {
    private IMemberView mView;
    private MemberService mMemberService;

    public MemberPresenter(IMemberView context) {
        this.mView = context;
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
            mView.showFailMsg(R.string.str_tip_not_found_member);
        } else {
            mView.showMemberDetails(memberEntity);
        }

        return  memberEntity;
    }
}
