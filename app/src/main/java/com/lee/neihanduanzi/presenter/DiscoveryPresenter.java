package com.lee.neihanduanzi.presenter;

import com.lee.neihanduanzi.listener.TextFragmentView;
import com.lee.neihanduanzi.model.DiscoveryModel;

/**
 * Created by u on 2017/7/13.
 */

public class DiscoveryPresenter {
    private TextFragmentView textFragmentView;
    private DiscoveryModel model;

    public DiscoveryPresenter(TextFragmentView textFragmentView) {
        this.textFragmentView = textFragmentView;
        model=new DiscoveryModel();
    }

    public void request(String type){
        model.requestText(type,System.currentTimeMillis()/1000,textFragmentView);
    }
}
