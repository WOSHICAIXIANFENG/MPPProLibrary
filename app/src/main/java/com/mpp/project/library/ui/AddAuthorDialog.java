package com.mpp.project.library.ui;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mpp.project.library.R;

import butterknife.ButterKnife;

/**
 * Created by Samuel on 7/3/17.
 */

public class AddAuthorDialog extends DialogFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_add_author, container, false);
        ButterKnife.bind(this, view);

        return view;
    }
}
