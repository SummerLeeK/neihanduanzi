package com.lee.neihanduanzi.contract;

import com.lee.neihanduanzi.listener.TextDetailLoadListener;

/**
 * Created by u on 2017/6/24.
 */

public interface TextDetailContract {

    void requestDetail(long id, int offset,TextDetailLoadListener listener);
}
