package com.lee.neihanduanzi.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.lee.neihanduanzi.bean.DiscoveryBean;
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
 * Created by u on 2017/7/13.
 */

public class MultiTypeModel implements TextContract {
    @Override
    public void requestText(String type, long time, final TextFragmentView textFragmentView) {
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(HTTP.BASE_URL);
        Retrofit retrofit = builder.build();
        Constans constans = retrofit.create(Constans.class);
        constans.requestSomeItem("category", Integer.parseInt(type), 1, HTTP.APP_NAME, time, HTTP.TOKEN).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DiscoveryBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull DiscoveryBean discoveryBean) {
                        textFragmentView.showLoadSuccessView(discoveryBean);
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
