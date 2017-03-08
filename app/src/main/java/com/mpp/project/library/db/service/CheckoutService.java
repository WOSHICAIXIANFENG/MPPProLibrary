package com.mpp.project.library.db.service;

import com.mpp.project.library.db.entity.CheckOutEntityDao;

/**
 * Created by Samuel on 8/3/17.
 */

public class CheckoutService {
    private static CheckoutService instance;
    private CheckOutEntityDao checkOutEntityDao;

    private CheckoutService() {
        checkOutEntityDao = ServiceFactory.getInstance().daoSession.getCheckOutEntityDao();
    }

    public synchronized static CheckoutService getInstance() {
        if (instance == null) {
            instance = new CheckoutService();
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
