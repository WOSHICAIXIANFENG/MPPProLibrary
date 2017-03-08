package com.mpp.project.library.business;

import com.mpp.project.library.entity.MemberEntity;

/**
 * Created by yangyangli on 3/7/17.
 */

public interface IaddMembership extends IPermit {
    void addMembership(MemberEntity memberEntity);
}
