package com.mpp.project.library.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.mpp.project.library.R;

import butterknife.ButterKnife;

/**
 * Created by Samuel on 7/3/17.
 */

public abstract class BaseFragment extends Fragment {
    abstract int getLayoutXml();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutXml(), container, false);
        ButterKnife.bind(this, view);

        initData();
        return view;
    }

    protected boolean valideInputField(EditText editText) {
        String input = editText.getText().toString();
        if (TextUtils.isEmpty(input)) {
            editText.setError(getString(R.string.error_field_required));
            editText.requestFocus();

            return false;
        }
        return true;
    }

    protected void initData() {

    }
}
