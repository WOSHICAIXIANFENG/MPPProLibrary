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

public class BookPresenter extends BasePresenter {
    private IBookView iBookView;

    public BookPresenter(IBookView iBookView) {
        this.iBookView = iBookView;
    }

    public void addOneBook(final String title, final String isbn,final String copyNum,
                           final String availability,final String keep_days, final String bookID,
                           final List<Author> authors) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                BookEntity bookEntity = new BookEntity(title, isbn, copyNum, availability, keep_days, bookID, authors );
                APIHelper.getInstance().addBook(bookEntity);
                iBookView.showMsg(R.string.str_tip_add_book_success);
                iBookView.clearInputFields();
            }
        }).start();
    }

    public void searchBookByISBN(final String isbn) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<BookEntity> bookEntities = APIHelper.getInstance().getBooksFromISBN(isbn);
                if (!bookEntities.isEmpty()) {
                    iBookView.showBookDetails(bookEntities.get(0));
                } else {
                    iBookView.showMsg(R.string.str_tip_not_found_book);
                    iBookView.clearBookDetails();
                }
            }
        }).start();
    }

    public void addOneCopyForBook(final BookEntity bookEntity) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String copyNum = bookEntity.getCopy();
                int numbers = 0;
                try {
                    numbers = Integer.parseInt(copyNum);
                } catch (Exception e) {

                }

                bookEntity.setCopy((numbers + 1) + "");
                APIHelper.getInstance().editBook(bookEntity);

                iBookView.showMsg(R.string.str_tip_add_copy_success);
                iBookView.showBookDetails(bookEntity);
            }
        }).start();
    }
}
