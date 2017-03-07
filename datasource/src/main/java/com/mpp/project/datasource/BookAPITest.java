package com.mpp.project.datasource;

import com.google.gson.Gson;
import com.mpp.project.datasource.api.DefaultBookAPIImpl;
import com.mpp.project.datasource.bookEntity.BookEntity;

import java.util.List;

/**
 * Created by Samuel on 6/3/17.
 */

public class BookAPITest {
    
    public static void main(String args[]) {
        DefaultBookAPIImpl defaultBookAPI = new DefaultBookAPIImpl();
        defaultBookAPI.setRedisConnection("localhost", 6379);
        String jsonStr1 = "{\"title\":\"Java primer\",\"isbn\":123456,\"copy\":\"No\",\"availability\":\"No\",\"keep_days\":21,\"bookID\":\"123A\",\"borrower\":\"XianFeng Cai\",\"authors\":[{\"first_name\":\"Leyou\",\"last_name\":\"Hong\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-123456\",\"credentials\":\"master\",\"short_bio\":\"I am smart.\"},{\"first_name\":\"Xianfeng\",\"last_name\":\"Cai\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-234567\",\"credentials\":\"master\",\"short_bio\":\"I am smart, too.\"},{\"first_name\":\"Yangyang\",\"last_name\":\"Li\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-012345\",\"credentials\":\"master\",\"short_bio\":\"I am smart, double too.\"}]}";
        String jsonStr2 = "{\"title\":\"Java Senior\",\"isbn\":123456,\"copy\":\"No\",\"availability\":\"No\",\"keep_days\":21,\"bookID\":\"123B\",\"borrower\":\"XianFeng Cai\",\"authors\":[{\"first_name\":\"Leyou\",\"last_name\":\"Hong\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-123456\",\"credentials\":\"master\",\"short_bio\":\"I am smart.\"},{\"first_name\":\"Xianfeng\",\"last_name\":\"Cai\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-234567\",\"credentials\":\"master\",\"short_bio\":\"I am smart, too.\"},{\"first_name\":\"Yangyang\",\"last_name\":\"Li\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-012345\",\"credentials\":\"master\",\"short_bio\":\"I am smart, double too.\"}]}";
        String jsonStr3 = "{\"title\":\"Java primer\",\"isbn\":123456,\"copy\":\"No\",\"availability\":\"No\",\"keep_days\":21,\"bookID\":\"123C\",\"borrower\":\"XianFeng Cai\",\"authors\":[{\"first_name\":\"Leyou\",\"last_name\":\"Hong\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-123456\",\"credentials\":\"master\",\"short_bio\":\"I am smart.\"},{\"first_name\":\"Xianfeng\",\"last_name\":\"Cai\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-234567\",\"credentials\":\"master\",\"short_bio\":\"I am smart, too.\"},{\"first_name\":\"Yangyang\",\"last_name\":\"Li\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-012345\",\"credentials\":\"master\",\"short_bio\":\"I am smart, double too.\"}]}";
        BookEntity bookEntity1 = new Gson().fromJson(jsonStr1, BookEntity.class);
        BookEntity bookEntity2 = new Gson().fromJson(jsonStr2, BookEntity.class);
        BookEntity bookEntity3 = new Gson().fromJson(jsonStr3, BookEntity.class);
        //System.out.println("bookEntity = " + bookEntity);
        defaultBookAPI.addBook(bookEntity1);
        defaultBookAPI.editBook(bookEntity2);
        defaultBookAPI.addBook(bookEntity3);
        System.out.println("bookentity1 = " +defaultBookAPI.getBook("123A"));
        System.out.println("bookentity2 = " +defaultBookAPI.getBook("123B"));

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
