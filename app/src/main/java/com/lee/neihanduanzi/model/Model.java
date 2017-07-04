package com.lee.neihanduanzi.model;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.lee.neihanduanzi.bean.PicBean;
import com.lee.neihanduanzi.contract.TextContract;
import com.lee.neihanduanzi.http.Constans;
import com.lee.neihanduanzi.http.HTTP;
import com.lee.neihanduanzi.listener.TextFragmentView;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by u on 2017/6/29.
 */

public class Model implements TextContract {
    @Override
    public void requestText(String type,long time, final TextFragmentView textFragmentView) {
        Gson gson=new GsonBuilder().setLenient().create();
        Retrofit.Builder builder=new Retrofit.Builder();
        builder.addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(HTTP.BASE_URL);
        Retrofit retrofit=builder.build();
        Constans constans=retrofit.create(Constans.class);
        constans.requestPic(type,1,HTTP.APP_NAME,time,HTTP.TOKEN).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Object object) {
                        textFragmentView.showLoadSuccessView(object);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.i("info","error"+e.getMessage());
                        textFragmentView.showLoadFailedView(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
