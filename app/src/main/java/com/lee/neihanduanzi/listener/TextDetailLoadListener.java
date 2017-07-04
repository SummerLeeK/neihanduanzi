package com.lee.neihanduanzi.listener;

import com.lee.neihanduanzi.bean.CommentBean;

/**
 * Created by u on 2017/6/24.
 */

public interface TextDetailLoadListener {

    void loadSuccess(CommentBean commentBean);

    void loadFailed(Object reason);
}
