package com.mpp.project.library.ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mpp.project.datasource.memberEntity.MemberEntity;
import com.mpp.project.library.R;
import com.mpp.project.library.presenter.MemberPresenter;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by Samuel on 6/3/17.
 */

public class EditMemberFragment extends BaseFragment implements IMemberView {

    @Bind(R.id.et_search_Id)
    EditText mMemberIdSearchBox;
    @Bind(R.id.bt_search)
    Button mSearchBtn;

    @Bind(R.id.form_member)
    View mEditForm;

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

    MemberPresenter mPresenter;
    private MemberEntity memberEntity;

    @Override
    int getLayoutXml() {
        return R.layout.frag_edit_member;
    }

    protected void initData() {
        mPresenter = new MemberPresenter(this);
        disableForAllEditFields();
        mEditForm.setVisibility(View.INVISIBLE);
    }

    public void doEditMemberLogic() {
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

            mPresenter.editOneMember(memberEntity, memberId, firstName, lastName, phone, street, state, city, zip);
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
    public void showMsg(final int msg) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void clearInputData() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                memberEntity = null;

                // Reset errors.
                mMemberIdBox.setError(null);
                mMemberIdBox.setText("");
                mFirstNameBox.setError(null);
                mFirstNameBox.setText("");
                mLastNameBox.setError(null);
                mLastNameBox.setText("");
                mPhoneBox.setError(null);
                mPhoneBox.setText("");
                mCityBox.setError(null);
                mCityBox.setText("");
                mStreetBox.setError(null);
                mStreetBox.setText("");
                mStateBox.setError(null);
                mStateBox.setText("");
                mZipBox.setError(null);
                mZipBox.setText("");

                mEditForm.setVisibility(View.INVISIBLE);
            }
        });
    }

    @Override
    public void hideEditSaveBtn() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                INavigate iNavigate = (INavigate) getActivity();
                iNavigate.hideEditSaveBtn();
            }
        });
    }

    @Override
    public void showEditSaveBtn() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                INavigate iNavigate = (INavigate) getActivity();
                iNavigate.showEditBtn();
            }
        });
    }

    @Override
    public void showEditBtnFromSave() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                INavigate iNavigate = (INavigate) getActivity();
                iNavigate.showEditBtnFromSave();
                disableForAllEditFields();
            }
        });
    }

    @OnClick(R.id.bt_search)
    void onClickSearchBtn() {
        String memberId = mMemberIdSearchBox.getText().toString();
        if (TextUtils.isEmpty(memberId)) {
            mMemberIdSearchBox.setError("Member Id can't be blank");
            return;
        }
        mPresenter.searchMemberById(memberId);
    }

    @Override
    public void showMemberDetails(final MemberEntity memberEntity) {
        this.memberEntity = memberEntity;

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mEditForm.setVisibility(View.VISIBLE);

                // show/update some widgets
                mMemberIdBox.setText(memberEntity.getMemberID());
                mFirstNameBox.setText(memberEntity.getFirstName());
                mLastNameBox.setText(memberEntity.getLastName());
                mPhoneBox.setText(memberEntity.getPhone());

                mCityBox.setText(memberEntity.getCity());
                mStreetBox.setText(memberEntity.getStreet());
                mStateBox.setText(memberEntity.getState());
                mZipBox.setText(memberEntity.getZip());
            }
        });
    }

    public void disableForAllEditFields() {
        disableOneField(mMemberIdBox);
        disableOneField(mFirstNameBox);
        disableOneField(mLastNameBox);
        disableOneField(mPhoneBox);

        disableOneField(mCityBox);
        disableOneField(mStreetBox);
        disableOneField(mStateBox);
        disableOneField(mZipBox);
    }

    public void enableAllEditFields() {
        enableOneField(mMemberIdBox);
        enableOneField(mFirstNameBox);
        enableOneField(mLastNameBox);
        enableOneField(mPhoneBox);

        enableOneField(mCityBox);
        enableOneField(mStreetBox);
        enableOneField(mStateBox);
        enableOneField(mZipBox);
    }

    private void disableOneField(EditText editText) {
        editText.setCursorVisible(false);
        editText.setFocusable(false);
        editText.setFocusableInTouchMode(false);
    }

    private void enableOneField(EditText editText) {
        editText.setCursorVisible(true);
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
    }
}
