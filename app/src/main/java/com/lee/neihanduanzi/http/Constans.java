package com.lee.neihanduanzi.http;

import com.lee.neihanduanzi.bean.CommentBean;
import com.lee.neihanduanzi.bean.PicBean;
import com.lee.neihanduanzi.bean.TextBean;
import com.lee.neihanduanzi.bean.VideoBean;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by u on 2017/6/22.
 */

public interface Constans {
    /**
     * 图片接口 返回json数据 根据时间戳返回数据
     *
     * @return http://m.neihanshequ.com
     * /pic/
     * ?is_json=1&app_name=neihanshequ_web&max_time=1498092019&csrfmiddlewaretoken=838d4761968fa18a29b5888a73b39f54
     */
    @Headers({
            "Cookie:coouuid=\"w:bf79590c89f3468fb5cb56d433189f5d\"; __utma=101886750.78796171.1498035494.1498035494.1498035494.1; __utmz=101886750.1498035494.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); skip_guidence=1; Hm_lvt_773f1a5aa45c642cf87eef671e4d3f6a=1498034797,1498101316; tt_webid=60190215957; _ga=GA1.3.78796171.1498035494; _gid=GA1.3.711837779.1498037172; csrftoken=838d4761968fa18a29b5888a73b39f54",
            "User-Agent:Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36",
            "Accept:text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8",
            "Host:m.neihanshequ.com"
    })
    @GET("/")
    Observable<TextBean> requestText(@Query("is_json") int is_json, @Query("app_name") String app_name, @Query("min_time") long max_time, @Query("csrfmiddlewaretoken") String token);

    /**
     * http://m.neihanshequ.com/api/get_essay_comments/
     * ?app_name=neihanshequ_web&
     * group_id=62436096876
     * &offset=0
     * &csrfmiddlewaretoken=838d4761968fa18a29b5888a73b39f54
     *
     * @param app_name
     * @param group_id
     * @param offset
     * @param csrfmiddlewaretoken
     * @return
     */
    @GET("/{api}/{get_essay_comments}")
    Observable<CommentBean> requestTextDetail(@Path("api") String api,@Path("get_essay_comments") String get_essay_comments,@Query("app_name") String app_name, @Query("group_id") long group_id, @Query("offset") int offset, @Query("csrfmiddlewaretoken") String csrfmiddlewaretoken);

    @Headers({
            "Cookie:coouuid=\"w:bf79590c89f3468fb5cb56d433189f5d\"; __utma=101886750.78796171.1498035494.1498035494.1498035494.1; __utmz=101886750.1498035494.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); skip_guidence=1; Hm_lvt_773f1a5aa45c642cf87eef671e4d3f6a=1498034797,1498101316; tt_webid=60190215957; _ga=GA1.3.78796171.1498035494; _gid=GA1.3.711837779.1498037172; csrftoken=838d4761968fa18a29b5888a73b39f54",
            "User-Agent:Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36",
            "Accept:text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8",
            "Host:m.neihanshequ.com"
    })
    @GET("/{api}/")
    Observable<PicBean> requestPic(@Path("api") String api,@Query("is_json") int is_json, @Query("app_name") String app_name, @Query("min_time") long max_time, @Query("csrfmiddlewaretoken") String token);
    @Headers({
            "Cookie:coouuid=\"w:bf79590c89f3468fb5cb56d433189f5d\"; __utma=101886750.78796171.1498035494.1498035494.1498035494.1; __utmz=101886750.1498035494.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); skip_guidence=1; Hm_lvt_773f1a5aa45c642cf87eef671e4d3f6a=1498034797,1498101316; tt_webid=60190215957; _ga=GA1.3.78796171.1498035494; _gid=GA1.3.711837779.1498037172; csrftoken=838d4761968fa18a29b5888a73b39f54",
            "User-Agent:Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36",
            "Accept:text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8",
            "Host:m.neihanshequ.com"
    })
    @GET("/{api}/")
    Observable<VideoBean> requestVideo(@Path("api") String api,@Query("is_json") int is_json, @Query("app_name") String app_name, @Query("min_time") long max_time, @Query("csrfmiddlewaretoken") String token);

}
