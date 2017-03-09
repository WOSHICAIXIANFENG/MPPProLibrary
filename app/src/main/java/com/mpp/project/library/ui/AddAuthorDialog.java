package com.mpp.project.library.ui;

import android.widget.EditText;

import com.mpp.project.datasource.bookEntity.Author;
import com.mpp.project.library.R;

import butterknife.Bind;

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

    @Override
    int getLayoutXml() {
        return R.layout.frag_add_author;
    }

    @Override
    protected void initData() {

    }

    public void doAddAuthorLogic() {
        if (valideInputFields()) {
            String firstName = mFirstNameBox.getText().toString();
            String lastName = mLastNameBox.getText().toString();
            String phone = mPhoneBox.getText().toString();
            String credentials = mCredentialBox.getText().toString();
            String shortbio = mShortBioBox.getText().toString();

            String street = mStreetBox.getText().toString();
            String city = mCityBox.getText().toString();
            String state = mStateBox.getText().toString();
            String zip = mZipBox.getText().toString();

            String address = street + "," + state + "," + city + "," + zip;
            Author author = new Author(firstName, lastName, address, phone, credentials, shortbio);

            INavigate iNavigate = (INavigate) getActivity();
            iNavigate.addAuthorDone(author);
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
