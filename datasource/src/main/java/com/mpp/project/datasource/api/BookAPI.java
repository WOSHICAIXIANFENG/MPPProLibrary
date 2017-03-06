package com.mpp.project.datasource.api;

import com.mpp.project.datasource.entity.BookEntity;

/**
 * Created by Samuel on 6/3/17.
 */
public abstract interface BookAPI {
    void addBook(BookEntity bookEntity);

    void editBook(BookEntity bookEntity);
}
