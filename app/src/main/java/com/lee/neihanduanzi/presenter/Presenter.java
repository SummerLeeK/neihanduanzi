package com.lee.neihanduanzi.presenter;

import com.lee.neihanduanzi.listener.TextFragmentView;
import com.lee.neihanduanzi.model.Model;

/**
 * Created by u on 2017/6/29.
 */

public class Presenter {
    private TextFragmentView fragmentView;
    private Model model;

    public Presenter(TextFragmentView fragmentView) {
        this.fragmentView = fragmentView;
        model=new Model();
    }

    public void request(String type){
        model.requestText(type,System.currentTimeMillis()/1000,fragmentView);
    }
}
