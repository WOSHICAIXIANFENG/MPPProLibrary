package com.mpp.project.datasource.api;

import com.mpp.project.datasource.bookEntity.BookEntity;

import java.util.List;

/**
 * Created by Samuel on 6/3/17.
 */
public abstract interface BookAPI {
    void addBook(BookEntity bookEntity);

    void editBook(BookEntity bookEntity);

    void removeBook(String bookID);

    BookEntity getBook(String bookID);

    List<BookEntity> searchBook(String pattern);

    List<BookEntity> getBookCopys(String bookName);
}
