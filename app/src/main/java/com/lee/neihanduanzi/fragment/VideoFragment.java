package com.lee.neihanduanzi.fragment;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.headerfooter.songhang.library.SmartRecyclerAdapter;
import com.lee.neihanduanzi.R;
import com.lee.neihanduanzi.adapter.PicRecycleAdapter;
import com.lee.neihanduanzi.adapter.VideoRecycleAdapter;
import com.lee.neihanduanzi.bean.DataBean;
import com.lee.neihanduanzi.bean.PicBean;
import com.lee.neihanduanzi.bean.VideoBean;
import com.lee.neihanduanzi.listener.OnLoadMoreStateListener;
import com.lee.neihanduanzi.listener.OnLoadmoreListener;
import com.lee.neihanduanzi.listener.TextFragmentView;
import com.lee.neihanduanzi.presenter.Presenter;
import com.lee.neihanduanzi.presenter.VideoPresenter;
import com.lee.neihanduanzi.widget.FooterView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by u on 2017/6/22.
 */

public class VideoFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, TextFragmentView, OnLoadmoreListener {

    @Bind(R.id.recycle)
    RecyclerView recycle;
    @Bind(R.id.swipe)
    SwipeRefreshLayout swipe;
    private FooterView footerView;
    private Context context;
    private LinearLayoutManager layoutManager;

    private VideoRecycleAdapter adapter;
    private SmartRecyclerAdapter smartRecyclerAdapter;

    private ArrayList<VideoBean.DataBeanX.DataBean> dataBeen;
    private boolean isRefresh;
    private VideoPresenter picPresenter;

    private static OnLoadMoreStateListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_text, container, false);
        ButterKnife.bind(this, root);

        initView();

        return root;
    }


    protected void initView() {
        context=getContext();
        dataBeen=new ArrayList<>();
        swipe.setOnRefreshListener(this);
        swipe.setColorSchemeResources(R.color.colorAccent);
        adapter=new VideoRecycleAdapter(context);
        smartRecyclerAdapter=new SmartRecyclerAdapter(adapter);
        footerView = new FooterView(context);
        footerView.setVisibility(View.GONE);
        footerView.setListener(this);
        footerView.setFragmentListener(this);
        smartRecyclerAdapter.setFooterView(footerView);
        recycle.setAdapter(smartRecyclerAdapter);
        recycle.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.left = 20;
                outRect.right = 20;
                outRect.bottom = 30;
            }
        });

        recycle.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false));
        layoutManager = (LinearLayoutManager) recycle.getLayoutManager();


        recycle.setOnScrollListener(new RecyclerView.OnScrollListener() {

            int firstVisibleItem, lastVisibleItem;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                firstVisibleItem=layoutManager.findFirstVisibleItemPosition();
                lastVisibleItem=layoutManager.findLastVisibleItemPosition();




            }
        });
        picPresenter=new VideoPresenter(this);
        picPresenter.request("video");
    }

    @Override
    public void setListener(OnLoadMoreStateListener listeners) {
        listener=listeners;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onRefresh() {
        isRefresh=true;
        picPresenter.request("video");
    }

    @Override
    public void loadMore() {
        isRefresh=false;
        picPresenter.request("video");

    }

    @Override
    public void showLoadFailedView(Object reason) {
        swipe.setRefreshing(false);
        footerView.setVisibility(View.GONE);
        if (listener != null) {
            listener.loadFailed();
        }
        if (isRefresh) {
            swipe.setRefreshing(false);
            recycle.setVisibility(View.GONE);
            Toast.makeText(context,"网络连接失败！"+reason.toString(),Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showLoadSuccessView(Object success) {
        swipe.setRefreshing(false);
        footerView.setVisibility(View.VISIBLE);
        VideoBean videoBean= (VideoBean) success;
        if (listener!=null){
            listener.loadSuccess();
        }
        if (isRefresh){
            swipe.setRefreshing(false);
            dataBeen= (ArrayList<VideoBean.DataBeanX.DataBean>) videoBean.getData().getData();
        }else {
            for (VideoBean.DataBeanX.DataBean dataBean:videoBean.getData().getData()){
                dataBeen.add(dataBean);
            }
        }
        adapter.setData(dataBeen);
        adapter.notifyDataSetChanged();
        isRefresh=false;

    }
}
