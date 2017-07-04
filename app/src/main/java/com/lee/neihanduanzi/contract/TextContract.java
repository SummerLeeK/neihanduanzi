package com.lee.neihanduanzi.contract;

import com.lee.neihanduanzi.listener.TextFragmentView;

/**
 * Created by u on 2017/6/22.
 */

public interface TextContract {
    void requestText(String type,long time,TextFragmentView textFragmentView);
}
