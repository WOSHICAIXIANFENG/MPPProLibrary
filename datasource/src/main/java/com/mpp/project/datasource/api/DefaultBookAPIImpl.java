package com.mpp.project.datasource.api;

import com.mpp.project.datasource.entity.BookEntity;

import java.util.List;

/**
 * Created by hongleyou on 2017/3/6.
 */

public class DefaultBookAPIImpl implements BookAPI {

    @Override
    public void addBook(BookEntity bookEntity) {

    }

    @Override
    public void editBook(BookEntity bookEntity) {

    }

    @Override
    public void removeBook(String bookID) {

    }

    @Override
    public BookEntity getBook(String bookID) {
        return null;
    }

    @Override
    public List<BookEntity> searchBook(String name) {
        return null;
    }

    @Override
    public List<BookEntity> getBookCopys(String bookName) {
        return null;
    }
}
