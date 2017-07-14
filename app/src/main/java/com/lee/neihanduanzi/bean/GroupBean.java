package com.lee.neihanduanzi.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by u on 2017/6/24.
 */

public class GroupBean extends BaseBean {


    @SerializedName("360p_video")
    private _$360pVideoBean _$360p_video;
    private String mp4_url;
    @SerializedName("720p_video")
    private _$720pVideoBean _$720p_video;
    private double duration;
    @SerializedName("480p_video")
    private _$480pVideoBean _$480p_video;
    private String keywords;
    private String m3u8_url;
    private LargeCoverBean large_cover;
    private String title;
    private int video_height;
    private String cover_image_uri;
    private String publish_time;
    private int play_count;
    private MediumCoverBean medium_cover;
    private int video_width;
    private String flash_url;
    private String uri;
    private int is_public_url;
    private OriginVideoBean origin_video;
    private String cover_image_url;
    private int is_video;

    public _$360pVideoBean get_$360p_video() {
        return _$360p_video;
    }

    public void set_$360p_video(_$360pVideoBean _$360p_video) {
        this._$360p_video = _$360p_video;
    }

    public String getMp4_url() {
        return mp4_url;
    }

    public void setMp4_url(String mp4_url) {
        this.mp4_url = mp4_url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public _$720pVideoBean get_$720p_video() {
        return _$720p_video;
    }

    public void set_$720p_video(_$720pVideoBean _$720p_video) {
        this._$720p_video = _$720p_video;
    }

    public int getDigg_count() {
        return digg_count;
    }

    public void setDigg_count(int digg_count) {
        this.digg_count = digg_count;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public _$480pVideoBean get_$480p_video() {
        return _$480p_video;
    }

    public void set_$480p_video(_$480pVideoBean _$480p_video) {
        this._$480p_video = _$480p_video;
    }

    public int getCreate_time() {
        return create_time;
    }

    public void setCreate_time(int create_time) {
        this.create_time = create_time;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
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

    public String getM3u8_url() {
        return m3u8_url;
    }

    public void setM3u8_url(String m3u8_url) {
        this.m3u8_url = m3u8_url;
    }

    public LargeCoverBean getLarge_cover() {
        return large_cover;
    }

    public void setLarge_cover(LargeCoverBean large_cover) {
        this.large_cover = large_cover;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public int getVideo_height() {
        return video_height;
    }

    public void setVideo_height(int video_height) {
        this.video_height = video_height;
    }

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public String getCover_image_uri() {
        return cover_image_uri;
    }

    public void setCover_image_uri(String cover_image_uri) {
        this.cover_image_uri = cover_image_uri;
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

    public String getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(String publish_time) {
        this.publish_time = publish_time;
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

    public int getPlay_count() {
        return play_count;
    }

    public void setPlay_count(int play_count) {
        this.play_count = play_count;
    }

    public int getUser_repin() {
        return user_repin;
    }

    public void setUser_repin(int user_repin) {
        this.user_repin = user_repin;
    }

    public MediumCoverBean getMedium_cover() {
        return medium_cover;
    }

    public void setMedium_cover(MediumCoverBean medium_cover) {
        this.medium_cover = medium_cover;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public int getUser_digg() {
        return user_digg;
    }

    public void setUser_digg(int user_digg) {
        this.user_digg = user_digg;
    }

    public int getVideo_width() {
        return video_width;
    }

    public void setVideo_width(int video_width) {
        this.video_width = video_width;
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

    public String getFlash_url() {
        return flash_url;
    }

    public void setFlash_url(String flash_url) {
        this.flash_url = flash_url;
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

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public int getIs_public_url() {
        return is_public_url;
    }

    public void setIs_public_url(int is_public_url) {
        this.is_public_url = is_public_url;
    }

    public int getHas_hot_comments() {
        return has_hot_comments;
    }

    public void setHas_hot_comments(int has_hot_comments) {
        this.has_hot_comments = has_hot_comments;
    }

    public OriginVideoBean getOrigin_video() {
        return origin_video;
    }

    public void setOrigin_video(OriginVideoBean origin_video) {
        this.origin_video = origin_video;
    }

    public String getCover_image_url() {
        return cover_image_url;
    }

    public void setCover_image_url(String cover_image_url) {
        this.cover_image_url = cover_image_url;
    }

    public ActivityBean getActivity() {
        return activity;
    }

    public void setActivity(ActivityBean activity) {
        this.activity = activity;
    }

    public long getGroup_id() {
        return group_id;
    }

    public void setGroup_id(long group_id) {
        this.group_id = group_id;
    }

    public int getIs_video() {
        return is_video;
    }

    public void setIs_video(int is_video) {
        this.is_video = is_video;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public class _$360pVideoBean extends BaseBean{
        private int width;
        private String uri;
        private int height;
        private List<UrlListBean> url_list;

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
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

        public List<UrlListBean> getUrl_list() {
            return url_list;
        }

        public void setUrl_list(List<UrlListBean> url_list) {
            this.url_list = url_list;
        }

    }

    public  class _$720pVideoBean extends BaseBean{
        private int width;
        private String uri;
        private int height;
        private List<UrlListBean> url_list;

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
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

        public List<UrlListBean> getUrl_list() {
            return url_list;
        }

        public void setUrl_list(List<UrlListBean> url_list) {
            this.url_list = url_list;
        }

    }

    public  class _$480pVideoBean extends BaseBean{
        private int width;
        private String uri;
        private int height;
        private List<UrlListBean> url_list;

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
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

        public List<UrlListBean> getUrl_list() {
            return url_list;
        }

        public void setUrl_list(List<UrlListBean> url_list) {
            this.url_list = url_list;
        }

    }

    public class LargeCoverBean extends BaseBean{
        private String uri;
        private List<UrlListBean> url_list;

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public List<UrlListBean> getUrl_list() {
            return url_list;
        }

        public void setUrl_list(List<UrlListBean> url_list) {
            this.url_list = url_list;
        }

    }

    public class MediumCoverBean extends BaseBean{
        private String uri;
        private List<UrlListBean> url_list;

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public List<UrlListBean> getUrl_list() {
            return url_list;
        }

        public void setUrl_list(List<UrlListBean> url_list) {
            this.url_list = url_list;
        }

    }

    public class OriginVideoBean extends BaseBean{

        private int width;
        private String uri;
        private int height;
        private List<UrlListBean> url_list;

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
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

        public List<UrlListBean> getUrl_list() {
            return url_list;
        }

        public void setUrl_list(List<UrlListBean> url_list) {
            this.url_list = url_list;
        }

    }

    public class ActivityBean extends BaseBean {
    }


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

    public double getMax_screen_width_percent() {
        return max_screen_width_percent;
    }

    public void setMax_screen_width_percent(double max_screen_width_percent) {
        this.max_screen_width_percent = max_screen_width_percent;
    }


    public GroupBean.LargeImageBean getLarge_image() {
        return large_image;
    }

    public void setLarge_image(GroupBean.LargeImageBean large_image) {
        this.large_image = large_image;
    }


    public double getMin_screen_width_percent() {
        return min_screen_width_percent;
    }

    public void setMin_screen_width_percent(double min_screen_width_percent) {
        this.min_screen_width_percent = min_screen_width_percent;
    }


    public GifvideoBean getGifvideo() {
        return gifvideo;
    }

    public void setGifvideo(GifvideoBean gifvideo) {
        this.gifvideo = gifvideo;
    }

    public int getImage_status() {
        return image_status;
    }

    public void setImage_status(int image_status) {
        this.image_status = image_status;
    }


    public GroupBean.MiddleImageBean getMiddle_image() {
        return middle_image;
    }

    public void setMiddle_image(GroupBean.MiddleImageBean middle_image) {
        this.middle_image = middle_image;
    }

    public class LargeImageBean extends BaseBean {
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

        public class UrlListBean extends BaseBean {
            private String url;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }

    public class MiddleImageBean extends BaseBean {
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