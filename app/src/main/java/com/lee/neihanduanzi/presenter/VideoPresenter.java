package com.lee.neihanduanzi.presenter;

import com.lee.neihanduanzi.listener.TextFragmentView;
import com.lee.neihanduanzi.model.Model;
import com.lee.neihanduanzi.model.VideoModel;

/**
 * Created by u on 2017/7/3.
 */

public class VideoPresenter  {

    private TextFragmentView fragmentView;
    private VideoModel model;

    public VideoPresenter(TextFragmentView fragmentView) {
        this.fragmentView = fragmentView;
        model=new VideoModel();
    }

    public void request(String type){
        model.requestText(type,System.currentTimeMillis()/1000,fragmentView);
    }
}
