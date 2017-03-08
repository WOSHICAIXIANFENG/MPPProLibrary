package com.mpp.project.library.ui;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mpp.project.library.R;
import com.mpp.project.library.presenter.MemberPresenter;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by Samuel on 6/3/17.
 */

public class AddAMemberFragment extends BaseFragment implements IMemberView {
    @Bind(R.id.et_memeberId)
    EditText mMemberIdBox;

    @Bind(R.id.et_firstname)
    EditText mFirstNameBox;

    @Bind(R.id.et_lastname)
    EditText mLastNameBox;

    @Bind(R.id.et_phone)
    EditText mPhoneBox;

    @Bind(R.id.et_street)
    EditText mStreetBox;

    @Bind(R.id.et_city)
    EditText mCityBox;

    @Bind(R.id.et_state)
    EditText mStateBox;

    @Bind(R.id.et_zip)
    EditText mZipBox;

    @Bind(R.id.bt_add)
    Button mSaveBtn;

    MemberPresenter mPresenter;

    @Override
    int getLayoutXml() {
        return R.layout.frag_add_member;
    }

    protected void initData() {
        mPresenter = new MemberPresenter(this);
    }

    @OnClick(R.id.bt_add)
    public void clickSaveBtn() {
        if(valideInputFields()) {
            // todo logic
            String memberId = mMemberIdBox.getText().toString();
            String firstName = mFirstNameBox.getText().toString();
            String lastName = mLastNameBox.getText().toString();
            String phone = mPhoneBox.getText().toString();

            String street = mStreetBox.getText().toString();
            String state = mStateBox.getText().toString();
            String city = mCityBox.getText().toString();
            String zip = mZipBox.getText().toString();

            mPresenter.addOneMember(memberId, firstName, lastName, phone, street, state, city, zip);
        }
    }

    private boolean valideInputFields() {
        // Reset errors.
        mMemberIdBox.setError(null);
        mFirstNameBox.setError(null);
        mLastNameBox.setError(null);
        mPhoneBox.setError(null);
        mCityBox.setError(null);
        mStreetBox.setError(null);
        mStateBox.setError(null);
        mZipBox.setError(null);

        if (!valideInputField(mMemberIdBox) || !valideInputField(mFirstNameBox) || !valideInputField(mLastNameBox) || !valideInputField(mPhoneBox)
                || !valideInputField(mStreetBox)
                || !valideInputField(mStateBox) || !valideInputField(mZipBox) || !valideInputField(mCityBox)) {
            return false;
        }

        return true;
    }

    @Override
    public void showFailMsg(int msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

//    @Override
//    public void showMemberDetails(MemberEntity memberEntity) {
//        // show/update some widgets
//
//    }
}
