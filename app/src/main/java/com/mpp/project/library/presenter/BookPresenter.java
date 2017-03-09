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

    public void addOneBook(final String title, final String isbn,final String copy,
                           final String availability,final String keep_days, final String bookID,
                           final List<Author> authors) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                BookEntity bookEntity = new BookEntity(title, isbn, copy, availability, keep_days, bookID, authors );
                APIHelper.getInstance().addBook(bookEntity);

                iBookView.showMsg(R.string.str_tip_add_book_success);
                iBookView.clearInputFields();
            }
        }).start();
    }
}
