package com.lee.neihanduanzi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lee.neihanduanzi.R;
import com.lee.neihanduanzi.bean.HotCommentBean;
import com.lee.neihanduanzi.viewholder.NormalCommentViewHolder;

import java.util.ArrayList;

import butterknife.Bind;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by u on 2017/6/24.
 */

public class TextDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int HEAD_TYPE = 00;
    public static final int HOT_TYPE = 01;
    public static final int NORMAL_TYPE = 02;

    private LayoutInflater inflater;

    private ArrayList<HotCommentBean> recent_comments;

    public TextDetailAdapter(Context mContext) {
        inflater = LayoutInflater.from(mContext);
    }


    public void setHotCommentBean(ArrayList<HotCommentBean> recent_comments) {
        this.recent_comments = recent_comments;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        return new NormalCommentViewHolder(inflater.inflate(R.layout.hot_comment_item_view, parent, false));

    }

    @Override
    public int getItemViewType(int position) {
        return NORMAL_TYPE;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


        ((NormalCommentViewHolder) holder).bindViewholder(recent_comments.get(position));


    }

    @Override
    public int getItemCount() {
        return recent_comments == null ? 0 : recent_comments.size();
    }
}
