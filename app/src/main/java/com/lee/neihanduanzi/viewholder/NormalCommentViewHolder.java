package com.lee.neihanduanzi.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lee.neihanduanzi.R;
import com.lee.neihanduanzi.adapter.CommentAdapter;
import com.lee.neihanduanzi.bean.CommentBean;
import com.lee.neihanduanzi.bean.HotCommentBean;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by u on 2017/6/24.
 */

public class NormalCommentViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.hot_text)
    TextView hotText;
    @Bind(R.id.user_img)
    CircleImageView userImg;
    @Bind(R.id.user_name)
    TextView userName;
    @Bind(R.id.zan_num)
    TextView zanNum;
    @Bind(R.id.zan)
    LinearLayout zan;
    @Bind(R.id.content)
    TextView content;


    public NormalCommentViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindViewholder(HotCommentBean dataBeans) {

        hotText.setVisibility(View.GONE);
        Glide.with(itemView.getContext()).load(dataBeans.getAvatar_url()).into(userImg);
        userName.setText(dataBeans.getUser_name());
        zanNum.setText(dataBeans.getDigg_count()+"");
        content.setText(dataBeans.getText());


    }
}
