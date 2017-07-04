package com.lee.neihanduanzi.widget;

/**
 * Created by u on 2017/7/3.
 */

public class PlayManager {

    private static PlayManager manager;

    public enum STATE{
        IDLE,
        STARE,
        PREPARING,
        PREPARED,
        PLAYING,
        PAUSE,
        COMPLETED
    }

    public static PlayManager getInstance(){
        if (manager==null){
            synchronized (PlayManager.class){
                if (manager==null){
                    manager=new PlayManager();
                }
            }
        }
        return manager;
    }

    public PlayManager() {

    }
}
