package com.lee.neihanduanzi.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by u on 2017/6/22.
 */

public class MainPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragments;
    private String[] titles=new String[]{
            "段子","图片","视频","热吧"
    };

    public MainPagerAdapter(FragmentManager fm,ArrayList<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }


    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }



    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
