package com.mpp.project.library.ui;

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
    private EditText mInputMemberId;
    @Bind(R.id.bt_search)
    private Button mSearchBtn;

    @Override
    int getLayoutXml() {
        return R.layout.frag_checkout;
    }

    @OnClick(R.id.bt_search)
    void onClickSearchBtn() {
        // todo
    }

}
