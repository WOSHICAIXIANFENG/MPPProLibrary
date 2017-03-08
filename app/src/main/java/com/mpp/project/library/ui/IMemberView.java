package com.mpp.project.library.ui;

import com.mpp.project.library.db.entity.MemberEntity;

/**
 * Created by Samuel on 8/3/17.
 */

public interface IMemberView {
    void showFailMsg(int msgId);

    void showMemberDetails(MemberEntity memberEntity);
}
