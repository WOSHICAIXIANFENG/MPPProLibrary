package com.mpp.project.library.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mpp.project.datasource.bookEntity.Author;
import com.mpp.project.library.R;
import com.mpp.project.library.ui.bean.CheckoutBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Samuel on 8/3/17.
 */

public class AuthorAdapter extends RecyclerView.Adapter<AuthorAdapter.ViewHolder> {
    private Context context;
    private List<Author> authorList;
    private AuthorAdapter.OnItemClickListener onItemClickListener;

    public AuthorAdapter(Context context, List<Author> beens) {
        this.context = context;
        this.authorList = beens;
    }

    @Override
    public AuthorAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_author, parent, false);
        AuthorAdapter.ViewHolder viewHolder = new AuthorAdapter.ViewHolder(view);
        return viewHolder;
    }

    public void updateDataSet(List<Author> beens) {
        this.authorList = beens;
        notifyDataSetChanged();
    }

    public void clearDataSet() {
        this.authorList.clear();
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(AuthorAdapter.ViewHolder holder, int position) {
        if (authorList == null)
            return;

        Author record = authorList.get(position);
        holder.name.setText(record.getFirst_name() + record.getLast_name());
        holder.phone.setText(record.getPhone());
    }

    @Override
    public int getItemCount() {
        return authorList != null ? authorList.size() : 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tv_author_name)
        TextView name;

        @Bind(R.id.tv_author_phone)
        TextView phone;

        public ViewHolder(View view) {
            super(view);

            ButterKnife.bind(this, view);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(CheckoutBean bean);
    }

    public void setOnItemClickListener(AuthorAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}