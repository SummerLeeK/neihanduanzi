package com.lee.neihanduanzi.fragment;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
import com.lee.neihanduanzi.adapter.HotRecycleAdapter;
import com.lee.neihanduanzi.adapter.VideoRecycleAdapter;
import com.lee.neihanduanzi.bean.HotBean;
import com.lee.neihanduanzi.bean.VideoBean;
import com.lee.neihanduanzi.listener.OnLoadMoreStateListener;
import com.lee.neihanduanzi.listener.OnLoadmoreListener;
import com.lee.neihanduanzi.listener.TextFragmentView;
import com.lee.neihanduanzi.presenter.DiscoveryPresenter;
import com.lee.neihanduanzi.widget.CustomVideoView;
import com.lee.neihanduanzi.widget.FooterView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by u on 2017/6/22.
 */

public class HotFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, TextFragmentView {


    @Bind(R.id.recycle)
    RecyclerView recycle;
    @Bind(R.id.swipe)
    SwipeRefreshLayout swipe;

    private Context context;
    private LinearLayoutManager layoutManager;

    private HotRecycleAdapter adapter;

    private List<HotBean.DataBean.CategoriesBean.CategoryListBean> dataBeen;
    private boolean isRefresh;

    private DiscoveryPresenter presenter;

    private static final String TAG = "HotFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_text, container, false);
        ButterKnife.bind(this, root);
        initView();

        return root;
    }


    @Override
    protected void initView() {

        swipe.setOnRefreshListener(this);
        context = getContext();
        dataBeen = new ArrayList<>();
        swipe.setColorSchemeResources(R.color.colorAccent);
        adapter = new HotRecycleAdapter(context);
        recycle.setAdapter(adapter);
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

        presenter = new DiscoveryPresenter(this);
        presenter.request("discovery");
        Log.i(TAG, "request");

    }

    @Override
    public void setListener(OnLoadMoreStateListener listeners) {

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onRefresh() {
        isRefresh = true;
        presenter.request("discovery");
    }


    @Override
    public void showLoadFailedView(Object reason) {
        swipe.setRefreshing(false);
        isRefresh = false;
        Toast.makeText(context, "网络连接失败！" + reason.toString(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showLoadSuccessView(Object success) {
        swipe.setRefreshing(false);
        HotBean hotBean = (HotBean) success;
        dataBeen = hotBean.getData().getCategories().getCategory_list();
        adapter.setData(dataBeen);
        adapter.notifyDataSetChanged();
        isRefresh = false;
    }
}
