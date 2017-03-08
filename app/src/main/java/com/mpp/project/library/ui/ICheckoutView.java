package com.mpp.project.library.ui;

import com.mpp.project.datasource.memberEntity.Record;

import java.util.List;

/**
 * Created by Samuel on 8/3/17.
 */

public interface ICheckoutView {
    void showFailMsg(int msgId);

    void showCheckoutRecord(List<Record> records);
}
