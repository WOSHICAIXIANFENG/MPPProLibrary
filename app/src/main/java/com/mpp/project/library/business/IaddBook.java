package com.mpp.project.library.business;

import com.mpp.project.library.entity.BookEntity;

/**
 * Created by yangyangli on 3/7/17.
 */

public interface IaddBook extends IPermit {
    void AddBook(BookEntity bookEntity);
}
