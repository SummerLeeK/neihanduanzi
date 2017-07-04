package com.lee.neihanduanzi.fragment;


import android.support.v4.app.Fragment;

import com.lee.neihanduanzi.listener.OnLoadMoreStateListener;

/**
 * Created by u on 2017/6/22.
 */

public abstract class BaseFragment extends Fragment {

    protected abstract void initView();
    public abstract  void setListener(OnLoadMoreStateListener listeners);
}
