package com.mpp.project.library.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.mpp.project.library.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Samuel on 6/3/17.
 */

public class AddAMemberFragment extends Fragment {
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_add_member, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick(R.id.bt_add)
    public void clickSaveBtn() {
        if(valideInputFields()) {
            // todo logic
        }
    }

    private boolean valideInputFields() {
        // Reset errors.
        mFirstNameBox.setError(null);
        mLastNameBox.setError(null);
        mPhoneBox.setError(null);
        mCityBox.setError(null);
        mStreetBox.setError(null);
        mStateBox.setError(null);
        mZipBox.setError(null);

        if (!valideInputField(mFirstNameBox) || !valideInputField(mLastNameBox) || !valideInputField(mPhoneBox) || !valideInputField(mStreetBox)
                || !valideInputField(mStateBox) || !valideInputField(mZipBox) || !valideInputField(mCityBox)) {
            return false;
        }

        return true;
    }

    private boolean valideInputField(EditText editText) {
        String input = editText.getText().toString();
        if (TextUtils.isEmpty(input)) {
            editText.setError(getString(R.string.error_field_required));
            editText.requestFocus();

            return false;
        }
        return true;
    }
}
