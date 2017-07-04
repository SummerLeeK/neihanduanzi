package com.lee.neihanduanzi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.lee.neihanduanzi.R;
import com.lee.neihanduanzi.bean.VideoBean;
import com.lee.neihanduanzi.viewholder.VideoViewHolder;
import com.lee.neihanduanzi.widget.CustomVideoView;

import java.util.ArrayList;

import butterknife.Bind;

/**
 * Created by u on 2017/6/30.
 */

public class VideoRecycleAdapter extends RecyclerView.Adapter<VideoViewHolder> {


    private LayoutInflater inflater;

    private ArrayList<VideoBean.DataBeanX.DataBean> dataBeen;


    public void setData(ArrayList<VideoBean.DataBeanX.DataBean> dataBeen) {
        this.dataBeen = dataBeen;
    }

    public VideoRecycleAdapter(Context mContext) {

        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public VideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VideoViewHolder(inflater.inflate(R.layout.video_item_view, parent, false));
    }

    @Override
    public int getItemViewType(int position) {
        return dataBeen.get(position).getGroup().getType();
    }

    @Override
    public void onBindViewHolder(VideoViewHolder holder, int position) {
        holder.bindViewHolder(dataBeen.get(position), true);
    }

    @Override
    public int getItemCount() {
        return dataBeen == null ? 0 : dataBeen.size();
    }
}
