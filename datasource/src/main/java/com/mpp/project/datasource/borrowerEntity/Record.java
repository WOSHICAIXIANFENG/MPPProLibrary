package com.mpp.project.datasource.borrowerEntity;

/**
 * Created by hongleyou on 2017/3/6.
 */

public class Record {
    private String isbn;
    private String bookID;
    private String checkOutDay;
    private String dueDay;
    private String returnOnTime;
    private int laterDays;
    private double fine;

    public Record(String isbn, String checkOutDay, String dueDay, String returnOnTime, int laterDays, double fine) {
        this.isbn = isbn;
        this.checkOutDay = checkOutDay;
        this.dueDay = dueDay;
        this.returnOnTime = returnOnTime;
        this.laterDays = laterDays;
        this.fine = fine;
    }

    @Override
    public String toString() {
        return "Record{" +
                "isbn='" + isbn + '\'' +
                ", checkOutDay='" + checkOutDay + '\'' +
                ", dueDay='" + dueDay + '\'' +
                ", returnOnTime='" + returnOnTime + '\'' +
                ", laterDays=" + laterDays +
                ", fine=" + fine +
                '}';
    }
}
