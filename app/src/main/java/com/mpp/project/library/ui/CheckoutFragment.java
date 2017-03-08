package com.mpp.project.library.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mpp.project.library.R;
import com.mpp.project.library.bean.CheckoutBean;
import com.mpp.project.library.presenter.CheckOutPresenter;

import java.util.ArrayList;
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
    private RecordAdapter mAdapter;
    private List<CheckoutBean> mBeans;

    private CheckOutPresenter mPresenter;

    @Override
    int getLayoutXml() {
        return R.layout.frag_checkout;
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter = new CheckOutPresenter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRVCheckOutRecords.setLayoutManager(linearLayoutManager);

        mBeans = new ArrayList<>();
        mBeans.add(new CheckoutBean("Book Name1", "Book Name1", "2016-12-23"));
        mBeans.add(new CheckoutBean("Book Name2", "Book Name2", "2016-12-03"));

        mAdapter = new RecordAdapter(getActivity(), mBeans);
        mRVCheckOutRecords.setAdapter(mAdapter);
    }

    @OnClick(R.id.bt_search)
    void onClickSearchBtn() {
        String memberId = mInputMemberId.getText().toString();
        mPresenter.searchCheckOutListById(memberId);
    }

    @Override
    public void showFailMsg(final int msgId) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getActivity(), msgId, Toast.LENGTH_SHORT).show();
                mAdapter.clearDataSet();
            }
        });
    }

    @Override
    public void showCheckoutRecord(final List<CheckoutBean> records) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // bind records with RV
                mAdapter.updateDataSet(records);
            }
        });
    }
}
