package com.mpp.project.datasource.bookEntity;
import java.io.Serializable;
import java.util.List;
/**
 * Created by hongleyou on 6/3/17.
 */

public class BookEntity implements Serializable {
    private String title;
    private String isbn;
    private String copy;
    private String availability;
    private String keep_days;
    private String bookID;
    private List<Author> authors;

    public BookEntity(String title, String isbn, String copy,
             String availability, String keep_days, String bookID,
             List<Author> authors) {

        this.title = title;
        this.isbn = isbn;
        this.copy = copy;
        this.availability = availability;
        this.keep_days = keep_days;
        this.bookID = bookID;
        this.authors = authors;
    }

    public String getBookID() {
        return bookID;
    }

    public String getTitle() { return title; }

    public String getIsbn() { return isbn; }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getCopy() {
        return copy;
    }

    public void setCopy(String copy) {
        this.copy = copy;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getKeep_days() {
        return keep_days;
    }

    public void setKeep_days(String keep_days) {
        this.keep_days = keep_days;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "BookInfo{" +
                "title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", copy='" + copy + '\'' +
                ", availability='" + availability + '\'' +
                ", keep_days='" + keep_days + '\'' +
                ", bookID='" + bookID + '\'' +
                ", authors=" + authors +
                '}';
    }
}
