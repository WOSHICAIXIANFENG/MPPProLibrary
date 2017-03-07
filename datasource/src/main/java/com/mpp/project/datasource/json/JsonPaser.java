package com.mpp.project.datasource.json;

import com.mpp.project.datasource.bookEntity.BookEntity;
import com.google.gson.Gson;

/**
 * Created by hongleyou on 2017/3/6.
 */

public class JsonPaser {
    public BookEntity JsonToClass(String json) {
        if(json == null)
            return null;

        BookEntity bookEntity = new Gson().fromJson(json, BookEntity.class);
        //System.out.println("BookEntity = " + bookEntity);

        return bookEntity;
    }

    public String ClassToJson(BookEntity bookEntity) {
        if(bookEntity == null)
            return null;

        String jsonStr = new Gson().toJson(bookEntity, BookEntity.class);
        //System.out.println("jsonStr = " + jsonStr);

        return jsonStr;
    }
}
