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

    public DefaultBookAPIImpl(RedisHelper reditHelper, JsonPaser jsonPaser) {
        this.reditHelper = reditHelper;
        this.jsonPaser = jsonPaser;
    }

    public boolean checkBookID(String bookID) {
        return reditHelper.HasKey(bookID);
    }

    public boolean hasCopys(String isbn) {
        Set<String> bookIDs = reditHelper.GetSet(isbn);
        return bookIDs.size() > 1;
    }

    public String getBookID() {
        return reditHelper.GetInfo("bookID");
    }

    @Override
    public void addBook(BookEntity bookEntity) {
        if(bookEntity==null)
            return;

        String jsonStr = jsonPaser.BookEntityToJson(bookEntity);
        if(jsonStr != null) {
            reditHelper.SetInfo(bookEntity.getBookID(), jsonStr);
            reditHelper.SetSet(bookEntity.getTitle(), bookEntity.getBookID());
            reditHelper.SetSet(bookEntity.getIsbn(), bookEntity.getBookID());
            reditHelper.SetInfo("bookID", Integer.valueOf(reditHelper.GetInfo("bookID"))+1 + "");
        }
    }

    @Override
    public void editBook(BookEntity bookEntity) {
        if(bookEntity==null)
            return;

        String jsonStr = jsonPaser.BookEntityToJson(bookEntity);
        if(jsonStr != null) {
            reditHelper.SetInfo(bookEntity.getBookID(), jsonStr);
            reditHelper.SetSet(bookEntity.getTitle(), bookEntity.getBookID());
            reditHelper.SetSet(bookEntity.getIsbn(), bookEntity.getBookID());
            reditHelper.SetInfo("bookID", Integer.valueOf(reditHelper.GetInfo("bookID"))+1 + "");
        }
    }

    @Override
    public void removeBook(String bookID) {
        BookEntity bookEntity = getBookFromBookID(bookID);
        String title = bookEntity.getTitle();
        String isbn = bookEntity.getIsbn();

        if(bookID != null) {
            reditHelper.RemoveInfo(bookID);
            reditHelper.RemoveMemberFromSet(title, bookID);
            reditHelper.RemoveMemberFromSet(isbn, bookID);
        }
    }

    @Override
    public BookEntity getBookFromBookID(String bookID) {
        if(bookID == null)
            return null;

        String jsonStr = reditHelper.GetInfo(bookID);
        if(jsonStr != null)
            return jsonPaser.JsonToBookEntity(jsonStr);

        return null;
    }

    public List<BookEntity> getBooksFromISBN(String isbn) {
        Set<String> bookIDs =  reditHelper.GetSet(isbn);
        List<BookEntity> bookEntities = new ArrayList<>();

        for (String bookID : bookIDs) {
            BookEntity bookEntity = null;
            String jsonStr = reditHelper.GetInfo(bookID);
            if(jsonStr != null)
                bookEntity = jsonPaser.JsonToBookEntity(jsonStr);

            if (bookEntity != null)
                bookEntities.add(bookEntity);
        }

        return bookEntities;
    }

    @Override
    public List<BookEntity> searchBook(String pattern) {
        Set<String> bookIDs = reditHelper.GetKeys(pattern);
        List<BookEntity> bookEntities = new ArrayList<>();

        for (String bookID : bookIDs) {
            BookEntity bookEntity = null;
            String jsonStr = reditHelper.GetInfo(bookID);
            if(jsonStr != null)
                bookEntity = jsonPaser.JsonToBookEntity(jsonStr);

            if (bookEntity != null)
                bookEntities.add(bookEntity);
        }

        return bookEntities;
    }

    @Override //You can use book name or ISBN to get all books.
    public List<BookEntity> getBookCopys(String key) {
        Set<String> bookIDs = reditHelper.GetSet(key);
        List<BookEntity> bookEntities = new ArrayList<>();

        for (String bookID : bookIDs) {
            BookEntity bookEntity = null;
            String jsonStr = reditHelper.GetInfo(bookID);
            if(jsonStr != null)
                bookEntity = jsonPaser.JsonToBookEntity(jsonStr);

            if (bookEntity != null)
                bookEntities.add(bookEntity);
        }

        return bookEntities;
    }
}
