package com.mpp.project.library.db.service;

import android.database.sqlite.SQLiteDatabase;

import com.mpp.project.library.AppConfig;
import com.mpp.project.library.MApplication;
import com.mpp.project.library.db.entity.DaoMaster;
import com.mpp.project.library.db.entity.DaoSession;


/**
 * @author: Samuel.Cai
 */
public class ServiceFactory {
    protected String LOG_TAG = getClass().getSimpleName();

    protected DaoMaster.DevOpenHelper helper = null;
    protected SQLiteDatabase db;
    protected DaoMaster daoMaster;
    protected DaoSession daoSession;

    protected ServiceFactory() {
        helper = new DaoMaster.DevOpenHelper(MApplication.getInstance(), AppConfig.DB_NAME, null);
        db = helper.getWritableDatabase();
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    private static ServiceFactory single = null;

    public synchronized static ServiceFactory getInstance() {
        if (single == null) {
            single = new ServiceFactory();
        }
        return single;
    }

    /**
     * @return the daoSession
     */
    public DaoSession getDaoSession() {
        return daoSession;
    }

    public static StaffService getStaffService() {
        return StaffService.getInstance();
    }

    public static BookService getBookService() {
        return BookService.getInstance();
    }

    public static CheckoutService getCheckoutService() {
        return CheckoutService.getInstance();
    }

    public static MemberService getMemberService() {
        return MemberService.getInstance();
    }

    /**
     * @Description: Close all service instance, when user logout
     * add this method to fix bug: Sometimes the app can't load orders when user login again after logout(we clear all local data when logout).
     * Reason: there is some data be cached in service(daoSession, daoMaster)
     * @author: Samuel.Cai
     */
    public void closeAllService() {
        StaffService.closeService();
        BookService.closeService();
        CheckoutService.closeService();
        MemberService.closeService();

        daoSession.clear();
        db.close();
        helper.close();

        single = null;
    }

    public void clearAllDataOfDB() {
        daoSession.getStaffEntityDao().deleteAll();
        daoSession.getBookEntityDao().deleteAll();
        daoSession.getCheckOutEntityDao().deleteAll();
        daoSession.getMemberEntityDao().deleteAll();
    }
}
