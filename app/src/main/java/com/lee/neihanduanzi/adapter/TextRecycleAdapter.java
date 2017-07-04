package com.lee.neihanduanzi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.lee.neihanduanzi.R;
import com.lee.neihanduanzi.bean.DataBean;
import com.lee.neihanduanzi.bean.TextBean;
import com.lee.neihanduanzi.viewholder.TextViewHolder;

import java.util.List;

import butterknife.Bind;

/**
 * Created by u on 2017/6/23.
 */

public class TextRecycleAdapter extends RecyclerView.Adapter<TextViewHolder> {


    private List<DataBean> data;
    private LayoutInflater inflater;

    public TextRecycleAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    @Override
    public TextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        TextViewHolder holder = new TextViewHolder(inflater.inflate(R.layout.text_item_view, parent, false));

        return holder;
    }

    @Override
    public void onBindViewHolder(TextViewHolder holder, int position) {
        holder.bindViewholder(data.get(position),true);
    }

    @Override
    public int getItemViewType(int position) {
        return data.get(position).getGroup().getType();
    }

    @Override
    public int getItemCount() {
        return data== null ? 0 : data.size();
    }
}
