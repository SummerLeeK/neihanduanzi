package com.lee.neihanduanzi.activity;

import android.support.v7.app.AppCompatActivity;

import com.lee.neihanduanzi.listener.OnLoadMoreStateListener;

/**
 * Created by u on 2017/7/14.
 */

public abstract class BaseActivity extends AppCompatActivity {

    public abstract  void setListener(OnLoadMoreStateListener listeners);
}
