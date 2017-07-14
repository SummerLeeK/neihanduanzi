package com.lee.neihanduanzi.widget;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.lee.neihanduanzi.R;
import com.lee.neihanduanzi.activity.BaseActivity;
import com.lee.neihanduanzi.fragment.BaseFragment;
import com.lee.neihanduanzi.fragment.TextFragment;
import com.lee.neihanduanzi.listener.OnLoadMoreStateListener;
import com.lee.neihanduanzi.listener.OnLoadmoreListener;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by u on 2017/6/24.
 */

public class FooterView extends RelativeLayout implements View.OnClickListener, OnLoadMoreStateListener {

    @Bind(R.id.load_more)
    Button loadMore;
    @Bind(R.id.progress)
    ProgressBar progress;
    private LayoutInflater inflater;

    private OnLoadmoreListener listener;

    public void setListener(OnLoadmoreListener listener) {
        this.listener = listener;
    }

    public FooterView(Context context) {
        this(context, null);
    }

    public FooterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflater = LayoutInflater.from(context);
        initView();
    }

    private void initView() {
        View root = inflater.inflate(R.layout.load_more_view, this);
        ButterKnife.bind(this,root);
        loadMore.setOnClickListener(this);

    }
    public void setFragmentListener(BaseFragment fragment){
        fragment.setListener(this);
    }

    public void setFragmentListener(BaseActivity activity){
        activity.setListener(this);
    }
    @Override
    public void onClick(View v) {
        if (listener!=null){
            listener.loadMore();
        }
        loadMore.setVisibility(GONE);
        progress.setVisibility(VISIBLE);
    }

    @Override
    public void loadSuccess() {
        loadMore.setText("点击加载更多");
        loadMore.setVisibility(VISIBLE);
        progress.setVisibility(GONE);
    }

    @Override
    public void loadFailed() {
        loadMore.setText("加载失败了，请稍后重试");
        loadMore.setVisibility(VISIBLE);
        progress.setVisibility(GONE);
    }
}
