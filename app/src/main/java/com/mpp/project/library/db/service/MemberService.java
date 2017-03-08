package com.mpp.project.library.db.service;

import com.mpp.project.library.db.entity.MemberEntity;
import com.mpp.project.library.db.entity.MemberEntityDao;

import java.util.List;

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

    public void addOneMember(MemberEntity memberEntity) {
        memberEntityDao.insert(memberEntity);
    }

    public MemberEntity getMemberById(String memberId) {
        List<MemberEntity> memberEntities = memberEntityDao.queryBuilder().where(MemberEntityDao.Properties.MemberId.eq(memberId)).list();
        if (memberEntities != null && memberEntities.size() > 0) {
            return memberEntities.get(0);
        }
        return null;
    }

}
