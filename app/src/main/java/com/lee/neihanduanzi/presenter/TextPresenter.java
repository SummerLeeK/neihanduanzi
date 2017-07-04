package com.lee.neihanduanzi.presenter;

import com.lee.neihanduanzi.listener.TextFragmentView;
import com.lee.neihanduanzi.model.TextModel;

/**
 * Created by u on 2017/6/22.
 */

public class TextPresenter {

    private TextFragmentView textFragmentView;
    private TextModel textModel;

    public TextPresenter(TextFragmentView textFragmentView) {
        this.textFragmentView = textFragmentView;
        textModel=new TextModel();
    }

    public void requestText(){
        textModel.requestText(null,System.currentTimeMillis()/1000,textFragmentView);
    }

}
