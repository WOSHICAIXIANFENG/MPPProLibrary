package com.mpp.project.library.db.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Samuel on 8/3/17.
 */
@Entity
public class BookEntity {
    @Id(autoincrement = true)
    private Long id;

    private String bookID;
    private String isbn;
    private String title;
    private boolean isAvailable;// 是否借出
    private int rentDays;// 7 or 21 maximum checkout length
    private int copyNum;// at least 1

    // for book's copy
    private boolean isCopy;
    private boolean copyNumber;// unique
    public boolean getCopyNumber() {
        return this.copyNumber;
    }
    public void setCopyNumber(boolean copyNumber) {
        this.copyNumber = copyNumber;
    }
    public boolean getIsCopy() {
        return this.isCopy;
    }
    public void setIsCopy(boolean isCopy) {
        this.isCopy = isCopy;
    }
    public int getCopyNum() {
        return this.copyNum;
    }
    public void setCopyNum(int copyNum) {
        this.copyNum = copyNum;
    }
    public int getRentDays() {
        return this.rentDays;
    }
    public void setRentDays(int rentDays) {
        this.rentDays = rentDays;
    }
    public boolean getIsAvailable() {
        return this.isAvailable;
    }
    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getIsbn() {
        return this.isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getBookID() {
        return this.bookID;
    }
    public void setBookID(String bookID) {
        this.bookID = bookID;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 938545160)
    public BookEntity(Long id, String bookID, String isbn, String title,
            boolean isAvailable, int rentDays, int copyNum, boolean isCopy,
            boolean copyNumber) {
        this.id = id;
        this.bookID = bookID;
        this.isbn = isbn;
        this.title = title;
        this.isAvailable = isAvailable;
        this.rentDays = rentDays;
        this.copyNum = copyNum;
        this.isCopy = isCopy;
        this.copyNumber = copyNumber;
    }
    @Generated(hash = 1373651409)
    public BookEntity() {
    }

}
