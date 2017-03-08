package com.mpp.project.library;

import android.app.Application;

/**
 * Created by Samuel on 6/3/17.
 */

public class MApplication extends Application {
    private static MApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        initialSomeData();
    }

    public static MApplication getInstance() {
        return mInstance;
    }

    private void initialSomeData() {
//        boolean hasInitial = SPUtil.getBooleanPreferences(this, AppConfig.KEY_SP_HAS_INITIAL);
//        if (!hasInitial) {
//            StaffEntity staff1 = new StaffEntity();
//            staff1.setUserName("administrator");
//            staff1.setPassword("123456");
//            staff1.setFirstName("administrator");
//            staff1.setLastName("norml");
//            staff1.setPermits(AppConfig.PERMISSION_ADMIN);
//            ServiceFactory.getStaffService().addStaff(staff1);
//
//            StaffEntity staff2 = new StaffEntity();
//            staff2.setUserName("librarian");
//            staff2.setPassword("123456");
//            staff2.setFirstName("librarian");
//            staff2.setLastName("norml");
//            staff2.setPermits(AppConfig.PERMISSION_LIBRARIAN);
//            ServiceFactory.getStaffService().addStaff(staff2);
//
//            StaffEntity staff3 = new StaffEntity();
//            staff3.setUserName("superadmin");
//            staff3.setPassword("123456");
//            staff3.setFirstName("administrator");
//            staff3.setLastName("super");
//            staff3.setPermits(AppConfig.PERMISSION_BOTH);
//            ServiceFactory.getStaffService().addStaff(staff3);
//
//            // pre load some books
//            // todo...
//
//
//            SPUtil.setBooleanPreferences(this, AppConfig.KEY_SP_HAS_INITIAL, true);
//        }
    }
}
