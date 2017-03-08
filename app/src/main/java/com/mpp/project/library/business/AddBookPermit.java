package com.mpp.project.library.business;

import com.mpp.project.library.db.entity.BookEntity;
import com.mpp.project.library.db.service.BookService;
import com.mpp.project.library.db.service.ServiceFactory;

/**
 * Created by Samuel on 8/3/17.
 */

public class AddBookPermit implements IPermit {
    private BookEntity bookEntity;
    private BookService bookService;

    public AddBookPermit(BookEntity bookEntity) {
        this.bookEntity = bookEntity;
        this.bookService = ServiceFactory.getBookService();
    }

    @Override
    public void doMyWork() {
        // implement you logic
        // todo
        bookService.addOneBook(bookEntity);
    }
}
