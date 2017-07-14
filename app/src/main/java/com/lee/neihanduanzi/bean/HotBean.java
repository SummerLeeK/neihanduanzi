package com.lee.neihanduanzi.bean;

import java.util.List;

/**
 * Created by u on 2017/7/5.
 */

public class HotBean extends BaseBean {

    private String message;
    private String tt_stable;
    private DataBean data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTt_stable() {
        return tt_stable;
    }

    public void setTt_stable(String tt_stable) {
        this.tt_stable = tt_stable;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean extends BaseBean{
        private RotateBannerBean rotate_banner;
        private CategoriesBean categories;
        private GodCommentBean god_comment;

        public RotateBannerBean getRotate_banner() {
            return rotate_banner;
        }

        public void setRotate_banner(RotateBannerBean rotate_banner) {
            this.rotate_banner = rotate_banner;
        }

        public CategoriesBean getCategories() {
            return categories;
        }

        public void setCategories(CategoriesBean categories) {
            this.categories = categories;
        }

        public GodCommentBean getGod_comment() {
            return god_comment;
        }

        public void setGod_comment(GodCommentBean god_comment) {
            this.god_comment = god_comment;
        }

        public static class RotateBannerBean extends BaseBean {
            private int count;
            private List<?> banners;

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public List<?> getBanners() {
                return banners;
            }

            public void setBanners(List<?> banners) {
                this.banners = banners;
            }
        }

        public static class CategoriesBean extends BaseBean{
            private String name;
            private int priority;
            private int category_count;
            private String intro;
            private int id;
            private Object icon;
            private List<CategoryListBean> category_list;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getPriority() {
                return priority;
            }

            public void setPriority(int priority) {
                this.priority = priority;
            }

            public int getCategory_count() {
                return category_count;
            }

            public void setCategory_count(int category_count) {
                this.category_count = category_count;
            }

            public String getIntro() {
                return intro;
            }

            public void setIntro(String intro) {
                this.intro = intro;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public Object getIcon() {
                return icon;
            }

            public void setIcon(Object icon) {
                this.icon = icon;
            }

            public List<CategoryListBean> getCategory_list() {
                return category_list;
            }

            public void setCategory_list(List<CategoryListBean> category_list) {
                this.category_list = category_list;
            }

            public static class CategoryListBean extends BaseBean{
                private ExtraBean extra;
                private int allow_video;
                private boolean is_recommend;
                private int allow_text_and_pic;
                private String channels;
                private boolean visible;
                private String intro;
                private String top_end_time;
                private int id;
                private int post_rule_id;
                private int share_type;
                private int big_category_id;
                private String icon_url;
                private int dedup;
                private String buttons;
                private Object mix_weight;
                private int type;
                private int today_updates;
                private int status;
                private int allow_text;
                private int allow_gif;
                private boolean is_top;
                private boolean is_risk;
                private int allow_multi_image;
                private String placeholder;
                private String icon;
                private int total_updates;
                private int subscribe_count;
                private String name;
                private boolean has_timeliness;
                private String tag;
                private String small_icon_url;
                private String small_icon;
                private String top_start_time;
                private int priority;
                private List<?> material_bar;

                public ExtraBean getExtra() {
                    return extra;
                }

                public void setExtra(ExtraBean extra) {
                    this.extra = extra;
                }

                public int getAllow_video() {
                    return allow_video;
                }

                public void setAllow_video(int allow_video) {
                    this.allow_video = allow_video;
                }

                public boolean isIs_recommend() {
                    return is_recommend;
                }

                public void setIs_recommend(boolean is_recommend) {
                    this.is_recommend = is_recommend;
                }

                public int getAllow_text_and_pic() {
                    return allow_text_and_pic;
                }

                public void setAllow_text_and_pic(int allow_text_and_pic) {
                    this.allow_text_and_pic = allow_text_and_pic;
                }

                public String getChannels() {
                    return channels;
                }

                public void setChannels(String channels) {
                    this.channels = channels;
                }

                public boolean isVisible() {
                    return visible;
                }

                public void setVisible(boolean visible) {
                    this.visible = visible;
                }

                public String getIntro() {
                    return intro;
                }

                public void setIntro(String intro) {
                    this.intro = intro;
                }

                public String getTop_end_time() {
                    return top_end_time;
                }

                public void setTop_end_time(String top_end_time) {
                    this.top_end_time = top_end_time;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getPost_rule_id() {
                    return post_rule_id;
                }

                public void setPost_rule_id(int post_rule_id) {
                    this.post_rule_id = post_rule_id;
                }

                public int getShare_type() {
                    return share_type;
                }

                public void setShare_type(int share_type) {
                    this.share_type = share_type;
                }

                public int getBig_category_id() {
                    return big_category_id;
                }

                public void setBig_category_id(int big_category_id) {
                    this.big_category_id = big_category_id;
                }

                public String getIcon_url() {
                    return icon_url;
                }

                public void setIcon_url(String icon_url) {
                    this.icon_url = icon_url;
                }

                public int getDedup() {
                    return dedup;
                }

                public void setDedup(int dedup) {
                    this.dedup = dedup;
                }

                public String getButtons() {
                    return buttons;
                }

                public void setButtons(String buttons) {
                    this.buttons = buttons;
                }

                public Object getMix_weight() {
                    return mix_weight;
                }

                public void setMix_weight(Object mix_weight) {
                    this.mix_weight = mix_weight;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }

                public int getToday_updates() {
                    return today_updates;
                }

                public void setToday_updates(int today_updates) {
                    this.today_updates = today_updates;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public int getAllow_text() {
                    return allow_text;
                }

                public void setAllow_text(int allow_text) {
                    this.allow_text = allow_text;
                }

                public int getAllow_gif() {
                    return allow_gif;
                }

                public void setAllow_gif(int allow_gif) {
                    this.allow_gif = allow_gif;
                }

                public boolean isIs_top() {
                    return is_top;
                }

                public void setIs_top(boolean is_top) {
                    this.is_top = is_top;
                }

                public boolean isIs_risk() {
                    return is_risk;
                }

                public void setIs_risk(boolean is_risk) {
                    this.is_risk = is_risk;
                }

                public int getAllow_multi_image() {
                    return allow_multi_image;
                }

                public void setAllow_multi_image(int allow_multi_image) {
                    this.allow_multi_image = allow_multi_image;
                }

                public String getPlaceholder() {
                    return placeholder;
                }

                public void setPlaceholder(String placeholder) {
                    this.placeholder = placeholder;
                }

                public String getIcon() {
                    return icon;
                }

                public void setIcon(String icon) {
                    this.icon = icon;
                }

                public int getTotal_updates() {
                    return total_updates;
                }

                public void setTotal_updates(int total_updates) {
                    this.total_updates = total_updates;
                }

                public int getSubscribe_count() {
                    return subscribe_count;
                }

                public void setSubscribe_count(int subscribe_count) {
                    this.subscribe_count = subscribe_count;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public boolean isHas_timeliness() {
                    return has_timeliness;
                }

                public void setHas_timeliness(boolean has_timeliness) {
                    this.has_timeliness = has_timeliness;
                }

                public String getTag() {
                    return tag;
                }

                public void setTag(String tag) {
                    this.tag = tag;
                }

                public String getSmall_icon_url() {
                    return small_icon_url;
                }

                public void setSmall_icon_url(String small_icon_url) {
                    this.small_icon_url = small_icon_url;
                }

                public String getSmall_icon() {
                    return small_icon;
                }

                public void setSmall_icon(String small_icon) {
                    this.small_icon = small_icon;
                }

                public String getTop_start_time() {
                    return top_start_time;
                }

                public void setTop_start_time(String top_start_time) {
                    this.top_start_time = top_start_time;
                }

                public int getPriority() {
                    return priority;
                }

                public void setPriority(int priority) {
                    this.priority = priority;
                }

                public List<?> getMaterial_bar() {
                    return material_bar;
                }

                public void setMaterial_bar(List<?> material_bar) {
                    this.material_bar = material_bar;
                }

                public static class ExtraBean extends BaseBean{
                    private String heat_hours;
                    private String heat_days;
                    private Object heat_start_time;
                    private boolean need_heat;
                    private boolean has_timeliness;
                    private boolean is_top;
                    private Object top_end_time;
                    private Object mix_weight;
                    private boolean is_risk;
                    private Object top_start_time;
                    private Object heat_end_time;
                    private List<?> default_label_ids;
                    private List<?> label_ids;

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

                    public boolean isHas_timeliness() {
                        return has_timeliness;
                    }

                    public void setHas_timeliness(boolean has_timeliness) {
                        this.has_timeliness = has_timeliness;
                    }

                    public boolean isIs_top() {
                        return is_top;
                    }

                    public void setIs_top(boolean is_top) {
                        this.is_top = is_top;
                    }

                    public Object getTop_end_time() {
                        return top_end_time;
                    }

                    public void setTop_end_time(Object top_end_time) {
                        this.top_end_time = top_end_time;
                    }

                    public Object getMix_weight() {
                        return mix_weight;
                    }

                    public void setMix_weight(Object mix_weight) {
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

                    public List<?> getLabel_ids() {
                        return label_ids;
                    }

                    public void setLabel_ids(List<?> label_ids) {
                        this.label_ids = label_ids;
                    }
                }
            }
        }

        public static class GodCommentBean extends BaseBean{
            private int count;
            private String intro;
            private String name;
            private String icon;

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public String getIntro() {
                return intro;
            }

            public void setIntro(String intro) {
                this.intro = intro;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }
        }
    }
}
