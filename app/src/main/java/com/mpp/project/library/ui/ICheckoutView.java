package com.mpp.project.library.ui;

import com.mpp.project.datasource.bookEntity.BookEntity;
import com.mpp.project.datasource.memberEntity.MemberEntity;
import com.mpp.project.library.bean.CheckoutBean;

import java.util.List;

/**
 * Created by Samuel on 8/3/17.
 */

public interface ICheckoutView {
    void showMsg(int msgId);

    void showCheckoutRecord(MemberEntity memberEntity, List<CheckoutBean> records);

    void showBookEntityOnPage(BookEntity bookEntity);

    void hideSearchBookLayout();
    void showSearchBookLayout();

    void clearRecordList();
    void clearBookDetails();

    void showCheckOutSubmitBtn();
    void hideCheckOutSubmitBtn();
}
