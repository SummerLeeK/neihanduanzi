package com.lee.neihanduanzi;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.FrameLayout;

import com.lee.neihanduanzi.adapter.MainPagerAdapter;
import com.lee.neihanduanzi.fragment.BaseFragment;
import com.lee.neihanduanzi.fragment.HotFragment;
import com.lee.neihanduanzi.fragment.PicFragment;
import com.lee.neihanduanzi.fragment.TextFragment;
import com.lee.neihanduanzi.fragment.VideoFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    @Bind(R.id.tablayout)
    TabLayout tablayout;
    @Bind(R.id.pager)
    ViewPager pager;

    private TabLayout.Tab txt_tab;
    private TabLayout.Tab pic_tab;
    private TabLayout.Tab video_tab;
    private TabLayout.Tab hot_tab;

    private MainPagerAdapter pagerAdapter;
    private FragmentManager manager;

    private ArrayList<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        fragments = new ArrayList<>();
        manager=getSupportFragmentManager();
        txt_tab = tablayout.newTab().setText("段子");
        pic_tab = tablayout.newTab().setText("图片");
        video_tab = tablayout.newTab().setText("视频");
        hot_tab = tablayout.newTab().setText("热吧");
        tablayout.addTab(txt_tab);
        tablayout.addTab(pic_tab);
        tablayout.addTab(video_tab);
        tablayout.addTab(hot_tab);

//        tablayout.setTabTextColors(R.color.lightGray, R.color.white);

        tablayout.setBackgroundColor(getResources().getColor(R.color.tabBack));

        HotFragment hot = new HotFragment();
        PicFragment pic = new PicFragment();
        TextFragment text = new TextFragment();
        VideoFragment video = new VideoFragment();
        fragments.add(text);
        fragments.add(pic);
        fragments.add(video);
        fragments.add(hot);
        Log.i("info",fragments.size()+"");
        pagerAdapter = new MainPagerAdapter(manager,fragments);
        pager.setAdapter(pagerAdapter);
        pager.setOffscreenPageLimit(4);
        tablayout.setupWithViewPager(pager,true);
        tablayout.addOnTabSelectedListener(this);


    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
