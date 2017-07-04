package com.lee.neihanduanzi.model;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.lee.neihanduanzi.bean.CommentBean;
import com.lee.neihanduanzi.contract.TextDetailContract;
import com.lee.neihanduanzi.http.Constans;
import com.lee.neihanduanzi.http.HTTP;
import com.lee.neihanduanzi.listener.TextDetailLoadListener;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.lee.neihanduanzi.http.HTTP.Comment_Base_Url;

/**
 * Created by u on 2017/6/24.
 */

public class TextDetailModel implements TextDetailContract{
    @Override
    public void requestDetail(long id, int offset, final TextDetailLoadListener listener) {
        Retrofit.Builder builder=new Retrofit.Builder();
        builder.addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(Comment_Base_Url);
        Retrofit retrofit=builder.build();

        Constans constans=retrofit.create(Constans.class);
        constans.requestTextDetail(HTTP.API,HTTP.get_essay_comments,HTTP.APP_NAME,id,offset,HTTP.TOKEN).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<CommentBean>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull CommentBean commentBean) {
                listener.loadSuccess(commentBean);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                listener.loadFailed(e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
