package com.mpp.project.library.ui.bean;

import com.mpp.project.datasource.memberEntity.Record;

/**
 * Created by Samuel on 8/3/17.
 */

public class CheckoutBean {
    private String bookId;
    private String bookTitle;
    private String date;// yyyy-mm-dd --- checkout

    public CheckoutBean(String bookId, String bookTitle, String date) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.date = date;
    }

    public CheckoutBean(Record record) {
        this.bookId = record.getBookID();
        //this.bookTitle = record.get;
        this.date = record.getCheckOutDay();
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
