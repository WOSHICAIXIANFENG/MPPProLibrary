package com.mpp.project.library.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mpp.project.library.R;
import com.mpp.project.library.bean.CheckoutBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Samuel on 8/3/17.
 */

public class RecordAdapter extends RecyclerView.Adapter<RecordAdapter.ViewHolder> {
    private Context context;
    private List<CheckoutBean> recordList;
    private RecordAdapter.OnItemClickListener onItemClickListener;

    public RecordAdapter(Context context, List<CheckoutBean> beens) {
        this.context = context;
        this.recordList = beens;
    }

    @Override
    public RecordAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_record, parent, false);
        RecordAdapter.ViewHolder viewHolder = new RecordAdapter.ViewHolder(view);
        return viewHolder;
    }

    public void updateDataSet(List<CheckoutBean> beens) {
        this.recordList = beens;
        notifyDataSetChanged();
    }

    public void clearDataSet() {
        this.recordList.clear();
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(RecordAdapter.ViewHolder holder, int position) {
        if (recordList == null)
            return;

        CheckoutBean record = recordList.get(position);

        holder.title.setText(record.getBookTitle());
        holder.date.setText(record.getDate());
    }

    @Override
    public int getItemCount() {
        return recordList != null ? recordList.size() : 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tv_record_title)
        TextView title;

        @Bind(R.id.tv_record_date)
        TextView date;

        public ViewHolder(View view) {
            super(view);

            ButterKnife.bind(this, view);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(CheckoutBean bean);
    }

    public void setOnItemClickListener(RecordAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}