package com.mpp.project.library.db.service;

import com.mpp.project.library.db.entity.BookEntity;
import com.mpp.project.library.db.entity.CheckOutEntity;
import com.mpp.project.library.db.entity.CheckOutEntityDao;
import com.mpp.project.library.db.entity.MemberEntity;

import java.util.List;

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

    public void checkOutOneBook(MemberEntity memberEntity, BookEntity bookEntity) {
        CheckOutEntity checkOutEntity = new CheckOutEntity();
        checkOutEntity.setMemberId(memberEntity.getMemberId());
        checkOutEntity.setBookID(bookEntity.getBookID());
        // todo ....

        checkOutEntityDao.insert(checkOutEntity);
    }

    public List<CheckOutEntity> getCheckOutRecordById(String memberId) {
        return checkOutEntityDao.queryBuilder().where(CheckOutEntityDao.Properties.MemberId.eq(memberId)).list();
    }
}
