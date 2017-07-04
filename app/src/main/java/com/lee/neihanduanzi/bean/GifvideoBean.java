package com.lee.neihanduanzi.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by u on 2017/6/22.
 */

public class GifvideoBean extends BaseBean {


    @SerializedName("360p_video")
    private _$360pVideoBean _$360p_video;
    private OriginVideoBean origin_video;
    @SerializedName("720p_video")
    private _$720pVideoBean _$720p_video;
    private String mp4_url;
    private int video_height;
    @SerializedName("480p_video")
    private _$480pVideoBean _$480p_video;
    private String cover_image_uri;
    private double duration;
    private int video_width;

    public _$360pVideoBean get_$360p_video() {
        return _$360p_video;
    }

    public void set_$360p_video(_$360pVideoBean _$360p_video) {
        this._$360p_video = _$360p_video;
    }

    public OriginVideoBean getOrigin_video() {
        return origin_video;
    }

    public void setOrigin_video(OriginVideoBean origin_video) {
        this.origin_video = origin_video;
    }

    public _$720pVideoBean get_$720p_video() {
        return _$720p_video;
    }

    public void set_$720p_video(_$720pVideoBean _$720p_video) {
        this._$720p_video = _$720p_video;
    }

    public String getMp4_url() {
        return mp4_url;
    }

    public void setMp4_url(String mp4_url) {
        this.mp4_url = mp4_url;
    }

    public int getVideo_height() {
        return video_height;
    }

    public void setVideo_height(int video_height) {
        this.video_height = video_height;
    }

    public _$480pVideoBean get_$480p_video() {
        return _$480p_video;
    }

    public void set_$480p_video(_$480pVideoBean _$480p_video) {
        this._$480p_video = _$480p_video;
    }

    public String getCover_image_uri() {
        return cover_image_uri;
    }

    public void setCover_image_uri(String cover_image_uri) {
        this.cover_image_uri = cover_image_uri;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public int getVideo_width() {
        return video_width;
    }

    public void setVideo_width(int video_width) {
        this.video_width = video_width;
    }

    public static class _$360pVideoBean extends BaseBean{
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

    public static class OriginVideoBean extends BaseBean{
        private int width;
        private String uri;
        private int height;
        private List<_$360pVideoBean.UrlListBean> url_list;

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

        public List<_$360pVideoBean.UrlListBean> getUrl_list() {
            return url_list;
        }

        public void setUrl_list(List<_$360pVideoBean.UrlListBean> url_list) {
            this.url_list = url_list;
        }

    }

    public static class _$720pVideoBean extends BaseBean{
        private int width;
        private String uri;
        private int height;
        private List<_$360pVideoBean.UrlListBean> url_list;

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

        public List<_$360pVideoBean.UrlListBean> getUrl_list() {
            return url_list;
        }

        public void setUrl_list(List<_$360pVideoBean.UrlListBean> url_list) {
            this.url_list = url_list;
        }

    }

    public static class _$480pVideoBean extends BaseBean{
        private int width;
        private String uri;
        private int height;
        private List<_$360pVideoBean.UrlListBean> url_list;

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

        public List<_$360pVideoBean.UrlListBean> getUrl_list() {
            return url_list;
        }

        public void setUrl_list(List<_$360pVideoBean.UrlListBean> url_list) {
            this.url_list = url_list;
        }

    }
}
