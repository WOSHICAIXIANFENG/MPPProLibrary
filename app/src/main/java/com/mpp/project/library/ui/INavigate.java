package com.mpp.project.library.ui;

/**
 * Created by Samuel on 7/3/17.
 */

public interface INavigate {
    // add one book
    void openAddAuthorPage();
    void closeAddAuthorPage();

    void showSaveBtnForAddBook();
    void hideSaveBtnForAddBook();

    // check out one book
    void showCheckOutBtn();
    void hideCheckOutBtn();

    // edit one member
    void showEditBtn();
    void showSaveBtnFromEdit();
    void showEditBtnFromSave();
    void hideEditSaveBtn();
}
