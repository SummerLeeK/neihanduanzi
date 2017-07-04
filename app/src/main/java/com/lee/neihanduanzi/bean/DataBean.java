package com.lee.neihanduanzi.bean;

import java.util.List;

/**
 * Created by u on 2017/6/30.
 */

public class DataBean extends BaseBean {

    private GroupBean group;
    private int type;
    private double display_time;
    private double online_time;
    private List<HotCommentBean> comments;

    public GroupBean getGroup() {
        return group;
    }

    public void setGroup(GroupBean group) {
        this.group = group;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getDisplay_time() {
        return display_time;
    }

    public void setDisplay_time(double display_time) {
        this.display_time = display_time;
    }

    public double getOnline_time() {
        return online_time;
    }

    public void setOnline_time(double online_time) {
        this.online_time = online_time;
    }

    public List<HotCommentBean> getComments() {
        return comments;
    }

    public void setComments(List<HotCommentBean> comments) {
        this.comments = comments;
    }


}

