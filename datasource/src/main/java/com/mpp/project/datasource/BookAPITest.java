package com.mpp.project.datasource;

import com.google.gson.Gson;
import com.mpp.project.datasource.api.DefaultBookAPIImpl;
import com.mpp.project.datasource.bookEntity.BookEntity;
import com.mpp.project.datasource.json.JsonPaser;
import com.mpp.project.datasource.redis.RedisHelper;

import java.util.List;

/**
 * Created by hongleyou on 6/3/17.
 */

public class BookAPITest {
    
    public static void main(String args[]) {
        RedisHelper reditHelper = new RedisHelper("localhost", 6379);
        JsonPaser jsonPaser = new JsonPaser();
        DefaultBookAPIImpl defaultBookAPI = new DefaultBookAPIImpl(reditHelper, jsonPaser);
        String jsonStr1 = "{\"title\":\"C++ primer\",\"isbn\":223456,\"copy\":\"1\",\"availability\":\"No\",\"keep_days\":21,\"bookID\":\"2234\",\"borrower\":\"XianFeng Cai\",\"authors\":[{\"first_name\":\"Leyou\",\"last_name\":\"Hong\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-123456\",\"credentials\":\"master\",\"short_bio\":\"I am smart.\"},{\"first_name\":\"Xianfeng\",\"last_name\":\"Cai\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-234567\",\"credentials\":\"master\",\"short_bio\":\"I am smart, too.\"},{\"first_name\":\"Yangyang\",\"last_name\":\"Li\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-012345\",\"credentials\":\"master\",\"short_bio\":\"I am smart, double too.\"}]}";
        String jsonStr2 = "{\"title\":\"C++ Senior\",\"isbn\":223457,\"copy\":\"1\",\"availability\":\"No\",\"keep_days\":21,\"bookID\":\"2235\",\"borrower\":\"XianFeng Cai\",\"authors\":[{\"first_name\":\"Leyou\",\"last_name\":\"Hong\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-123456\",\"credentials\":\"master\",\"short_bio\":\"I am smart.\"},{\"first_name\":\"Xianfeng\",\"last_name\":\"Cai\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-234567\",\"credentials\":\"master\",\"short_bio\":\"I am smart, too.\"},{\"first_name\":\"Yangyang\",\"last_name\":\"Li\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-012345\",\"credentials\":\"master\",\"short_bio\":\"I am smart, double too.\"}]}";
        String jsonStr3 = "{\"title\":\"C++ primer\",\"isbn\":223456,\"copy\":\"2\",\"availability\":\"No\",\"keep_days\":21,\"bookID\":\"2236\",\"borrower\":\"XianFeng Cai\",\"authors\":[{\"first_name\":\"Leyou\",\"last_name\":\"Hong\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-123456\",\"credentials\":\"master\",\"short_bio\":\"I am smart.\"},{\"first_name\":\"Xianfeng\",\"last_name\":\"Cai\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-234567\",\"credentials\":\"master\",\"short_bio\":\"I am smart, too.\"},{\"first_name\":\"Yangyang\",\"last_name\":\"Li\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-012345\",\"credentials\":\"master\",\"short_bio\":\"I am smart, double too.\"}]}";
        BookEntity bookEntity1 = new Gson().fromJson(jsonStr1, BookEntity.class);
        BookEntity bookEntity2 = new Gson().fromJson(jsonStr2, BookEntity.class);
        BookEntity bookEntity3 = new Gson().fromJson(jsonStr3, BookEntity.class);
        //System.out.println("bookEntity = " + bookEntity);
        defaultBookAPI.addBook(bookEntity1);
        defaultBookAPI.editBook(bookEntity2);
        defaultBookAPI.addBook(bookEntity3);

        System.out.println("bookentity1 = " +defaultBookAPI.getBookFromBookID("2234"));
        System.out.println("bookentity2 = " +defaultBookAPI.getBookFromBookID("2235"));
        System.out.println("bookentity3 = " +defaultBookAPI.getBookFromBookID("2236"));

        //System.out.println("bookentity1 = " +defaultBookAPI.getBooksFromISBN("223456"));
        //System.out.println("bookentity2 = " +defaultBookAPI.getBooksFromISBN("223457"));

        System.out.println("bookID" +defaultBookAPI.getBookID());
        System.out.println("hasCopys " +defaultBookAPI.hasCopys("223456"));
        List<BookEntity> getBooksFromISBNs = defaultBookAPI.getBooksFromISBN("223456");
        for (BookEntity b : getBooksFromISBNs) {
            System.out.println("b = " +b);
        }

        List<BookEntity> searchBookEntities = defaultBookAPI.searchBook("Java");
        for (BookEntity b : searchBookEntities) {
            System.out.println("b = " +b);
        }

        List<BookEntity> copysBookEntities = defaultBookAPI.getBookCopys("Java primer");
        for (BookEntity b : copysBookEntities) {
            System.out.println("b = " +b);
        }
    }
}
