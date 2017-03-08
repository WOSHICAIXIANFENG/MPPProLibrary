package com.mpp.project.library.ui;

/**
 * Created by Samuel on 8/3/17.
 */

public interface IMemberView {
    void showMsg(int msgId);

    void clearInputData();

    void hideSaveBtn();
    void showSaveBtn();

//    void showMemberDetails(MemberEntity memberEntity);
}
