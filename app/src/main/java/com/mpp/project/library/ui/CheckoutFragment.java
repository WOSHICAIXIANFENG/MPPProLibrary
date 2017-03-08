package com.mpp.project.library.ui;

import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;

import com.mpp.project.datasource.memberEntity.Record;
import com.mpp.project.library.R;
import com.mpp.project.library.presenter.CheckOutPresenter;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by Samuel on 6/3/17.
 */

public class CheckoutFragment extends BaseFragment implements ICheckoutView {
    @Bind(R.id.et_memberId)
    EditText mInputMemberId;
    @Bind(R.id.bt_search)
    Button mSearchBtn;

    @Bind(R.id.rv_checkout)
    RecyclerView mRVCheckOutRecords;

    private CheckOutPresenter mPresenter;

    @Override
    int getLayoutXml() {
        return R.layout.frag_checkout;
    }

    @Override
    protected void initData() {
        super.initData();

        mPresenter = new CheckOutPresenter(this);
    }

    @OnClick(R.id.bt_search)
    void onClickSearchBtn() {
        // todo
        String memberId = mInputMemberId.getText().toString();

        mPresenter.searchCheckOutListById(memberId);
    }

    @Override
    public void showFailMsg(int msgId) {

    }

    @Override
    public void showCheckoutRecord(List<Record> records) {
        // bind records with RV

    }
}
