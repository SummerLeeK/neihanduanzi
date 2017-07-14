package com.lee.neihanduanzi.fragment;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
import com.lee.neihanduanzi.bean.DataBean;
import com.lee.neihanduanzi.bean.PicBean;
import com.lee.neihanduanzi.listener.OnLoadMoreStateListener;
import com.lee.neihanduanzi.listener.OnLoadmoreListener;
import com.lee.neihanduanzi.listener.TextFragmentView;
import com.lee.neihanduanzi.presenter.Presenter;
import com.lee.neihanduanzi.widget.FooterView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by u on 2017/6/22.
 */

public class PicFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, OnLoadmoreListener,TextFragmentView{


    @Bind(R.id.recycle)
    RecyclerView recycle;
    @Bind(R.id.swipe)
    SwipeRefreshLayout swipe;

    private Context context;
    private LinearLayoutManager layoutManager;

    private PicRecycleAdapter adapter;
    private SmartRecyclerAdapter smartRecyclerAdapter;

    private ArrayList<DataBean> dataBeen;
    private boolean isRefresh;
    private Presenter picPresenter;

    private static OnLoadMoreStateListener listener;
    private FooterView footerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_text, container, false);
        Log.i("info", "图片");
        ButterKnife.bind(this, root);

        initView();
        return root;
    }


    protected void initView() {
        context=getContext();
        dataBeen=new ArrayList<>();
        swipe.setOnRefreshListener(this);
        swipe.setColorSchemeResources(R.color.colorAccent);
        adapter=new PicRecycleAdapter(context);
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

        picPresenter=new Presenter(this);
        picPresenter.request("pic");

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
        picPresenter.request("pic");
    }

    @Override
    public void loadMore() {
        isRefresh=false;
        picPresenter.request("pic");

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
            Toast.makeText(context,"网络连接失败！"+reason.toString(),Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showLoadSuccessView(Object success) {
        swipe.setRefreshing(false);
        footerView.setVisibility(View.VISIBLE);
        PicBean picBean= (PicBean) success;
        if (listener!=null){
            listener.loadSuccess();
        }
        if (isRefresh){
            swipe.setRefreshing(false);
            dataBeen= (ArrayList<DataBean>) picBean.getData().getData();
            recycle.smoothScrollToPosition(0);
        }else {
            for (DataBean dataBean:picBean.getData().getData()){
                dataBeen.add(dataBean);
            }
        }
        adapter.setData(dataBeen);
        adapter.notifyDataSetChanged();
        isRefresh=false;

    }
}
