package com.mpp.project.library.db.service;

import com.mpp.project.library.db.entity.MemberEntityDao;

/**
 * Created by Samuel on 8/3/17.
 */

public class MemberService {
    private static MemberService instance;
    private MemberEntityDao memberEntityDao;

    private MemberService() {
        memberEntityDao = ServiceFactory.getInstance().daoSession.getMemberEntityDao();
    }

    public synchronized static MemberService getInstance() {
        if (instance == null) {
            instance = new MemberService();
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
