package com.mpp.project.datasource.json;

import com.mpp.project.datasource.bookEntity.BookEntity;
import com.google.gson.Gson;
import com.mpp.project.datasource.memberEntity.MemberEntity;
import com.mpp.project.datasource.memberEntity.Record;
import com.mpp.project.datasource.staff.Staff;

/**
 * Created by hongleyou on 2017/3/6.
 */

public class JsonPaser {
    public BookEntity JsonToBookEntity(String json) {
        if(json == null)
            return null;

        BookEntity bookEntity = new Gson().fromJson(json, BookEntity.class);
        //System.out.println("BookEntity = " + bookEntity);

        return bookEntity;
    }

    public MemberEntity JsonToMemberEntity(String json) {
        if(json == null)
            return null;

        MemberEntity memberEntity = new Gson().fromJson(json, MemberEntity.class);
        //System.out.println("BookEntity = " + bookEntity);

        return memberEntity;
    }

    public Staff JsonToStaff(String json) {
        if(json == null)
            return null;

        Staff staff = new Gson().fromJson(json, Staff.class);
        //System.out.println("BookEntity = " + bookEntity);

        return staff;
    }

    public String BookEntityToJson(BookEntity bookEntity) {
        if(bookEntity == null)
            return null;

        String jsonStr = new Gson().toJson(bookEntity, BookEntity.class);
        //System.out.println("jsonStr = " + jsonStr);

        return jsonStr;
    }

    public String MemberEntityToJson(MemberEntity memberEntity) {
        if(memberEntity == null)
            return null;

        String jsonStr = new Gson().toJson(memberEntity, MemberEntity.class);
        //System.out.println("jsonStr = " + jsonStr);

        return jsonStr;
    }

    public String StaffToJson(Staff staff) {
        if(staff == null)
            return null;

        String jsonStr = new Gson().toJson(staff, Staff.class);
        //System.out.println("jsonStr = " + jsonStr);

        return jsonStr;
    }
}
