package com.mpp.project.datasource;

import com.google.gson.Gson;
import com.mpp.project.datasource.api.DefaultAuthAPIImpl;
import com.mpp.project.datasource.api.DefaultBookAPIImpl;
import com.mpp.project.datasource.api.DefaultCheckOutAPIImpl;
import com.mpp.project.datasource.bookEntity.BookEntity;
import com.mpp.project.datasource.json.JsonPaser;
import com.mpp.project.datasource.memberEntity.MemberEntity;
import com.mpp.project.datasource.redis.RedisHelper;

public class SetDataTest {
    public static void main(String[] args) {
        RedisHelper reditHelper = new RedisHelper("localhost", 6379);
        JsonPaser jsonPaser = new JsonPaser();
        DefaultBookAPIImpl defaultBookAPI = new DefaultBookAPIImpl(reditHelper, jsonPaser);
        DefaultCheckOutAPIImpl defaultCheckOutAPI = new DefaultCheckOutAPIImpl(reditHelper, jsonPaser);

        String administrator1 = "{\"staffID\":\"administrator1\",\"passwd\":\"123456\",\"permits\":[\"PERMIT_BOTH\"]}";
        String administrator2 = "{\"staffID\":\"administrator2\",\"passwd\":\"123456\",\"permits\":[\"PERMIT_ADMIN\"]}";
        String librarian1 = "{\"staffID\":\"librarian1\",\"passwd\":\"123456\",\"permits\":[\"PERMIT_LIBRARIAN\"]}";
        String librarian2 = "{\"staffID\":\"librarian2\",\"passwd\":\"123456\",\"permits\":[\"PERMIT_LIBRARIAN\"]}";

        reditHelper.SetInfo("administrator1", administrator1);
        reditHelper.SetInfo("administrator2", administrator2);
        reditHelper.SetInfo("librarian1", librarian1);
        reditHelper.SetInfo("librarian2", librarian2);

        String cplusplus1 = "{\"title\":\"C++ primer\",\"isbn\":223456,\"copy\":\"1\",\"availability\":\"No\",\"keep_days\":21,\"bookID\":\"2234\",\"authors\":[{\"first_name\":\"Leyou\",\"last_name\":\"Hong\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-123456\",\"credentials\":\"master\",\"short_bio\":\"I am smart.\"},{\"first_name\":\"Xianfeng\",\"last_name\":\"Cai\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-234567\",\"credentials\":\"master\",\"short_bio\":\"I am smart, too.\"},{\"first_name\":\"Yangyang\",\"last_name\":\"Li\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-012345\",\"credentials\":\"master\",\"short_bio\":\"I am smart, double too.\"}]}";
        String cplusplus2 = "{\"title\":\"C++ primer\",\"isbn\":223456,\"copy\":\"2\",\"availability\":\"Yes\",\"keep_days\":21,\"bookID\":\"2235\",\"authors\":[{\"first_name\":\"Leyou\",\"last_name\":\"Hong\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-123456\",\"credentials\":\"master\",\"short_bio\":\"I am smart.\"},{\"first_name\":\"Xianfeng\",\"last_name\":\"Cai\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-234567\",\"credentials\":\"master\",\"short_bio\":\"I am smart, too.\"},{\"first_name\":\"Yangyang\",\"last_name\":\"Li\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-012345\",\"credentials\":\"master\",\"short_bio\":\"I am smart, double too.\"}]}";
        String cplusplus3 = "{\"title\":\"C++ primer\",\"isbn\":223456,\"copy\":\"3\",\"availability\":\"Yes\",\"keep_days\":21,\"bookID\":\"2236\",\"authors\":[{\"first_name\":\"Leyou\",\"last_name\":\"Hong\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-123456\",\"credentials\":\"master\",\"short_bio\":\"I am smart.\"},{\"first_name\":\"Xianfeng\",\"last_name\":\"Cai\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-234567\",\"credentials\":\"master\",\"short_bio\":\"I am smart, too.\"},{\"first_name\":\"Yangyang\",\"last_name\":\"Li\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-012345\",\"credentials\":\"master\",\"short_bio\":\"I am smart, double too.\"}]}";
        String cplusplus4 = "{\"title\":\"C++ primer\",\"isbn\":223456,\"copy\":\"4\",\"availability\":\"Yes\",\"keep_days\":21,\"bookID\":\"2237\",\"authors\":[{\"first_name\":\"Leyou\",\"last_name\":\"Hong\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-123456\",\"credentials\":\"master\",\"short_bio\":\"I am smart.\"},{\"first_name\":\"Xianfeng\",\"last_name\":\"Cai\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-234567\",\"credentials\":\"master\",\"short_bio\":\"I am smart, too.\"},{\"first_name\":\"Yangyang\",\"last_name\":\"Li\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-012345\",\"credentials\":\"master\",\"short_bio\":\"I am smart, double too.\"}]}";
        BookEntity cplusplus1Entity1 = new Gson().fromJson(cplusplus1, BookEntity.class);
        BookEntity cplusplus2Entity2 = new Gson().fromJson(cplusplus2, BookEntity.class);
        BookEntity cplusplus3Entity3 = new Gson().fromJson(cplusplus3, BookEntity.class);
        BookEntity cplusplus4Entity4 = new Gson().fromJson(cplusplus4, BookEntity.class);
        defaultBookAPI.addBook(cplusplus1Entity1);
        defaultBookAPI.addBook(cplusplus2Entity2);
        defaultBookAPI.addBook(cplusplus3Entity3);
        defaultBookAPI.addBook(cplusplus4Entity4);

        String java_primer1 = "{\"title\":\"Java primer\",\"isbn\":223457,\"copy\":\"1\",\"availability\":\"No\",\"keep_days\":21,\"bookID\":\"3234\",\"authors\":[{\"first_name\":\"Leyou\",\"last_name\":\"Hong\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-123456\",\"credentials\":\"master\",\"short_bio\":\"I am smart.\"},{\"first_name\":\"Xianfeng\",\"last_name\":\"Cai\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-234567\",\"credentials\":\"master\",\"short_bio\":\"I am smart, too.\"},{\"first_name\":\"Yangyang\",\"last_name\":\"Li\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-012345\",\"credentials\":\"master\",\"short_bio\":\"I am smart, double too.\"}]}";
        String java_primer2 = "{\"title\":\"Java primer\",\"isbn\":223457,\"copy\":\"2\",\"availability\":\"Yes\",\"keep_days\":21,\"bookID\":\"3235\",\"authors\":[{\"first_name\":\"Leyou\",\"last_name\":\"Hong\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-123456\",\"credentials\":\"master\",\"short_bio\":\"I am smart.\"},{\"first_name\":\"Xianfeng\",\"last_name\":\"Cai\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-234567\",\"credentials\":\"master\",\"short_bio\":\"I am smart, too.\"},{\"first_name\":\"Yangyang\",\"last_name\":\"Li\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-012345\",\"credentials\":\"master\",\"short_bio\":\"I am smart, double too.\"}]}";
        String java_primer3 = "{\"title\":\"Java primer\",\"isbn\":223457,\"copy\":\"3\",\"availability\":\"Yes\",\"keep_days\":21,\"bookID\":\"3236\",\"authors\":[{\"first_name\":\"Leyou\",\"last_name\":\"Hong\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-123456\",\"credentials\":\"master\",\"short_bio\":\"I am smart.\"},{\"first_name\":\"Xianfeng\",\"last_name\":\"Cai\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-234567\",\"credentials\":\"master\",\"short_bio\":\"I am smart, too.\"},{\"first_name\":\"Yangyang\",\"last_name\":\"Li\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-012345\",\"credentials\":\"master\",\"short_bio\":\"I am smart, double too.\"}]}";
        String java_primer4 = "{\"title\":\"Java primer\",\"isbn\":223457,\"copy\":\"4\",\"availability\":\"Yes\",\"keep_days\":21,\"bookID\":\"3237\",\"authors\":[{\"first_name\":\"Leyou\",\"last_name\":\"Hong\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-123456\",\"credentials\":\"master\",\"short_bio\":\"I am smart.\"},{\"first_name\":\"Xianfeng\",\"last_name\":\"Cai\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-234567\",\"credentials\":\"master\",\"short_bio\":\"I am smart, too.\"},{\"first_name\":\"Yangyang\",\"last_name\":\"Li\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-012345\",\"credentials\":\"master\",\"short_bio\":\"I am smart, double too.\"}]}";
        BookEntity java_primer1Entity1 = new Gson().fromJson(java_primer1, BookEntity.class);
        BookEntity java_primer2Entity2 = new Gson().fromJson(java_primer2, BookEntity.class);
        BookEntity java_primer3Entity3 = new Gson().fromJson(java_primer3, BookEntity.class);
        BookEntity java_primer4Entity4 = new Gson().fromJson(java_primer4, BookEntity.class);
        defaultBookAPI.addBook(java_primer1Entity1);
        defaultBookAPI.addBook(java_primer2Entity2);
        defaultBookAPI.addBook(java_primer3Entity3);
        defaultBookAPI.addBook(java_primer4Entity4);

        String C_improve1 = "{\"title\":\"C improve\",\"isbn\":223458,\"copy\":\"1\",\"availability\":\"No\",\"keep_days\":21,\"bookID\":\"4236\",\"authors\":[{\"first_name\":\"Leyou\",\"last_name\":\"Hong\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-123456\",\"credentials\":\"master\",\"short_bio\":\"I am smart.\"},{\"first_name\":\"Xianfeng\",\"last_name\":\"Cai\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-234567\",\"credentials\":\"master\",\"short_bio\":\"I am smart, too.\"},{\"first_name\":\"Yangyang\",\"last_name\":\"Li\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-012345\",\"credentials\":\"master\",\"short_bio\":\"I am smart, double too.\"}]}";
        String C_improve2 = "{\"title\":\"C improve\",\"isbn\":223458,\"copy\":\"2\",\"availability\":\"Yes\",\"keep_days\":21,\"bookID\":\"4237\",\"authors\":[{\"first_name\":\"Leyou\",\"last_name\":\"Hong\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-123456\",\"credentials\":\"master\",\"short_bio\":\"I am smart.\"},{\"first_name\":\"Xianfeng\",\"last_name\":\"Cai\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-234567\",\"credentials\":\"master\",\"short_bio\":\"I am smart, too.\"},{\"first_name\":\"Yangyang\",\"last_name\":\"Li\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-012345\",\"credentials\":\"master\",\"short_bio\":\"I am smart, double too.\"}]}";
        BookEntity C_improve1Entity1 = new Gson().fromJson(C_improve1, BookEntity.class);
        BookEntity C_improve2Entity2 = new Gson().fromJson(C_improve2, BookEntity.class);
        defaultBookAPI.addBook(C_improve1Entity1);
        defaultBookAPI.addBook(C_improve2Entity2);

        String learn_Lua1 = "{\"title\":\"learn Lua\",\"isbn\":223459,\"copy\":\"1\",\"availability\":\"No\",\"keep_days\":21,\"bookID\":\"5236\",\"authors\":[{\"first_name\":\"Leyou\",\"last_name\":\"Hong\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-123456\",\"credentials\":\"master\",\"short_bio\":\"I am smart.\"},{\"first_name\":\"Xianfeng\",\"last_name\":\"Cai\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-234567\",\"credentials\":\"master\",\"short_bio\":\"I am smart, too.\"},{\"first_name\":\"Yangyang\",\"last_name\":\"Li\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-012345\",\"credentials\":\"master\",\"short_bio\":\"I am smart, double too.\"}]}";
        String learn_Lua2 = "{\"title\":\"learn Lua\",\"isbn\":223459,\"copy\":\"2\",\"availability\":\"Yes\",\"keep_days\":21,\"bookID\":\"5237\",\"authors\":[{\"first_name\":\"Leyou\",\"last_name\":\"Hong\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-123456\",\"credentials\":\"master\",\"short_bio\":\"I am smart.\"},{\"first_name\":\"Xianfeng\",\"last_name\":\"Cai\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-234567\",\"credentials\":\"master\",\"short_bio\":\"I am smart, too.\"},{\"first_name\":\"Yangyang\",\"last_name\":\"Li\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-012345\",\"credentials\":\"master\",\"short_bio\":\"I am smart, double too.\"}]}";
        BookEntity learn_Lua1Entity1 = new Gson().fromJson(learn_Lua1, BookEntity.class);
        BookEntity learn_Lua2Entity2 = new Gson().fromJson(learn_Lua2, BookEntity.class);
        defaultBookAPI.addBook(learn_Lua1Entity1);
        defaultBookAPI.addBook(learn_Lua2Entity2);

        String bbc1 = "{\"title\":\"bbc\",\"isbn\":223460,\"copy\":\"1\",\"availability\":\"No\",\"keep_days\":21,\"bookID\":\"6236\",\"authors\":[{\"first_name\":\"Leyou\",\"last_name\":\"Hong\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-123456\",\"credentials\":\"master\",\"short_bio\":\"I am smart.\"},{\"first_name\":\"Xianfeng\",\"last_name\":\"Cai\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-234567\",\"credentials\":\"master\",\"short_bio\":\"I am smart, too.\"},{\"first_name\":\"Yangyang\",\"last_name\":\"Li\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-012345\",\"credentials\":\"master\",\"short_bio\":\"I am smart, double too.\"}]}";
        String bbc2 = "{\"title\":\"bbc\",\"isbn\":223460,\"copy\":\"2\",\"availability\":\"Yes\",\"keep_days\":21,\"bookID\":\"6237\",\"authors\":[{\"first_name\":\"Leyou\",\"last_name\":\"Hong\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-123456\",\"credentials\":\"master\",\"short_bio\":\"I am smart.\"},{\"first_name\":\"Xianfeng\",\"last_name\":\"Cai\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-234567\",\"credentials\":\"master\",\"short_bio\":\"I am smart, too.\"},{\"first_name\":\"Yangyang\",\"last_name\":\"Li\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-012345\",\"credentials\":\"master\",\"short_bio\":\"I am smart, double too.\"}]}";
        String bbc3 = "{\"title\":\"bbc\",\"isbn\":223460,\"copy\":\"3\",\"availability\":\"Yes\",\"keep_days\":21,\"bookID\":\"6238\",\"authors\":[{\"first_name\":\"Leyou\",\"last_name\":\"Hong\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-123456\",\"credentials\":\"master\",\"short_bio\":\"I am smart.\"},{\"first_name\":\"Xianfeng\",\"last_name\":\"Cai\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-234567\",\"credentials\":\"master\",\"short_bio\":\"I am smart, too.\"},{\"first_name\":\"Yangyang\",\"last_name\":\"Li\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-012345\",\"credentials\":\"master\",\"short_bio\":\"I am smart, double too.\"}]}";
        BookEntity bbc1Entity1 = new Gson().fromJson(bbc1, BookEntity.class);
        BookEntity bbc2Entity2 = new Gson().fromJson(bbc2, BookEntity.class);
        BookEntity bbc3Entity3 = new Gson().fromJson(bbc3, BookEntity.class);
        defaultBookAPI.addBook(bbc1Entity1);
        defaultBookAPI.addBook(bbc2Entity2);
        defaultBookAPI.addBook(bbc3Entity3);

        String cnn1 = "{\"title\":\"cnn1\",\"isbn\":223461,\"copy\":\"1\",\"availability\":\"No\",\"keep_days\":21,\"bookID\":\"7236\",\"authors\":[{\"first_name\":\"Leyou\",\"last_name\":\"Hong\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-123456\",\"credentials\":\"master\",\"short_bio\":\"I am smart.\"},{\"first_name\":\"Xianfeng\",\"last_name\":\"Cai\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-234567\",\"credentials\":\"master\",\"short_bio\":\"I am smart, too.\"},{\"first_name\":\"Yangyang\",\"last_name\":\"Li\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-012345\",\"credentials\":\"master\",\"short_bio\":\"I am smart, double too.\"}]}";
        String cnn2 = "{\"title\":\"cnn2\",\"isbn\":223461,\"copy\":\"2\",\"availability\":\"Yes\",\"keep_days\":21,\"bookID\":\"7237\",\"authors\":[{\"first_name\":\"Leyou\",\"last_name\":\"Hong\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-123456\",\"credentials\":\"master\",\"short_bio\":\"I am smart.\"},{\"first_name\":\"Xianfeng\",\"last_name\":\"Cai\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-234567\",\"credentials\":\"master\",\"short_bio\":\"I am smart, too.\"},{\"first_name\":\"Yangyang\",\"last_name\":\"Li\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-012345\",\"credentials\":\"master\",\"short_bio\":\"I am smart, double too.\"}]}";
        String cnn3 = "{\"title\":\"cnn3\",\"isbn\":223461,\"copy\":\"3\",\"availability\":\"Yes\",\"keep_days\":21,\"bookID\":\"7238\",\"authors\":[{\"first_name\":\"Leyou\",\"last_name\":\"Hong\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-123456\",\"credentials\":\"master\",\"short_bio\":\"I am smart.\"},{\"first_name\":\"Xianfeng\",\"last_name\":\"Cai\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-234567\",\"credentials\":\"master\",\"short_bio\":\"I am smart, too.\"},{\"first_name\":\"Yangyang\",\"last_name\":\"Li\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-012345\",\"credentials\":\"master\",\"short_bio\":\"I am smart, double too.\"}]}";
        BookEntity cnn1Entity1 = new Gson().fromJson(cnn1, BookEntity.class);
        BookEntity cnn2Entity2 = new Gson().fromJson(cnn2, BookEntity.class);
        BookEntity cnn3Entity3 = new Gson().fromJson(cnn3, BookEntity.class);
        defaultBookAPI.addBook(cnn1Entity1);
        defaultBookAPI.addBook(cnn2Entity2);
        defaultBookAPI.addBook(cnn3Entity3);

        String cctv1 = "{\"title\":\"cctv1\",\"isbn\":223462,\"copy\":\"1\",\"availability\":\"No\",\"keep_days\":21,\"bookID\":\"8236\",\"authors\":[{\"first_name\":\"Leyou\",\"last_name\":\"Hong\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-123456\",\"credentials\":\"master\",\"short_bio\":\"I am smart.\"},{\"first_name\":\"Xianfeng\",\"last_name\":\"Cai\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-234567\",\"credentials\":\"master\",\"short_bio\":\"I am smart, too.\"},{\"first_name\":\"Yangyang\",\"last_name\":\"Li\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-012345\",\"credentials\":\"master\",\"short_bio\":\"I am smart, double too.\"}]}";
        String cctv2 = "{\"title\":\"cctv2\",\"isbn\":223462,\"copy\":\"2\",\"availability\":\"Yes\",\"keep_days\":21,\"bookID\":\"8237\",\"authors\":[{\"first_name\":\"Leyou\",\"last_name\":\"Hong\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-123456\",\"credentials\":\"master\",\"short_bio\":\"I am smart.\"},{\"first_name\":\"Xianfeng\",\"last_name\":\"Cai\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-234567\",\"credentials\":\"master\",\"short_bio\":\"I am smart, too.\"},{\"first_name\":\"Yangyang\",\"last_name\":\"Li\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-012345\",\"credentials\":\"master\",\"short_bio\":\"I am smart, double too.\"}]}";
        String cctv3 = "{\"title\":\"cctv3\",\"isbn\":223462,\"copy\":\"3\",\"availability\":\"Yes\",\"keep_days\":21,\"bookID\":\"8238\",\"authors\":[{\"first_name\":\"Leyou\",\"last_name\":\"Hong\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-123456\",\"credentials\":\"master\",\"short_bio\":\"I am smart.\"},{\"first_name\":\"Xianfeng\",\"last_name\":\"Cai\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-234567\",\"credentials\":\"master\",\"short_bio\":\"I am smart, too.\"},{\"first_name\":\"Yangyang\",\"last_name\":\"Li\",\"address\":\"1000 N st, Faired, IA USA\",\"phone\":\"613-012345\",\"credentials\":\"master\",\"short_bio\":\"I am smart, double too.\"}]}";
        BookEntity cctv1Entity1 = new Gson().fromJson(cctv1, BookEntity.class);
        BookEntity cctv2Entity2 = new Gson().fromJson(cctv2, BookEntity.class);
        BookEntity cctv3Entity3 = new Gson().fromJson(cctv3, BookEntity.class);
        defaultBookAPI.addBook(cctv1Entity1);
        defaultBookAPI.addBook(cctv2Entity2);
        defaultBookAPI.addBook(cctv3Entity3);


        String memStr1 = "{\"memberID\":\"3891\",\"firstName\":\"Leyou\",\"lastName\":\"Hong\",\"phone\":\"641-12345\",\"street\":\"1000 N st\",\"zip\":\"52556\",\"city\":\"Fairfield\",\"state\":\"IA\",\"records\":[{\"isbn\":\"223458\",\"bookID\":\"4237\",\"checkOutDay\":\"2017-2-1\",\"dueDay\":\"2017-2-8\",\"laterDays\":0,\"fine\":0},{\"isbn\":\"223456\",\"bookID\":\"2237\",\"checkOutDay\":\"2017-2-2\",\"dueDay\":\"2017-2-9\",\"laterDays\":0,\"fine\":0},{\"isbn\":\"223459\",\"bookID\":\"5236\",\"checkOutDay\":\"2017-2-3\",\"dueDay\":\"2017-2-10\",\"laterDays\":0,\"fine\":0}]}";
        String memStr2 = "{\"memberID\":\"3892\",\"firstName\":\"Yangyang\",\"lastName\":\"Li\",\"phone\":\"641-12345\",\"street\":\"1000 N st\",\"zip\":\"52556\",\"city\":\"Fairfield\",\"state\":\"IA\",\"records\":[{\"isbn\":\"223460\",\"bookID\":\"6237\",\"checkOutDay\":\"2017-2-1\",\"dueDay\":\"2017-2-8\",\"laterDays\":0,\"fine\":0},{\"isbn\":\"223461\",\"bookID\":\"7237\",\"checkOutDay\":\"2017-2-2\",\"dueDay\":\"2017-2-9\",\"laterDays\":0,\"fine\":0},{\"isbn\":\"223462\",\"bookID\":\"8237\",\"checkOutDay\":\"2017-2-3\",\"dueDay\":\"2017-2-10\",\"laterDays\":0,\"fine\":0}]}";
        MemberEntity memberEntity1 = new Gson().fromJson(memStr1, MemberEntity.class);
        MemberEntity memberEntity2 = new Gson().fromJson(memStr2, MemberEntity.class);
        defaultCheckOutAPI.addMember(memberEntity1);
        defaultCheckOutAPI.addMember(memberEntity2);
    }
}
