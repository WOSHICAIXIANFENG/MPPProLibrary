package com.mpp.project.library.ui;

import com.mpp.project.datasource.bookEntity.BookEntity;

/**
 * Created by Samuel on 8/3/17.
 */

public interface IBookView {
    void showMsg(int msgId);

    void clearInputFields();

    void showBookDetails(BookEntity bookEntity);

    void clearBookDetails();
}
