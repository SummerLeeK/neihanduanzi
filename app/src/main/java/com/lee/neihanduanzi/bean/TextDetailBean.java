package com.lee.neihanduanzi.bean;

import java.util.ArrayList;

/**
 * Created by u on 2017/6/24.
 */

public class TextDetailBean extends BaseBean{
    public int type;
    public ArrayList<HotCommentBean> bean;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public ArrayList<HotCommentBean> getBean() {
        return bean;
    }

    public void setBean(ArrayList<HotCommentBean> bean) {
        this.bean = bean;
    }
}
