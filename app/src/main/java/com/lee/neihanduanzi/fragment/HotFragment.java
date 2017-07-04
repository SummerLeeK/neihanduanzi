package com.lee.neihanduanzi.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lee.neihanduanzi.R;
import com.lee.neihanduanzi.listener.OnLoadMoreStateListener;

import butterknife.ButterKnife;

/**
 * Created by u on 2017/6/22.
 */

public class HotFragment extends BaseFragment {



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.test_fragment,container,false);
        Log.i("info","热吧");
//        ButterKnife.bind(this, root);

        return root;
    }


    @Override
    protected void initView() {

    }

    @Override
    public void setListener(OnLoadMoreStateListener listeners) {

    }
}
