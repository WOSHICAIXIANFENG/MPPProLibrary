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

    public Record(String isbn, String bookID, String checkOutDay, String dueDay, int laterDays, double fine) {
        this.isbn = isbn;
        this.bookID = bookID;
        this.checkOutDay = checkOutDay;
        this.dueDay = dueDay;
        this.laterDays = laterDays;
        this.fine = fine;
    }

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getCheckOutDay() {
        return checkOutDay;
    }

    public void setCheckOutDay(String checkOutDay) {
        this.checkOutDay = checkOutDay;
    }

    public String getDueDay() {
        return dueDay;
    }

    public void setDueDay(String dueDay) {
        this.dueDay = dueDay;
    }

    public int getLaterDays() {
        return laterDays;
    }

    public void setLaterDays(int laterDays) {
        this.laterDays = laterDays;
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
