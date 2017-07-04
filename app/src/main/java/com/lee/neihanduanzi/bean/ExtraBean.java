package com.lee.neihanduanzi.bean;

import java.util.List;

/**
 * Created by u on 2017/6/30.
 */

public class ExtraBean extends BaseBean {

    private String heat_hours;
    private String heat_days;
    private Object heat_start_time;
    private boolean need_heat;
    private boolean is_top;
    private boolean has_timeliness;
    private Object top_end_time;
    private int mix_weight;
    private boolean is_risk;
    private Object top_start_time;
    private Object heat_end_time;
    private List<?> default_label_ids;
    private List<Integer> label_ids;

    public String getHeat_hours() {
        return heat_hours;
    }

    public void setHeat_hours(String heat_hours) {
        this.heat_hours = heat_hours;
    }

    public String getHeat_days() {
        return heat_days;
    }

    public void setHeat_days(String heat_days) {
        this.heat_days = heat_days;
    }

    public Object getHeat_start_time() {
        return heat_start_time;
    }

    public void setHeat_start_time(Object heat_start_time) {
        this.heat_start_time = heat_start_time;
    }

    public boolean isNeed_heat() {
        return need_heat;
    }

    public void setNeed_heat(boolean need_heat) {
        this.need_heat = need_heat;
    }

    public boolean isIs_top() {
        return is_top;
    }

    public void setIs_top(boolean is_top) {
        this.is_top = is_top;
    }

    public boolean isHas_timeliness() {
        return has_timeliness;
    }

    public void setHas_timeliness(boolean has_timeliness) {
        this.has_timeliness = has_timeliness;
    }

    public Object getTop_end_time() {
        return top_end_time;
    }

    public void setTop_end_time(Object top_end_time) {
        this.top_end_time = top_end_time;
    }

    public int getMix_weight() {
        return mix_weight;
    }

    public void setMix_weight(int mix_weight) {
        this.mix_weight = mix_weight;
    }

    public boolean isIs_risk() {
        return is_risk;
    }

    public void setIs_risk(boolean is_risk) {
        this.is_risk = is_risk;
    }

    public Object getTop_start_time() {
        return top_start_time;
    }

    public void setTop_start_time(Object top_start_time) {
        this.top_start_time = top_start_time;
    }

    public Object getHeat_end_time() {
        return heat_end_time;
    }

    public void setHeat_end_time(Object heat_end_time) {
        this.heat_end_time = heat_end_time;
    }

    public List<?> getDefault_label_ids() {
        return default_label_ids;
    }

    public void setDefault_label_ids(List<?> default_label_ids) {
        this.default_label_ids = default_label_ids;
    }

    public List<Integer> getLabel_ids() {
        return label_ids;
    }

    public void setLabel_ids(List<Integer> label_ids) {
        this.label_ids = label_ids;
    }
}

