package com.lee.neihanduanzi.model;



import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.lee.neihanduanzi.bean.TextBean;
import com.lee.neihanduanzi.contract.TextContract;
import com.lee.neihanduanzi.listener.TextFragmentView;
import com.lee.neihanduanzi.http.Constans;
import com.lee.neihanduanzi.http.HTTP;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.lee.neihanduanzi.http.HTTP.BASE_URL;


/**
 * Created by u on 2017/6/22.
 */

public class TextModel implements TextContract {
    @Override
    public void requestText(String type,long time, final TextFragmentView textFragmentView) {

        Retrofit.Builder builder=new Retrofit.Builder();
        builder.addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL);
        Retrofit retrofit=builder.build();

        Constans constans=retrofit.create(Constans.class);
        constans.requestText(1, HTTP.APP_NAME,time,HTTP.TOKEN).subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<TextBean>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull TextBean textBean) {
                textFragmentView.showLoadSuccessView(textBean);

            }

            @Override
            public void onError(@NonNull Throwable e) {
                textFragmentView.showLoadFailedView(e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });

    }
}
