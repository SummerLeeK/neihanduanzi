package com.lee.neihanduanzi.bean;


/**
 * 发现列表项
 * Created by u on 2017/6/22.
 */

public class DiscoveryBean extends BaseBean {

    private CategoryBean category;
    private String utm_campaign;
    private int bar_flag;
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

    public int getBar_flag() {
        return bar_flag;
    }

    public void setBar_flag(int bar_flag) {
        this.bar_flag = bar_flag;
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

}
