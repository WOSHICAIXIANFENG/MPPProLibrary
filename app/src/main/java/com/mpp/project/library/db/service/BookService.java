package com.mpp.project.library.db.service;

import com.mpp.project.library.db.entity.BookEntityDao;

/**
 * Created by Samuel on 8/3/17.
 */

public class BookService {
    private static BookService instance;
    private BookEntityDao bookEntityDao;

    private BookService() {
        bookEntityDao = ServiceFactory.getInstance().daoSession.getBookEntityDao();
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


}
