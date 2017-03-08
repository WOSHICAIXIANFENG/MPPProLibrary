package com.mpp.project.library.db.service;

import com.mpp.project.library.db.entity.AuthorEntityDao;
import com.mpp.project.library.db.entity.BookEntity;
import com.mpp.project.library.db.entity.BookEntityDao;

import java.util.List;

/**
 * Created by Samuel on 8/3/17.
 */

public class BookService {
    private static BookService instance;
    private BookEntityDao bookEntityDao;
    private AuthorEntityDao authorEntityDao;

    private BookService() {
        bookEntityDao = ServiceFactory.getInstance().daoSession.getBookEntityDao();
        authorEntityDao = ServiceFactory.getInstance().daoSession.getAuthorEntityDao();
    }

    public synchronized static BookService getInstance() {
        if (instance == null) {
            instance = new BookService();
        }
        return instance;
    }

    /**
     * @Description: clear this Service instance
     */
    public static void closeService() {
        instance = null;
    }

    public void addOneBook(BookEntity bookEntity) {
        // step1: save author list first


        // step2: save book entity late
        bookEntityDao.insert(bookEntity);
    }

    public List<BookEntity> getBookEntityList() {
        return bookEntityDao.queryBuilder().list();
    }
}
