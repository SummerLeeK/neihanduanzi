package com.lee.neihanduanzi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.lee.neihanduanzi.R;
import com.lee.neihanduanzi.bean.DataBean;
import com.lee.neihanduanzi.bean.GroupBean;
import com.lee.neihanduanzi.bean.VideoBean;
import com.lee.neihanduanzi.viewholder.PicViewHolder;
import com.lee.neihanduanzi.viewholder.VideoViewHolder;

import java.util.ArrayList;

/**
 * Created by u on 2017/7/13.
 */

public class MultiTypeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<DataBean> dataBeen;
    public static final int TEXT_TYPE = 1;
    public static final int PIC_TYPE = 3;
    public static final int GIF_TYPE = 3;
    public static final int VIDEO_TYPE = 2;

    private LayoutInflater layoutInflater;

    private Context mContext;

    public MultiTypeAdapter(Context mContext) {
        this.mContext = mContext;
        layoutInflater = LayoutInflater.from(mContext);
    }

    public void setData(ArrayList<DataBean> dataBeen){
        this.dataBeen=dataBeen;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case PIC_TYPE:
                return new PicViewHolder(layoutInflater.inflate(R.layout.pic_item_view, parent, false));
            case VIDEO_TYPE:
                return new VideoViewHolder(layoutInflater.inflate(R.layout.video_item_view, parent, false));
        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        return dataBeen.get(position).getGroup().getType();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        switch (viewType) {
            case PIC_TYPE:
                ((PicViewHolder)holder).bindViewHolder(dataBeen.get(position),true);
                break;
            case VIDEO_TYPE:
                ((VideoViewHolder)holder).bindViewHolder(dataBeen.get(position),true,position);
        }

    }

    @Override
    public int getItemCount() {
        return dataBeen==null?0:dataBeen.size();
    }
}
