package com.mpp.project.library.presenter;

import android.content.Context;

import com.mpp.project.datasource.APIHelper;
import com.mpp.project.datasource.staff.Staff;
import com.mpp.project.library.AppConfig;
import com.mpp.project.library.util.SPUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * Controller
 * Created by yangyangli on 3/6/17.
 */
public class LoginPresenter {
    private Context mContext;

    public LoginPresenter(Context context) {
        this.mContext = context;
    }

    public boolean login(String userName, String pwd) {
        Staff staff = APIHelper.getInstance().login(userName, pwd);
        if (staff != null) {
            // login success
            Set<String> permits = new HashSet<>(staff.getPermits());
            SPUtil.setStringSetPreferences(mContext, AppConfig.KEY_SP_PERMISSION_LIST, permits);
            SPUtil.setBooleanPreferences(mContext, AppConfig.KEY_SP_HAS_LOGIN, true);
        } else {
            // login fail
            SPUtil.setBooleanPreferences(mContext, AppConfig.KEY_SP_HAS_LOGIN, false);
        }

        return staff != null;
    }
}
