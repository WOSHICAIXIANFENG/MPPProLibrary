package com.mpp.project.library.presenter;

import com.mpp.project.datasource.APIHelper;
import com.mpp.project.datasource.bookEntity.BookEntity;
import com.mpp.project.datasource.memberEntity.MemberEntity;
import com.mpp.project.datasource.memberEntity.Record;
import com.mpp.project.library.R;
import com.mpp.project.library.bean.CheckoutBean;
import com.mpp.project.library.ui.ICheckoutView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Samuel on 8/3/17.
 */

public class CheckOutPresenter {
    private ICheckoutView iCheckoutView;

    public CheckOutPresenter(ICheckoutView context) {
        this.iCheckoutView = context;
    }

    public void searchCheckOutListById(final String memberId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                MemberEntity memberEntity = APIHelper.getInstance().getMemberRecord(memberId);
                if (memberEntity != null) {
                    List<Record> recordList = memberEntity.getRecords();

                    List<CheckoutBean> dataSet = new ArrayList<>();
                    for (Record record : recordList) {
                        BookEntity bookEntity = APIHelper.getInstance().getBookFromBookID(record.getBookID());
                        String bookTitle = bookEntity.getTitle();
                        dataSet.add(new CheckoutBean(record.getBookID(), bookTitle, record.getCheckOutDay()));
                    }

                    iCheckoutView.showCheckoutRecord(dataSet);
                } else {
                    iCheckoutView.showFailMsg(R.string.str_tip_not_found_member);
                }
            }
        }).start();
    }
}
