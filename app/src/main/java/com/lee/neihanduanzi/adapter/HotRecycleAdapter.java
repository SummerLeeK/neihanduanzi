package com.lee.neihanduanzi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lee.neihanduanzi.R;
import com.lee.neihanduanzi.bean.HotBean;
import com.lee.neihanduanzi.viewholder.HotViewHolder;

import java.util.List;

import butterknife.Bind;

/**
 * Created by u on 2017/7/5.
 */

public class HotRecycleAdapter extends RecyclerView.Adapter<HotViewHolder> {



    private List<HotBean.DataBean.CategoriesBean.CategoryListBean> data;
    private LayoutInflater inflater;

    public HotRecycleAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @Override
    public HotViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HotViewHolder(inflater.inflate(R.layout.discovery_item_view, parent, false));
    }

    @Override
    public int getItemViewType(int position) {
        return 1;
    }

    @Override
    public void onBindViewHolder(HotViewHolder holder, int position) {
        holder.bindViewHolder(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public void setData(List<HotBean.DataBean.CategoriesBean.CategoryListBean> data) {
        this.data = data;
    }
}
