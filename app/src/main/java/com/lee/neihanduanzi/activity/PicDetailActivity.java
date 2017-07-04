package com.lee.neihanduanzi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.headerfooter.songhang.library.SmartRecyclerAdapter;
import com.lee.neihanduanzi.R;
import com.lee.neihanduanzi.adapter.TextDetailAdapter;
import com.lee.neihanduanzi.bean.CommentBean;
import com.lee.neihanduanzi.bean.GroupBean;
import com.lee.neihanduanzi.bean.HotCommentBean;
import com.lee.neihanduanzi.listener.TextDetailLoadListener;
import com.lee.neihanduanzi.presenter.TextDetailPresenter;
import com.lee.neihanduanzi.widget.DetailHeaderView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by u on 2017/6/30.
 */

public class PicDetailActivity extends AppCompatActivity implements TextDetailLoadListener, View.OnClickListener{

    @Bind(R.id.back)
    ImageView back;
    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.detail_recycle)
    RecyclerView detailRecycle;

    private TextDetailPresenter presenter;

    private ArrayList<Integer> data;
    private Intent intent;
    private GroupBean groupBean;
    private DetailHeaderView headerView;
    private TextDetailAdapter adapter;
    private SmartRecyclerAdapter smartRecyclerAdapter;
    private ArrayList<HotCommentBean> top_comments;
    private int currentOffset = 0;
    private ArrayList<HotCommentBean> recent_comments;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_text_detail);
        ButterKnife.bind(this);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void loadSuccess(CommentBean commentBean) {

    }

    @Override
    public void loadFailed(Object reason) {

    }
}
