package com.mpp.project.datasource;

import com.mpp.project.datasource.api.DefaultAuthAPIImpl;
import com.mpp.project.datasource.api.DefaultBookAPIImpl;
import com.mpp.project.datasource.api.DefaultCheckOutAPIImpl;
import com.mpp.project.datasource.bookEntity.BookEntity;
import com.mpp.project.datasource.json.JsonPaser;
import com.mpp.project.datasource.memberEntity.MemberEntity;
import com.mpp.project.datasource.redis.RedisHelper;
import com.mpp.project.datasource.staff.Staff;

import java.util.List;

/**
 * Created by Samuel on 7/3/17.
 */

public class APIHelper {
    private RedisHelper reditHelper;
    private JsonPaser jsonPaser;
    private static APIHelper instance;

    private APIHelper() {
        reditHelper = new RedisHelper("10.10.22.48", 6379);
        jsonPaser = new JsonPaser();
    }

    public static APIHelper getInstance() {
        if (instance == null) {
            instance = new APIHelper();
        }

        return instance;
    }

    public Staff login(String userName, String pwd) {
        DefaultAuthAPIImpl defaultAuthAPI = new DefaultAuthAPIImpl(reditHelper, jsonPaser);
        Staff staff = new Staff(userName, pwd);
        return defaultAuthAPI.login(staff);
    }

    public String changePasswd(String userName, String pwd, String newPasswd) {
        DefaultAuthAPIImpl defaultAuthAPI = new DefaultAuthAPIImpl(reditHelper, jsonPaser);
        Staff staff = new Staff(userName, pwd);
        return defaultAuthAPI.changePasswd(staff, pwd);
    }

    public String logout() {
        DefaultAuthAPIImpl defaultAuthAPI = new DefaultAuthAPIImpl(reditHelper, jsonPaser);
        return defaultAuthAPI.logout();
    }

    public String getBookID() {
        DefaultBookAPIImpl defaultBookAPI = new DefaultBookAPIImpl(reditHelper, jsonPaser);
        return defaultBookAPI.getBookID();
    }

    public boolean hasCopys(String isbn) {
        DefaultBookAPIImpl defaultBookAPI = new DefaultBookAPIImpl(reditHelper, jsonPaser);
        return defaultBookAPI.hasCopys(isbn);
    }

    public void addBook(BookEntity bookEntity) {
        DefaultBookAPIImpl defaultBookAPI = new DefaultBookAPIImpl(reditHelper, jsonPaser);
        defaultBookAPI.addBook(bookEntity);
    }

    public void editBook(BookEntity bookEntity) {
        DefaultBookAPIImpl defaultBookAPI = new DefaultBookAPIImpl(reditHelper, jsonPaser);
        defaultBookAPI.editBook(bookEntity);
    }

    public void removeBook(String bookID) {
        DefaultBookAPIImpl defaultBookAPI = new DefaultBookAPIImpl(reditHelper, jsonPaser);
        defaultBookAPI.removeBook(bookID);
    }

    public BookEntity getBookFromBookID(String bookID) {
        DefaultBookAPIImpl defaultBookAPI = new DefaultBookAPIImpl(reditHelper, jsonPaser);
        return defaultBookAPI.getBookFromBookID(bookID);
    }

    public List<BookEntity> getBooksFromISBN(String isbn) {
        DefaultBookAPIImpl defaultBookAPI = new DefaultBookAPIImpl(reditHelper, jsonPaser);
        return defaultBookAPI.getBooksFromISBN(isbn);
    }

    public List<BookEntity> searchBook(String pattern) {
        DefaultBookAPIImpl defaultBookAPI = new DefaultBookAPIImpl(reditHelper, jsonPaser);
        return defaultBookAPI.searchBook(pattern);
    }

    public List<BookEntity> getBookCopys(String key) {
        DefaultBookAPIImpl defaultBookAPI = new DefaultBookAPIImpl(reditHelper, jsonPaser);
        return defaultBookAPI.getBookCopys(key);
    }

    public boolean checkMemberID(String memberID) {
        DefaultCheckOutAPIImpl defaultCheckOutAPI = new DefaultCheckOutAPIImpl(reditHelper, jsonPaser);
        return defaultCheckOutAPI.checkMemberID(memberID);
    }

    public void addMember(MemberEntity memberEntity) {
        DefaultCheckOutAPIImpl defaultCheckOutAPI = new DefaultCheckOutAPIImpl(reditHelper, jsonPaser);
        defaultCheckOutAPI.addMember(memberEntity);
    }

    public void editMember(MemberEntity memberEntity) {
        DefaultCheckOutAPIImpl defaultCheckOutAPI = new DefaultCheckOutAPIImpl(reditHelper, jsonPaser);
        defaultCheckOutAPI.editMember(memberEntity);
    }

    public void removeMember(String memberID) {
        DefaultCheckOutAPIImpl defaultCheckOutAPI = new DefaultCheckOutAPIImpl(reditHelper, jsonPaser);
        defaultCheckOutAPI.removeMember(memberID);
    }

    public MemberEntity getMemberRecord(String memberID) {
        DefaultCheckOutAPIImpl defaultCheckOutAPI = new DefaultCheckOutAPIImpl(reditHelper, jsonPaser);
        return defaultCheckOutAPI.getMemberRecord(memberID);
    }
}
