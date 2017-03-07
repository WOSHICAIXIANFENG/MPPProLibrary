package com.mpp.project.datasource.api;

import com.mpp.project.datasource.bookEntity.BookEntity;

import java.util.List;

/**
 * Created by Samuel on 6/3/17.
 */
public abstract interface BookAPI {

    String getBookID();

    boolean checkBookID(String bookID);

    boolean hasCopys(String isbn);

    void addBook(BookEntity bookEntity);

    void editBook(BookEntity bookEntity);

    void removeBook(String bookID);

    BookEntity getBookFromBookID(String bookID);

    List<BookEntity> getBooksFromISBN(String isbn);

    List<BookEntity> searchBook(String pattern);

    List<BookEntity> getBookCopys(String key);
}
