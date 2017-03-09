package com.mpp.project.library.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.mpp.project.datasource.bookEntity.Author;
import com.mpp.project.datasource.bookEntity.BookEntity;
import com.mpp.project.library.R;
import com.mpp.project.library.presenter.BookPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by Samuel on 6/3/17.
 */

public class AddBookFragment extends BaseFragment implements IBookView {
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
    AuthorAdapter mAdapter;

    private BookPresenter mPresenter;
    List<Author> authorList;

    @Override
    int getLayoutXml() {
        return R.layout.frag_add_book;
    }

    @Override
    protected void initData() {
        mCopyNumBox.setText("1");

        mPresenter = new BookPresenter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRVAuthorList.setLayoutManager(linearLayoutManager);

        authorList = new ArrayList<>();
//        authorList.add(new Author("firstName", "lastName", "address", "phone", "credentials", "shortbio"));
//        mBeans.add(new CheckoutBean("Book Name1", "Book Name1", "2016-12-23"));
//        mBeans.add(new CheckoutBean("Book Name2", "Book Name2", "2016-12-03"));

        mAdapter = new AuthorAdapter(getActivity(), authorList);
        mRVAuthorList.setAdapter(mAdapter);
    }

    @OnClick(R.id.btn_add_author)
    void clickAddAuthorBtn() {
        // show add author dialog
        mNavigate.openAddAuthorPage();
    }

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

        if (authorList.size() == 0) {
            Toast.makeText(getActivity(), "Please add one author at least for this book", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    @Override
    public void showMsg(final int msgId) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getActivity(), msgId, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void clearInputFields() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mTitleBox.setError(null);
                mTitleBox.setText("");
                mISBNBox.setError(null);
                mISBNBox.setText("");

                mCopyNumBox.setText("1");
                mRentShort.setChecked(false);
                mRentLong.setChecked(true);

                // clear author list
                mAdapter.clearDataSet();
                mTitleBox.requestFocus();
            }
        });
    }

    @Override
    public void showBookDetails(BookEntity bookEntity) {
        // nothing
    }

    @Override
    public void clearBookDetails() {
        // nothing
    }

    public void doAddBookLogic() {
        if(valideInputFields()) {
            if (authorList.isEmpty()) {
                Toast.makeText(getActivity(), "You have to set at least one author", Toast.LENGTH_SHORT).show();
            }

            String title = mTitleBox.getText().toString();
            String isbn = mISBNBox.getText().toString();
            String copyNum = mCopyNumBox.getText().toString();
            String bookId = System.currentTimeMillis() + "";

            String available = "";
            if (mIsAvailable.isChecked()) {
                available += "Yes";
            } else {
                available += "No";
            }

            String days = mRentShort.isChecked() ? "7" : "21";
            mPresenter.addOneBook(title, isbn, copyNum, available, days, bookId, authorList);
        }
    }

    public void doAddOneAuthorLogic(Author author) {
        if (authorList != null) {
            authorList.add(author);
            mAdapter.updateDataSet(authorList);
        }
    }
}
