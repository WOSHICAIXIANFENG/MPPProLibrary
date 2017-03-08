package com.mpp.project.library.ui;

import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;

import com.mpp.project.library.R;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by Samuel on 6/3/17.
 */

public class CheckoutFragment extends BaseFragment {
    @Bind(R.id.et_memberId)
    EditText mInputMemberId;
    @Bind(R.id.bt_search)
    Button mSearchBtn;

    @Bind(R.id.rv_checkout)
    RecyclerView mRVCheckOutRecords;

    @Override
    int getLayoutXml() {
        return R.layout.frag_checkout;
    }

    @OnClick(R.id.bt_search)
    void onClickSearchBtn() {
        // todo
    }

}
