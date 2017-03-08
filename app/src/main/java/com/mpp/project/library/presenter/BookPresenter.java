package com.mpp.project.library.presenter;

import com.mpp.project.datasource.APIHelper;
import com.mpp.project.datasource.bookEntity.Author;
import com.mpp.project.datasource.bookEntity.BookEntity;
import com.mpp.project.library.R;
import com.mpp.project.library.ui.IBookView;

import java.util.List;

/**
 * Created by Samuel on 8/3/17.
 */

public class BookPresenter {
    private IBookView iBookView;

    public BookPresenter(IBookView iBookView) {
        this.iBookView = iBookView;
    }

    public void addOneBook(String title, String isbn, String copy,
                           String availability, String keep_days, String bookID,
                           String borrower, List<Author> authors) {
        BookEntity bookEntity = new BookEntity(title, isbn, copy, availability, keep_days, bookID, borrower, authors );
        APIHelper.getInstance().addBook(bookEntity);
        // todo

        if (true) {
            iBookView.showSuccessMsgOnPage(R.string.action_add_author);
        }
    }
}
