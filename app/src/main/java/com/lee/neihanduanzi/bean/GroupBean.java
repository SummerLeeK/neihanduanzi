package com.lee.neihanduanzi.bean;

import java.util.List;

/**
 * Created by u on 2017/6/24.
 */

public class GroupBean extends BaseBean {

    private String text;
    private int create_time;
    private long id;
    private int favorite_count;
    private int go_detail_count;
    private int user_favorite;
    private int share_type;
    private double max_screen_width_percent;
    private int is_can_share;
    private int category_type;
    private String share_url;
    private int label;
    private String content;
    private int comment_count;
    private String id_str;
    private int media_type;
    private int share_count;
    private int type;
    private int status;
    private int has_comments;
    private GroupBean.LargeImageBean large_image;
    private int user_bury;
    private String status_desc;
    private UserBean user;
    private int is_gif;
    private int user_digg;
    private int online_time;
    private String category_name;
    private boolean category_visible;
    private int bury_count;
    private boolean is_anonymous;
    private int repin_count;
    private double min_screen_width_percent;
    private int digg_count;
    private GifvideoBean gifvideo;
    private int has_hot_comments;
    private int image_status;
    private int user_repin;
    private GroupBean.ActivityBean activity;
    private long group_id;
    private GroupBean.MiddleImageBean middle_image;
    private int category_id;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getCreate_time() {
        return create_time;
    }

