package com.mpp.project.library.ui;

import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.mpp.project.library.R;
import com.mpp.project.library.bean.AuthorBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by Samuel on 6/3/17.
 */

public class AddBookFragment extends BaseFragment {
    @Bind(R.id.et_title)
    EditText mTitleBox;

    @Bind(R.id.et_isbn)
    EditText mISBNBox;

    @Bind(R.id.et_available)
    CheckBox mIsAvailable;

    @Bind(R.id.rb_rent_short)
    RadioButton mRentShort;
    @Bind(R.id.rb_rent_long)
    RadioButton mRentLong;
    @Bind(R.id.rg_rent_period)
    RadioGroup mRentPeriod;
    @Bind(R.id.et_copyNum)
    EditText mCopyNumBox;

    @Bind(R.id.btn_add_author)
    Button mBtnAddAuthor;
    @Bind(R.id.rv_authors)
    RecyclerView mRVAuthorList;
    @Bind(R.id.btn_add_book)
    Button mBtnAddBook;

    List<AuthorBean> authorBeanList;

    @Override
    int getLayoutXml() {
        return R.layout.frag_add_book;
    }

    @Override
    protected void initData() {
        authorBeanList = new ArrayList<>();

        // default value
        mCopyNumBox.setText("1");
    }

    @OnClick(R.id.btn_add_author)
    void clickAddAuthorBtn() {
        // show add author dialog
        INavigate navigator = (INavigate) getActivity();
        navigator.openAddAuthorPage();
    }

    @OnClick(R.id.btn_add_book)
    void clickAddBookBtn() {
        if(valideInputFields()) {
            // todo logic
        }
    }

    private boolean valideInputFields() {
        // Reset errors.
        mTitleBox.setError(null);
        mISBNBox.setError(null);

        if (!valideInputField(mTitleBox) || !valideInputField(mISBNBox)) {
            return false;
        }

        if (authorBeanList.size() == 0) {
            Toast.makeText(getActivity(), "Please add one author at least for this book", Toast.LENGTH_SHORT).show();
            return false;
        }


        return true;
    }
}
