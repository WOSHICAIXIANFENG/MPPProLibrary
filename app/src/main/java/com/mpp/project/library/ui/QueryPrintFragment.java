package com.mpp.project.library.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mpp.project.datasource.bookEntity.BookEntity;
import com.mpp.project.datasource.memberEntity.MemberEntity;
import com.mpp.project.library.R;
import com.mpp.project.library.ui.adapter.RecordAdapter;
import com.mpp.project.library.ui.bean.CheckoutBean;
import com.mpp.project.library.presenter.CheckOutPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by Samuel on 6/3/17.
 */

public class QueryPrintFragment extends BaseFragment implements ICheckoutView {
    @Bind(R.id.et_memberId)
    EditText mInputMemberId;
    @Bind(R.id.bt_search)
    Button mSearchBtn;

    @Bind(R.id.rv_checkout)
    RecyclerView mRVCheckOutRecords;
    private RecordAdapter mAdapter;
    private List<CheckoutBean> mBeans;
    private CheckOutPresenter mPresenter;
    private MemberEntity memberEntity;

    @Override
    int getLayoutXml() {
        return R.layout.frag_query;
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter = new CheckOutPresenter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRVCheckOutRecords.setLayoutManager(linearLayoutManager);

        mBeans = new ArrayList<>();
        mAdapter = new RecordAdapter(getActivity(), mBeans);
        mRVCheckOutRecords.setAdapter(mAdapter);
    }

    @OnClick(R.id.bt_search)
    void onClickSearchBtn() {
        String memberId = mInputMemberId.getText().toString();
        if (TextUtils.isEmpty(memberId)) {
            mInputMemberId.setError("Member Id can't be blank");
            return;
        }
        mPresenter.searchCheckOutListById(memberId);
    }

    @Override
    public void showMsg(final int msgId) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getActivity(), msgId, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void showCheckoutRecord(MemberEntity memberEntity, final List<CheckoutBean> records) {
        this.memberEntity = memberEntity;

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // bind records with RV
                mAdapter.updateDataSet(records);
            }
        });
    }

    @Override
    public void showBookEntityOnPage(final BookEntity bookEntity) {

    }

    @Override
    public void hideSearchBookLayout() {

    }

    @Override
    public void showSearchBookLayout() {

    }

    @Override
    public void clearRecordList() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mAdapter.clearDataSet();
            }
        });
    }

    @Override
    public void clearBookDetails() {

    }

    @Override
    public void showCheckOutSubmitBtn() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mNavigate.showCheckOutBtn();
            }
        });
    }

    @Override
    public void hideCheckOutSubmitBtn() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mNavigate.hideCheckOutBtn();
            }
        });
    }

    public void printAllCheckoutRecord() {
        if (mAdapter != null) {
            List<CheckoutBean> records = mAdapter.getDataSet();
            if (records != null) {
                System.out.println("＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝ Your Checkout Records ＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝");
                if (memberEntity != null) {
                    System.out.println("Member Name: " + memberEntity.getFirstName() + memberEntity.getLastName());
                }
                for (CheckoutBean bean : records) {
                    System.out.println("Book Title = " + bean.getBookTitle() + " , Check Out Date: " + bean.getDate());
                }
            }
        }
    }
}
