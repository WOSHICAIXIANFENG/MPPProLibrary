package com.mpp.project.library.db.service;

import com.mpp.project.library.db.entity.StaffEntity;
import com.mpp.project.library.db.entity.StaffEntityDao;

import java.util.List;

/**
 * Created by Samuel on 8/3/17.
 */

public class StaffService {
    private static StaffService instance;
    private StaffEntityDao staffEntityDao;

    private StaffService() {
        staffEntityDao = ServiceFactory.getInstance().daoSession.getStaffEntityDao();
    }

    public synchronized static StaffService getInstance() {
        if (instance == null) {
            instance = new StaffService();
        }
        return instance;
    }

    /**
     * @Description: clear this Service instance
     */
    public static void closeService() {
        instance = null;
    }

    /**
     *
     * @param userName
     * @param password
     * @return permits
     */
    public String login(String userName, String password) {
        List<StaffEntity>  staffEntities = staffEntityDao.queryBuilder().where(StaffEntityDao.Properties.UserName.eq(userName), StaffEntityDao.Properties.Password.eq(password)).list();
        if (staffEntities.isEmpty()) {
            return null;
        }

        return staffEntities.get(0).getPermits();
    }

    public void addStaff(StaffEntity staffEntity) {
        staffEntityDao.insert(staffEntity);
    }
}
