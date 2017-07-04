package com.lee.neihanduanzi.listener;

import com.lee.neihanduanzi.bean.TextBean;

/**
 * Created by u on 2017/6/22.
 */

public interface TextFragmentView {

    void showLoadFailedView(Object reason);

    void showLoadSuccessView(Object success);
}
