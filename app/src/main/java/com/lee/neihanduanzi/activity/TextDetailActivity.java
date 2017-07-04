package com.lee.neihanduanzi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.headerfooter.songhang.library.SmartRecyclerAdapter;
import com.lee.neihanduanzi.R;
import com.lee.neihanduanzi.adapter.TextDetailAdapter;
import com.lee.neihanduanzi.bean.CommentBean;
import com.lee.neihanduanzi.bean.GroupBean;
import com.lee.neihanduanzi.bean.HotCommentBean;
import com.lee.neihanduanzi.bean.TextBean;
import com.lee.neihanduanzi.bean.TextDetailBean;
import com.lee.neihanduanzi.bean.TopCommentBean;
import com.lee.neihanduanzi.listener.TextDetailLoadListener;
import com.lee.neihanduanzi.presenter.TextDetailPresenter;
import com.lee.neihanduanzi.widget.DetailHeaderView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by u on 2017/6/24.
 */

public class TextDetailActivity extends AppCompatActivity implements TextDetailLoadListener, View.OnClickListener {

    @Bind(R.id.detail_recycle)
    RecyclerView detailRecycle;
    @Bind(R.id.back)
    ImageView back;
    @Bind(R.id.title)
    TextView title;
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
    private int type;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_detail);
        ButterKnife.bind(this);

        data = new ArrayList<>();
        recent_comments = new ArrayList<>();
        top_comments=new ArrayList<>();
        detailRecycle.setLayoutManager(new LinearLayoutManager(this, OrientationHelper.VERTICAL, false));
        adapter = new TextDetailAdapter(this);
        smartRecyclerAdapter = new SmartRecyclerAdapter(adapter);

        back.setOnClickListener(this);

        intent = getIntent();
        groupBean = (GroupBean) intent.getSerializableExtra("data");
        type=intent.getIntExtra("type",1);
        detailRecycle.setAdapter(smartRecyclerAdapter);

        presenter = new TextDetailPresenter(this);
        presenter.requestTextDetail(groupBean.getId(), currentOffset * 20);

    }

    @Override
    public void loadSuccess(CommentBean commentBean) {

        if (currentOffset == 0) {
            recent_comments = (ArrayList<HotCommentBean>) commentBean.getData().getRecent_comments();
            top_comments = (ArrayList<HotCommentBean>) commentBean.getData().getTop_comments();
        } else {
            for (int i = 0; i < commentBean.getData().getRecent_comments().size(); i++) {
                recent_comments.add(commentBean.getData().getRecent_comments().get(i));
            }
        }




        headerView = new DetailHeaderView(this);
        headerView.setData(groupBean, top_comments,recent_comments.size(),type);
        smartRecyclerAdapter.setHeaderView(headerView);

        data.add(TextDetailAdapter.NORMAL_TYPE);

        adapter.setHotCommentBean(recent_comments);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void loadFailed(Object reason) {
        Toast.makeText(this, "" + reason, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public void onClick(View v) {
        onBackPressed();
    }
}
