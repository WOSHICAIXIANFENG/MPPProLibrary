package com.mpp.project.datasource.api;

import com.mpp.project.datasource.bookEntity.BookEntity;
import com.mpp.project.datasource.json.JsonPaser;
import com.mpp.project.datasource.redis.RedisHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by hongleyou on 2017/3/6.
 */

public class DefaultBookAPIImpl implements BookAPI {
    private RedisHelper reditHelper;
    private JsonPaser jsonPaser;

    public DefaultBookAPIImpl() {
        jsonPaser = new JsonPaser();
    }

    public void setRedisConnection(String addr, int port) {
            reditHelper = new RedisHelper(addr, port);
    }

    @Override
    public void addBook(BookEntity bookEntity) {
        if(bookEntity==null)
            return;

        String jsonStr = jsonPaser.ClassToJson(bookEntity);
        if(jsonStr != null) {
            reditHelper.SetInfo(bookEntity.getBookID(), jsonStr);
            reditHelper.SetSet(bookEntity.getTitle(), bookEntity.getBookID());
        }

    }

    @Override
    public void editBook(BookEntity bookEntity) {
        if(bookEntity==null)
            return;

        String jsonStr = jsonPaser.ClassToJson(bookEntity);
        if(jsonStr != null) {
            reditHelper.SetInfo(bookEntity.getBookID(), jsonStr);
            reditHelper.SetSet(bookEntity.getTitle(), bookEntity.getBookID());
        }
    }

    @Override
    public void removeBook(String bookID) {
        BookEntity bookEntity = getBook(bookID);
        String title = bookEntity.getTitle();

        if(bookID != null) {
            reditHelper.RemoveInfo(bookID);
            reditHelper.RemoveMemberFromSet(title, bookID);
        }
    }

    @Override
    public BookEntity getBook(String bookID) {
        if(bookID == null)
            return null;

        String jsonStr = reditHelper.GetInfo(bookID);
        if(jsonStr != null)
            return jsonPaser.JsonToClass(jsonStr);

        return null;
    }

    @Override
    public List<BookEntity> searchBook(String pattern) {
        Set<String> bookIDs = reditHelper.GetKeys(pattern);
        List<BookEntity> bookEntities = new ArrayList<>();

        for (String bookID : bookIDs) {
            BookEntity bookEntity = null;
            String jsonStr = reditHelper.GetInfo(bookID);
            if(jsonStr != null)
                bookEntity = jsonPaser.JsonToClass(jsonStr);

            if (bookEntity != null)
                bookEntities.add(bookEntity);
        }

        return bookEntities;
    }

    @Override
    public List<BookEntity> getBookCopys(String bookName) {
        Set<String> bookIDs = reditHelper.GetSet(bookName);
        List<BookEntity> bookEntities = new ArrayList<>();

        for (String bookID : bookIDs) {
            BookEntity bookEntity = null;
            String jsonStr = reditHelper.GetInfo(bookID);
            if(jsonStr != null)
                bookEntity = jsonPaser.JsonToClass(jsonStr);

            if (bookEntity != null)
                bookEntities.add(bookEntity);
        }

        return bookEntities;
    }
}
