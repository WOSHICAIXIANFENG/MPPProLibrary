package com.mpp.project.library.business;

import com.mpp.project.library.entity.BookEntity;
import com.mpp.project.library.entity.LendableCopyEntity;

/**
 * Created by yangyangli on 3/7/17.
 */

public interface IaddLendableCopy extends IPermit {
    void AddLendableCopy(LendableCopyEntity lendableCopyEntity);
}
