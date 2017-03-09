package com.mpp.project.library;

/**
 * Created by Samuel on 7/3/17.
 */

public class AppConfig {
    public static final String DB_NAME = "Library_database";

    public static final String SHAREDPREFERENCE_NAME = "mpp_project";
    public static final String KEY_SP_PERMISSION_LIST = "permission_list";
    public static final String KEY_SP_HAS_LOGIN = "hasLogin";
    public static final String KEY_SP_HAS_INITIAL = "hasInitialData";

    public static final String KEY_SP_PHONE = "USER_PHONE";
    public static final String KEY_SP_USERNAME = "USER_NAME";

    // permission list
    public static final String PERMISSION_CHECKOUT = "PERMIT_CHECKOUT";

    public static final String PERMISSION_ADD_MEMBER = "PERMIT_ADD_MEMBER";
    public static final String PERMISSION_EDIT_MEMBER = "PERMIT_EDIT_MEMBER";
    public static final String PERMISSION_ADD_BOOK = "PERMIT_ADD_BOOK";
    public static final String PERMISSION_ADD_COPY_BOOK = "PERMIT_ADD_COPY";

    public static final String PERMISSION_HUMAN_MANAGER = "PERMIT_MANAGER_STAFF";
    public static final String PERMISSION_ALL = "PERMIT_ALL";

    // question's requirments
    //Authorization levels are LIBRARIAN, ADMIN, and BOTH
    public static final String PERMISSION_LIBRARIAN = "PERMIT_LIBRARIAN";
    public static final String PERMISSION_ADMIN = "PERMIT_ADMIN";
    public static final String PERMISSION_BOTH = "PERMIT_BOTH";
}
