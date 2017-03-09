package com.mpp.project.library.ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mpp.project.datasource.bookEntity.Author;
import com.mpp.project.datasource.bookEntity.BookEntity;
import com.mpp.project.library.R;
import com.mpp.project.library.presenter.BookPresenter;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by Samuel on 6/3/17.
 */

public class AddCopyFragment extends BaseFragment implements IBookView {

    @Bind(R.id.bt_search)
    Button mSearchBookBtn;
    @Bind(R.id.et_book_isbn)
    EditText mBookISBNBox;

    @Bind(R.id.tv_book_title)
    TextView mBookTitle;
    @Bind(R.id.tv_book_isbn)
    TextView mBookISBN;
    @Bind(R.id.tv_book_author)
    TextView mBookAuthor;
    @Bind(R.id.tv_book_copyNum)
    TextView mCopyNum;

    @Bind(R.id.layout_book_detail)
    View mBookDetail;

    @Bind(R.id.btn_add_copy)
    Button mAddCopyBtn;

    BookPresenter mPresenter;
    private BookEntity bookEntity;

    @Override
    int getLayoutXml() {
        return R.layout.frag_add_copy;
    }

    protected void initData() {
        mPresenter = new BookPresenter(this);

        mBookDetail.setVisibility(View.INVISIBLE);
    }

    @OnClick(R.id.bt_search)
    void onClickSearchBookBtn() {
        String isbn = mBookISBNBox.getText().toString();
        if (TextUtils.isEmpty(isbn)) {
            mBookISBNBox.setError("ISBN can't be blank");
            return;
        }

        mPresenter.searchBookByISBN(isbn);
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
    public void clearInputFields() {

    }

    @Override
    public void showBookDetails(final BookEntity bookEntity) {
        this.bookEntity = bookEntity;

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mBookDetail.setVisibility(View.VISIBLE);

                mBookTitle.setText(bookEntity.getTitle());
                mBookISBN.setText(bookEntity.getIsbn());

                String firstAuthor = "UnKnown";
                List<Author> authors =  bookEntity.getAuthors();
                if (authors != null && authors.size() > 0) {
                    firstAuthor = authors.get(0).getFirst_name() + " " + authors.get(0).getLast_name();
                }
                mBookAuthor.setText(firstAuthor);
                mCopyNum.setText("Number of copies: " + bookEntity.getCopy());
            }
        });
    }

    @Override
    public void clearBookDetails() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                bookEntity = null;

                mBookTitle.setText("");
                mBookISBN.setText("");
                mCopyNum.setText("");

                mBookDetail.setVisibility(View.INVISIBLE);
            }
        });
    }

    @OnClick(R.id.btn_add_copy)
    void clickAddOneCopyBtn() {
        mPresenter.addOneCopyForBook(bookEntity);
    }
}
