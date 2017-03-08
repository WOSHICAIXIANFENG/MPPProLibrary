package com.mpp.project.library.db.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Samuel on 8/3/17.
 */
@Entity
public class CheckOutEntity {
    @Id(autoincrement = true)
    private Long id;

    private String memberId;
    private String bookID;
    private String bookTitle;
    private String copyNumber;// 因为借的只能是copy

    // mm-dd-yyyy
    private String checkoutDate;
    private String dueDate;
    public String getDueDate() {
        return this.dueDate;
    }
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
    public String getCheckoutDate() {
        return this.checkoutDate;
    }
    public void setCheckoutDate(String checkoutDate) {
        this.checkoutDate = checkoutDate;
    }
    public String getCopyNumber() {
        return this.copyNumber;
    }
    public void setCopyNumber(String copyNumber) {
        this.copyNumber = copyNumber;
    }
    public String getBookTitle() {
        return this.bookTitle;
    }
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
    public String getBookID() {
        return this.bookID;
    }
    public void setBookID(String bookID) {
        this.bookID = bookID;
    }
    public String getMemberId() {
        return this.memberId;
    }
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 1365271099)
    public CheckOutEntity(Long id, String memberId, String bookID,
            String bookTitle, String copyNumber, String checkoutDate, String dueDate) {
        this.id = id;
        this.memberId = memberId;
        this.bookID = bookID;
        this.bookTitle = bookTitle;
        this.copyNumber = copyNumber;
        this.checkoutDate = checkoutDate;
        this.dueDate = dueDate;
    }
    @Generated(hash = 1614959236)
    public CheckOutEntity() {
    }

}
