package com.lee.neihanduanzi.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by u on 2017/6/30.
 */

public class VideoBean extends BaseBean {

    private CategoryBean category;
    private String utm_campaign;
    private Object hide_top_banner;
    private String utm_medium;
    private String utm_source;
    private String message;
    private int category_id;
    private DataBeanX data;

    public CategoryBean getCategory() {
        return category;
    }

    public void setCategory(CategoryBean category) {
        this.category = category;
    }

    public String getUtm_campaign() {
        return utm_campaign;
    }

    public void setUtm_campaign(String utm_campaign) {
        this.utm_campaign = utm_campaign;
    }

    public Object getHide_top_banner() {
        return hide_top_banner;
    }

    public void setHide_top_banner(Object hide_top_banner) {
        this.hide_top_banner = hide_top_banner;
    }

    public String getUtm_medium() {
        return utm_medium;
    }

    public void setUtm_medium(String utm_medium) {
        this.utm_medium = utm_medium;
    }

    public String getUtm_source() {
        return utm_source;
    }

    public void setUtm_source(String utm_source) {
        this.utm_source = utm_source;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }


    public static class DataBeanX extends BaseBean{
        private boolean has_more;
        private int min_time;
        private String tip;
        private int max_time;
        private List<DataBean> data;

        public boolean isHas_more() {
            return has_more;
        }

        public void setHas_more(boolean has_more) {
            this.has_more = has_more;
        }

        public int getMin_time() {
            return min_time;
        }

        public void setMin_time(int min_time) {
            this.min_time = min_time;
        }

        public String getTip() {
            return tip;
        }

        public void setTip(String tip) {
            this.tip = tip;
        }

        public int getMax_time() {
            return max_time;
        }

        public void setMax_time(int max_time) {
            this.max_time = max_time;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

    }
}
