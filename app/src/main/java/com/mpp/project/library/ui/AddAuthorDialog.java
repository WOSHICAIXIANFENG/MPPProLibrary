package com.mpp.project.library.ui;

import android.widget.Button;
import android.widget.EditText;

import com.mpp.project.library.R;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by Samuel on 7/3/17.
 */
public class AddAuthorDialog extends BaseFragment {
    @Bind(R.id.et_firstname)
    EditText mFirstNameBox;
    @Bind(R.id.et_lastname)
    EditText mLastNameBox;
    @Bind(R.id.et_phone)
    EditText mPhoneBox;
    @Bind(R.id.et_credentials)
    EditText mCredentialBox;
    @Bind(R.id.et_shortbio)
    EditText mShortBioBox;

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
    int getLayoutXml() {
        return R.layout.frag_add_author;
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
        mCredentialBox.setError(null);
        mShortBioBox.setError(null);

        mCityBox.setError(null);
        mStreetBox.setError(null);
        mStateBox.setError(null);
        mZipBox.setError(null);

        if (!valideInputField(mFirstNameBox) || !valideInputField(mLastNameBox) || !valideInputField(mPhoneBox) || !valideInputField(mCredentialBox)
                || !valideInputField(mShortBioBox) ) {
            return false;
        }

        return true;
    }
}
