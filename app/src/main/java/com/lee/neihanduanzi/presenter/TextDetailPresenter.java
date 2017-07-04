package com.lee.neihanduanzi.presenter;

import com.lee.neihanduanzi.listener.TextDetailLoadListener;
import com.lee.neihanduanzi.model.TextDetailModel;

/**
 * Created by u on 2017/6/24.
 */

public class TextDetailPresenter {
    private TextDetailLoadListener listener;
    private TextDetailModel textDetailModel;

    public TextDetailPresenter(TextDetailLoadListener listener) {
        this.listener = listener;
        textDetailModel=new TextDetailModel();
    }

    public void requestTextDetail(long id,int offset){
        textDetailModel.requestDetail(id,offset,listener);
    }
}
