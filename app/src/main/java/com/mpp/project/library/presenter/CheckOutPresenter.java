package com.mpp.project.library.presenter;

import com.mpp.project.library.ui.ICheckoutView;

/**
 * Created by Samuel on 8/3/17.
 */

public class CheckOutPresenter {
    private ICheckoutView iCheckoutView;

    public CheckOutPresenter(ICheckoutView context) {
        this.iCheckoutView = context;
    }

    public void searchCheckOutListById(String memberId) {
//        MemberEntity memberEntity = ServiceFactory.getMemberService().getMemberById(memberId);
//        if (memberEntity != null) {
//            //...
//
//        } else {
//            //
//            iCheckoutView.showFailMsg(R.string.action_add_author);
//        }

        // // TODO: 8/3/17
    }
}
