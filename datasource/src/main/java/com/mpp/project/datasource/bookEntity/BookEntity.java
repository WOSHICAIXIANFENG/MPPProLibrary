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
    private String borrower;
    private List<Author> authors;

    BookEntity(String title, String isbn, String copy,
             String availability, String keep_days, String bookID,
             String borrower, List<Author> authors) {
        this.title = title;
        this.isbn = isbn;
        this.copy = copy;
        this.availability = availability;
        this.keep_days = keep_days;
        this.bookID = bookID;
        this.borrower = borrower;
        this.authors = authors;
    }

    public String getBookID() {
        return bookID;
    }

    public String getTitle() { return title; }

    @Override
    public String toString() {
        return "BookInfo{" +
                "title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", copy='" + copy + '\'' +
                ", availability='" + availability + '\'' +
                ", keep_days='" + keep_days + '\'' +
                ", bookID='" + bookID + '\'' +
                ", borrower='" + borrower + '\'' +
                ", authors=" + authors +
                '}';
    }
}
