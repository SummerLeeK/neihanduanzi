package com.lee.neihanduanzi.listener;

import com.lee.neihanduanzi.activity.DetailActivity;

/**
 * Created by u on 2017/6/24.
 */

public interface OnLoadMoreStateListener {

    /**
     * 改变footview的显示状态
     */

    void loadSuccess();

    void loadFailed();


}
