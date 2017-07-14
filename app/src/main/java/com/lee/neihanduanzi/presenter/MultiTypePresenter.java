package com.lee.neihanduanzi.presenter;

import com.lee.neihanduanzi.listener.TextFragmentView;
import com.lee.neihanduanzi.model.MultiTypeModel;

/**
 * Created by u on 2017/7/13.
 */

public class MultiTypePresenter  {

    private TextFragmentView fragmentView;
    private MultiTypeModel multiTypeModel;

    public MultiTypePresenter(TextFragmentView fragmentView) {
        this.fragmentView = fragmentView;
        multiTypeModel=new MultiTypeModel();
    }

    public void request(String type){
        multiTypeModel.requestText(type,System.currentTimeMillis()/1000,fragmentView);
    }
}
