package com.lee.neihanduanzi.fragment;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.headerfooter.songhang.library.SmartRecyclerAdapter;
import com.lee.neihanduanzi.R;
import com.lee.neihanduanzi.adapter.TextRecycleAdapter;
import com.lee.neihanduanzi.bean.DataBean;
import com.lee.neihanduanzi.bean.TextBean;
import com.lee.neihanduanzi.listener.TextFragmentView;
import com.lee.neihanduanzi.listener.OnLoadMoreStateListener;
import com.lee.neihanduanzi.listener.OnLoadmoreListener;
import com.lee.neihanduanzi.presenter.TextPresenter;
import com.lee.neihanduanzi.widget.FooterView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by u on 2017/6/22.
 */

public class TextFragment extends BaseFragment implements TextFragmentView, SwipeRefreshLayout.OnRefreshListener, OnLoadmoreListener {

    @Bind(R.id.recycle)
    RecyclerView recycle;
    @Bind(R.id.swipe)
    SwipeRefreshLayout swipe;

    private FooterView footerView;

    private LinearLayoutManager layoutManager;

    private TextPresenter presenter;

    private List<DataBean> dataBeen;

    private TextRecycleAdapter adapter;
    private boolean isRefresh = true;
    private Context context;

    private static OnLoadMoreStateListener listener;

    public void setListener(OnLoadMoreStateListener listeners) {
        listener=listeners;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_text, container, false);
        ButterKnife.bind(this, root);

        initView();

        return root;
    }


    protected void initView() {

        context = getContext();
        dataBeen = new ArrayList<>();
        adapter = new TextRecycleAdapter(getContext());
        footerView = new FooterView(context);
        footerView.setVisibility(View.GONE);
        footerView.setListener(this);
        footerView.setFragmentListener(this);
        SmartRecyclerAdapter smartRecyclerAdapter = new SmartRecyclerAdapter(adapter);
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
        swipe.setColorSchemeResources(R.color.colorAccent);
        swipe.setOnRefreshListener(this);
        presenter = new TextPresenter(this);

        presenter.requestText();
    }

    @Override
    public void showLoadFailedView(Object reason) {
        if (listener != null) {
            listener.loadFailed();
        }
        if (isRefresh) {
            swipe.setRefreshing(false);
            recycle.setVisibility(View.GONE);
            Toast.makeText(context,"网络连接失败！",Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void showLoadSuccessView(Object success) {
        footerView.setVisibility(View.VISIBLE);
        TextBean textBean= (TextBean) success;
        if (listener!=null){
            listener.loadSuccess();
        }
        recycle.setVisibility(View.VISIBLE);


        if (isRefresh) {
            swipe.setRefreshing(false);
            dataBeen = textBean.getData().getData();
        } else {
            for (int i = 0; i < textBean.getData().getData().size(); i++) {
                dataBeen.add(textBean.getData().getData().get(i));
            }
        }
        adapter.setData(dataBeen);
        adapter.notifyDataSetChanged();
//        recycle.invalidate();
        isRefresh = false;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onRefresh() {
        isRefresh = true;
        presenter.requestText();
    }

    @Override
    public void loadMore() {
        isRefresh = false;
        presenter.requestText();
    }
}
