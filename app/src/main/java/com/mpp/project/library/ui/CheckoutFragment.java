package com.mpp.project.library.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.mpp.project.library.R;

/**
 * Created by Samuel on 6/3/17.
 */

public class CheckoutFragment extends Fragment {
    private EditText mInputMemberId;
    private Button mSearchBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.frag_checkout, container, false);
        mInputMemberId = (EditText) view.findViewById(R.id.et_memberId);
        mSearchBtn = (Button) view.findViewById(R.id.bt_search);

        mSearchBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

            }
        });
        return view;
    }

}
