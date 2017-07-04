package com.lee.neihanduanzi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lee.neihanduanzi.R;
import com.lee.neihanduanzi.bean.DataBean;
import com.lee.neihanduanzi.bean.PicBean;
import com.lee.neihanduanzi.liao.GifView;
import com.lee.neihanduanzi.viewholder.GifViewHolder;
import com.lee.neihanduanzi.viewholder.PicViewHolder;
import com.lee.neihanduanzi.widget.MyListView;

import java.util.List;

import butterknife.Bind;
import de.hdodenhof.circleimageview.CircleImageView;


/**
 * Created by u on 2017/6/29.
 */

public class PicRecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private List<DataBean> data;
    private LayoutInflater inflater;

    public PicRecycleAdapter(Context mContext) {
        inflater = LayoutInflater.from(mContext);
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 1) {
            return new PicViewHolder(inflater.inflate(R.layout.pic_item_view, parent, false));
        } else if (viewType == 2) {
            return new GifViewHolder(inflater.inflate(R.layout.gif_item_view, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        switch (viewType) {
            case 1:
                ((PicViewHolder) holder).bindViewHolder(data.get(position), true);
                break;
            case 2:
                ((GifViewHolder) holder).bindViewHolder(data.get(position),true);
                break;
        }

    }

    @Override
    public int getItemViewType(int position) {
        return data.get(position).getGroup().getMedia_type();
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }
}
