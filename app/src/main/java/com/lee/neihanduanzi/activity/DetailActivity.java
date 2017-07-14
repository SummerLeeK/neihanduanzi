package com.lee.neihanduanzi.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.headerfooter.songhang.library.SmartRecyclerAdapter;
import com.lee.neihanduanzi.R;
import com.lee.neihanduanzi.adapter.MultiTypeAdapter;
import com.lee.neihanduanzi.bean.DataBean;
import com.lee.neihanduanzi.bean.DiscoveryBean;
import com.lee.neihanduanzi.listener.OnLoadMoreStateListener;
import com.lee.neihanduanzi.listener.OnLoadmoreListener;
import com.lee.neihanduanzi.listener.TextFragmentView;
import com.lee.neihanduanzi.presenter.MultiTypePresenter;
import com.lee.neihanduanzi.widget.FooterView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by u on 2017/6/30.
 */

public class DetailActivity extends BaseActivity implements View.OnClickListener, SwipeRefreshLayout.OnRefreshListener, TextFragmentView, OnLoadmoreListener {


    @Bind(R.id.back)
    ImageView back;
    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.detail_recycle)
    RecyclerView detailRecycle;
    @Bind(R.id.swipe)
    SwipeRefreshLayout swipe;
    private ArrayList<DataBean> dataBeen;
    private Intent intent;
    private int id;
    private Context mContext;
    private LinearLayoutManager layoutManager;
    private MultiTypePresenter presenter;
    private SmartRecyclerAdapter smartRecyclerAdapter;
    private MultiTypeAdapter adapter;
    private boolean isRefresh;
    private static OnLoadMoreStateListener listener;
    private FooterView footerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discovry_view);
        ButterKnife.bind(this);
        intent = getIntent();
        initView();
    }

    private void initView() {

        title.setText(intent.getStringExtra("title"));
        id = intent.getIntExtra("id", 0);
        back.setOnClickListener(this);
        swipe.setOnRefreshListener(this);
        mContext = this;
        dataBeen = new ArrayList<>();
        swipe.setColorSchemeResources(R.color.colorAccent);
        adapter = new MultiTypeAdapter(mContext);
        smartRecyclerAdapter=new SmartRecyclerAdapter(adapter);
        footerView = new FooterView(mContext);
        footerView.setVisibility(View.GONE);
        footerView.setListener(this);
        footerView.setFragmentListener(this);
        smartRecyclerAdapter.setFooterView(footerView);
        detailRecycle.setAdapter(smartRecyclerAdapter);
        detailRecycle.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.left = 20;
                outRect.right = 20;
                outRect.bottom = 30;
            }
        });

        detailRecycle.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        layoutManager = (LinearLayoutManager) detailRecycle.getLayoutManager();

        presenter = new MultiTypePresenter(this);
        presenter.request("" + id);

    }

    @Override
    public void onClick(View v) {
        onBackPressed();
    }


    @Override
    public void onBackPressed() {
        this.finish();
    }

    @Override
    public void onRefresh() {
        isRefresh = true;
        presenter.request("" + id);
    }

    @Override
    public void showLoadFailedView(Object reason) {
        swipe.setRefreshing(false);
        Toast.makeText(mContext, "网络连接失败！" + reason.toString(), Toast.LENGTH_SHORT).show();
        footerView.setVisibility(View.GONE);
        if (listener != null) {
            listener.loadFailed();
        }
    }

    @Override
    public void showLoadSuccessView(Object success) {
        swipe.setRefreshing(false);
        footerView.setVisibility(View.VISIBLE);
        DiscoveryBean hotBean= (DiscoveryBean) success;
        if (listener!=null){
            listener.loadSuccess();
        }
        if (isRefresh){
            swipe.setRefreshing(false);
            dataBeen= (ArrayList<DataBean>) hotBean.getData().getData();
        }else {
            for (DataBean dataBean:hotBean.getData().getData()){
                dataBeen.add(dataBean);
            }
        }
        adapter.setData(dataBeen);
        adapter.notifyDataSetChanged();
        isRefresh=false;
    }

    @Override
    public void loadMore() {
        isRefresh=false;
        presenter.request("" + id);

    }

    @Override
    public void setListener(OnLoadMoreStateListener listeners) {
        listener=listeners;
    }
}
