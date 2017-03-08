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
                    List<CheckoutBean> dataSet = convertRecordList(memberEntity);
                    iCheckoutView.showCheckoutRecord(memberEntity, dataSet);
                    iCheckoutView.showSearchBookLayout();
                } else {
                    iCheckoutView.showMsg(R.string.str_tip_not_found_member);
                    iCheckoutView.clearRecordList();
                }
            }
        }).start();
    }

    private List<CheckoutBean> convertRecordList(MemberEntity memberEntity) {
        List<Record> recordList = memberEntity.getRecords();
        List<CheckoutBean> dataSet = new ArrayList<>();

        for (int i = 0; i < recordList.size(); i ++) {
            Record record = recordList.get(recordList.size() - i - 1);
            BookEntity bookEntity = APIHelper.getInstance().getBookFromBookID(record.getBookID());
            String bookTitle = bookEntity.getTitle();
            dataSet.add(new CheckoutBean(record.getBookID(), bookTitle, record.getCheckOutDay()));
        }
        return dataSet;
    }

    public void searchBookByISBN(final String isbn) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<BookEntity> bookEntities = APIHelper.getInstance().getBooksFromISBN(isbn);
                boolean isAvaliable = false;
                BookEntity dest = null;
                for (BookEntity bookEntity : bookEntities) {
                    if ("Yes".equals(bookEntity.getAvailability())) {
                        isAvaliable = true;
                        dest = bookEntity;
                        break;
                    }
                }

                if (isAvaliable) {
                    iCheckoutView.showBookEntityOnPage(dest);
                    // show Checkout Button
                    iCheckoutView.showCheckOutSubmitBtn();
                } else {
                    iCheckoutView.showMsg(R.string.str_tip_book_un_available);
                    iCheckoutView.clearBookDetails();
                }
            }
        }).start();
    }

    public void doCheckoutLogic(final BookEntity bookEntity, final MemberEntity memberEntity) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String keepDays = bookEntity.getKeep_days();
                int days = 21;
                try {
                    days = Integer.parseInt(keepDays);
                } catch (Exception e) {

                }

                Record record = new Record(
                        bookEntity.getIsbn(),
                        bookEntity.getBookID(),
                        "2017-03-10",
                        "2017-03-31",
                        0, 0);

                List<Record> records = memberEntity.getRecords();
                if (records != null) {
                    records.add(record);
                }

                // add one record
                APIHelper.getInstance().editMember(memberEntity);
                List<CheckoutBean> dataSet = convertRecordList(memberEntity);
                iCheckoutView.showCheckoutRecord(memberEntity, dataSet);
                iCheckoutView.clearBookDetails();
                iCheckoutView.hideCheckOutSubmitBtn();
                iCheckoutView.showMsg(R.string.str_tip_checkout_success);
            }
        }).start();
    }
}
