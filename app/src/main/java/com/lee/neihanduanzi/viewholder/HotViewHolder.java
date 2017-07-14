package com.lee.neihanduanzi.viewholder;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lee.neihanduanzi.R;
import com.lee.neihanduanzi.activity.DetailActivity;
import com.lee.neihanduanzi.bean.HotBean;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by u on 2017/7/5.
 */

public class HotViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @Bind(R.id.item_img)
    ImageView itemImg;
    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.info)
    TextView info;
    @Bind(R.id.update_count)
    TextView updateCount;

    private HotBean.DataBean.CategoriesBean.CategoryListBean listBean;


    public HotViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(this);
    }

    public void bindViewHolder(HotBean.DataBean.CategoriesBean.CategoryListBean listBean) {
        this.listBean = listBean;
        Glide.with(itemView.getContext()).load(listBean.getIcon_url()).crossFade(200).into(itemImg);
        title.setText(listBean.getName());
        info.setText(listBean.getIntro());
        String s = "总帖数" + listBean.getTotal_updates() + "   |   " + "订阅数" + listBean.getSubscribe_count();
        SpannableString spannableString = new SpannableString(s);
        ForegroundColorSpan span = new ForegroundColorSpan(Color.RED);
        ForegroundColorSpan span1 = new ForegroundColorSpan(Color.RED);
        Log.i("info", String.valueOf(listBean.getTotal_updates()).length() + "listBean.getTotal_updates()" + listBean.getToday_updates());

        spannableString.setSpan(span, 3, String.valueOf(listBean.getTotal_updates()).length() + 3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(span1, String.valueOf(listBean.getTotal_updates()).length() + 13, String.valueOf(listBean.getTotal_updates()).length() + 13
                + String.valueOf(listBean.getSubscribe_count()).length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        updateCount.setText(spannableString);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
        intent.putExtra("id", listBean.getId());
        intent.putExtra("title",listBean.getName());
        itemView.getContext().startActivity(intent);
    }
}
