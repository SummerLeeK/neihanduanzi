package com.lee.neihanduanzi.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.lee.neihanduanzi.R;
import com.lee.neihanduanzi.adapter.CommentAdapter;
import com.lee.neihanduanzi.bean.HotCommentBean;
import com.lee.neihanduanzi.bean.TopCommentBean;
import com.lee.neihanduanzi.widget.MyListView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by u on 2017/6/24.
 */

public class HotCommentViewHolder extends RecyclerView.ViewHolder {
    @Bind(R.id.subtitle)
    TextView subtitle;
    @Bind(R.id.hot_comment)
    MyListView hotComment;

    private CommentAdapter adapter;

    public HotCommentViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void bindViewHolder( ArrayList<HotCommentBean> top_comments){
        subtitle.setText("热门评论（"+top_comments.size()+")");
        adapter=new CommentAdapter(top_comments,itemView.getContext(),true);
        hotComment.setAdapter(adapter);
    }
}
