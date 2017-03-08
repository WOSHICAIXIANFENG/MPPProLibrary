package com.mpp.project.library.ui;

import com.mpp.project.datasource.memberEntity.MemberEntity;

/**
 * Created by Samuel on 8/3/17.
 */

public interface IMemberView {
    void showMsg(int msgId);

    void clearInputData();

    void hideEditSaveBtn();
    void showEditSaveBtn();
    void showEditBtnFromSave();

    void showMemberDetails(MemberEntity memberEntity);
}
