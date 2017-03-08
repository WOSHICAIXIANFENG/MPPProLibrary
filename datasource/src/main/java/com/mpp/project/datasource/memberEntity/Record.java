package com.mpp.project.datasource.memberEntity;

/**
 * Created by hongleyou on 2017/3/6.
 */

public class Record {
    private String isbn;
    private String bookID;
    private String checkOutDay;
    private String dueDay;
    private int laterDays;
    private double fine;

    public Record(String isbn, String bookID,String checkOutDay, String dueDay, String returnOnTime, int laterDays, double fine) {
        this.isbn = isbn;
        this.bookID = bookID;
        this.checkOutDay = checkOutDay;
        this.dueDay = dueDay;
        this.laterDays = laterDays;
        this.fine = fine;
    }

    @Override
    public String toString() {
        return "Record{" +
                "isbn='" + isbn + '\'' +
                ", bookID='" + bookID + '\'' +
                ", checkOutDay='" + checkOutDay + '\'' +
                ", dueDay='" + dueDay + '\'' +
                ", laterDays=" + laterDays +
                ", fine=" + fine +
                '}';
    }
}
