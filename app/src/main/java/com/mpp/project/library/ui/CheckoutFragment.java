package com.mpp.project.library.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mpp.project.datasource.bookEntity.Author;
import com.mpp.project.datasource.bookEntity.BookEntity;
import com.mpp.project.datasource.memberEntity.MemberEntity;
import com.mpp.project.library.R;
import com.mpp.project.library.bean.CheckoutBean;
import com.mpp.project.library.presenter.CheckOutPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by Samuel on 6/3/17.
 */

public class CheckoutFragment extends BaseFragment implements ICheckoutView {
    @Bind(R.id.et_memberId)
    EditText mInputMemberId;
    @Bind(R.id.bt_search)
    Button mSearchBtn;
    @Bind(R.id.bt_search_book)
    Button mSearchBookBtn;
    @Bind(R.id.et_book_isbn)
    EditText mBookISBNBox;

    @Bind(R.id.tv_book_title)
    TextView mBookTitle;
    @Bind(R.id.tv_book_isbn)
    TextView mBookISBN;
    @Bind(R.id.tv_book_author)
    TextView mBookAuthor;

    @Bind(R.id.layout_search_book)
    View mSearchBookLayout;

    @Bind(R.id.rv_checkout)
    RecyclerView mRVCheckOutRecords;
    private RecordAdapter mAdapter;
    private List<CheckoutBean> mBeans;

    private CheckOutPresenter mPresenter;
    private MemberEntity memberEntity;
    private BookEntity bookEntity;

    @Override
    int getLayoutXml() {
        return R.layout.frag_checkout;
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter = new CheckOutPresenter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRVCheckOutRecords.setLayoutManager(linearLayoutManager);

        mBeans = new ArrayList<>();
//        mBeans.add(new CheckoutBean("Book Name1", "Book Name1", "2016-12-23"));
//        mBeans.add(new CheckoutBean("Book Name2", "Book Name2", "2016-12-03"));

        mAdapter = new RecordAdapter(getActivity(), mBeans);
        mRVCheckOutRecords.setAdapter(mAdapter);
        mSearchBookLayout.setVisibility(View.INVISIBLE);
    }

    @OnClick(R.id.bt_search)
    void onClickSearchBtn() {
        String memberId = mInputMemberId.getText().toString();
        if (TextUtils.isEmpty(memberId)) {
            mInputMemberId.setError("Member Id can't be blank");
            return;
        }
        mPresenter.searchCheckOutListById(memberId);
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
    public void showCheckoutRecord(MemberEntity memberEntity, final List<CheckoutBean> records) {
        this.memberEntity = memberEntity;

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // bind records with RV
                mAdapter.updateDataSet(records);
            }
        });
    }

    @Override
    public void showBookEntityOnPage(final BookEntity bookEntity) {
        this.bookEntity = bookEntity;

        // update widgets
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // bind records with RV
                mBookTitle.setText(bookEntity.getTitle());
                mBookISBN.setText(bookEntity.getIsbn());
                String firstAuthor = "UnKnown";
                List<Author> authors =  bookEntity.getAuthors();
                if (authors != null && authors.size() > 0) {
                    firstAuthor = authors.get(0).getFirst_name() + " " + authors.get(0).getLast_name();
                }
                mBookAuthor.setText(firstAuthor);
            }
        });
    }

    @Override
    public void hideSearchBookLayout() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mSearchBookLayout.setVisibility(View.INVISIBLE);
            }
        });
    }

    @Override
    public void showSearchBookLayout() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mSearchBookLayout.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void clearRecordList() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mAdapter.clearDataSet();
            }
        });
    }

    @Override
    public void clearBookDetails() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mBookTitle.setText("");
                mBookISBN.setText("");
                mBookAuthor.setText("");

                // set null
                bookEntity = null;
            }
        });
    }

    @Override
    public void showCheckOutSubmitBtn() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mNavigate.showCheckOutBtn();
            }
        });
    }

    @Override
    public void hideCheckOutSubmitBtn() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mNavigate.hideCheckOutBtn();
            }
        });
    }


    @OnClick(R.id.bt_search_book)
    void onClickSearchBookBtn() {
        String isbn = mBookISBNBox.getText().toString();
        if (TextUtils.isEmpty(isbn)) {
            mBookISBNBox.setError("ISBN can't be blank");
            return;
        }

        mPresenter.searchBookByISBN(isbn);
    }

    void doCheckoutLogic() {
        mPresenter.doCheckoutLogic(bookEntity, memberEntity);
    }
}