    public void setCreate_time(int create_time) {
        this.create_time = create_time;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getFavorite_count() {
        return favorite_count;
    }

    public void setFavorite_count(int favorite_count) {
        this.favorite_count = favorite_count;
    }

    public int getGo_detail_count() {
        return go_detail_count;
    }

    public void setGo_detail_count(int go_detail_count) {
        this.go_detail_count = go_detail_count;
    }

    public int getUser_favorite() {
        return user_favorite;
    }

    public void setUser_favorite(int user_favorite) {
        this.user_favorite = user_favorite;
    }

    public int getShare_type() {
        return share_type;
    }

    public void setShare_type(int share_type) {
        this.share_type = share_type;
    }

    public double getMax_screen_width_percent() {
        return max_screen_width_percent;
    }

    public void setMax_screen_width_percent(double max_screen_width_percent) {
        this.max_screen_width_percent = max_screen_width_percent;
    }

    public int getIs_can_share() {
        return is_can_share;
    }

    public void setIs_can_share(int is_can_share) {
        this.is_can_share = is_can_share;
    }

    public int getCategory_type() {
        return category_type;
    }

    public void setCategory_type(int category_type) {
        this.category_type = category_type;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public int getLabel() {
        return label;
    }

    public void setLabel(int label) {
        this.label = label;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public String getId_str() {
        return id_str;
    }

    public void setId_str(String id_str) {
        this.id_str = id_str;
    }

    public int getMedia_type() {
        return media_type;
    }

    public void setMedia_type(int media_type) {
        this.media_type = media_type;
    }

    public int getShare_count() {
        return share_count;
    }

    public void setShare_count(int share_count) {
        this.share_count = share_count;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getHas_comments() {
        return has_comments;
    }

    public void setHas_comments(int has_comments) {
        this.has_comments = has_comments;
    }

    public GroupBean.LargeImageBean getLarge_image() {
        return large_image;
    }

    public void setLarge_image(GroupBean.LargeImageBean large_image) {
        this.large_image = large_image;
    }

    public int getUser_bury() {
        return user_bury;
    }

    public void setUser_bury(int user_bury) {
        this.user_bury = user_bury;
    }

    public String getStatus_desc() {
        return status_desc;
    }

    public void setStatus_desc(String status_desc) {
        this.status_desc = status_desc;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public int getIs_gif() {
        return is_gif;
    }

    public void setIs_gif(int is_gif) {
        this.is_gif = is_gif;
    }

    public int getUser_digg() {
        return user_digg;
    }

    public void setUser_digg(int user_digg) {
        this.user_digg = user_digg;
    }

    public int getOnline_time() {
        return online_time;
    }

    public void setOnline_time(int online_time) {
        this.online_time = online_time;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public boolean isCategory_visible() {
        return category_visible;
    }

    public void setCategory_visible(boolean category_visible) {
        this.category_visible = category_visible;
    }

    public int getBury_count() {
        return bury_count;
    }

    public void setBury_count(int bury_count) {
        this.bury_count = bury_count;
    }

    public boolean isIs_anonymous() {
        return is_anonymous;
    }

    public void setIs_anonymous(boolean is_anonymous) {
        this.is_anonymous = is_anonymous;
    }

    public int getRepin_count() {
        return repin_count;
    }

    public void setRepin_count(int repin_count) {
        this.repin_count = repin_count;
    }

    public double getMin_screen_width_percent() {
        return min_screen_width_percent;
    }

    public void setMin_screen_width_percent(double min_screen_width_percent) {
        this.min_screen_width_percent = min_screen_width_percent;
    }

    public int getDigg_count() {
        return digg_count;
    }

    public void setDigg_count(int digg_count) {
        this.digg_count = digg_count;
    }

    public GifvideoBean getGifvideo() {
        return gifvideo;
    }

    public void setGifvideo(GifvideoBean gifvideo) {
        this.gifvideo = gifvideo;
    }

    public int getHas_hot_comments() {
        return has_hot_comments;
    }

    public void setHas_hot_comments(int has_hot_comments) {
        this.has_hot_comments = has_hot_comments;
    }

    public int getImage_status() {
        return image_status;
    }

    public void setImage_status(int image_status) {
        this.image_status = image_status;
    }

    public int getUser_repin() {
        return user_repin;
    }

    public void setUser_repin(int user_repin) {
        this.user_repin = user_repin;
    }

    public GroupBean.ActivityBean getActivity() {
        return activity;
    }

    public void setActivity(GroupBean.ActivityBean activity) {
        this.activity = activity;
    }

    public long getGroup_id() {
        return group_id;
    }

    public void setGroup_id(long group_id) {
        this.group_id = group_id;
    }

    public GroupBean.MiddleImageBean getMiddle_image() {
        return middle_image;
    }

    public void setMiddle_image(GroupBean.MiddleImageBean middle_image) {
        this.middle_image = middle_image;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public static class LargeImageBean extends BaseBean{
        private int width;
        private int r_height;
        private int r_width;
        private String uri;
        private int height;
        private List<GroupBean.LargeImageBean.UrlListBean> url_list;

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getR_height() {
            return r_height;
        }

        public void setR_height(int r_height) {
            this.r_height = r_height;
        }

        public int getR_width() {
            return r_width;
        }

        public void setR_width(int r_width) {
            this.r_width = r_width;
        }

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public List<GroupBean.LargeImageBean.UrlListBean> getUrl_list() {
            return url_list;
        }

        public void setUrl_list(List<GroupBean.LargeImageBean.UrlListBean> url_list) {
            this.url_list = url_list;
        }

        public static class UrlListBean extends BaseBean{
            private String url;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }



    public static class ActivityBean extends BaseBean {
    }

    public static class MiddleImageBean extends BaseBean{
        private int width;
        private int r_height;
        private int r_width;
        private String uri;
        private int height;
        private List<GroupBean.LargeImageBean.UrlListBean> url_list;

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getR_height() {
            return r_height;
        }

        public void setR_height(int r_height) {
            this.r_height = r_height;
        }

        public int getR_width() {
            return r_width;
        }

        public void setR_width(int r_width) {
            this.r_width = r_width;
        }

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public List<GroupBean.LargeImageBean.UrlListBean> getUrl_list() {
            return url_list;
        }

        public void setUrl_list(List<GroupBean.LargeImageBean.UrlListBean> url_list) {
            this.url_list = url_list;
        }
    }
}