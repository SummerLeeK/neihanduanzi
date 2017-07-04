package com.lee.neihanduanzi.viewholder;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.lee.neihanduanzi.R;
import com.lee.neihanduanzi.activity.TextDetailActivity;
import com.lee.neihanduanzi.adapter.CommentAdapter;
import com.lee.neihanduanzi.bean.DataBean;
import com.lee.neihanduanzi.bean.TextBean;
import com.lee.neihanduanzi.utils.DateUtils;
import com.lee.neihanduanzi.utils.NumberUtils;
import com.lee.neihanduanzi.widget.DetailHeaderView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by u on 2017/6/23.
 */

public class TextViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    @Bind(R.id.user_img)
    ImageView userImg;
    @Bind(R.id.user_name)
    TextView userName;
    @Bind(R.id.create_time)
    TextView createTime;
    @Bind(R.id.content)
    TextView content;
    @Bind(R.id.comment_list)
    ListView commentList;
    @Bind(R.id.zan_num)
    TextView zanNum;
    @Bind(R.id.zan)
    LinearLayout zan;
    @Bind(R.id.cai_num)
    TextView caiNum;
    @Bind(R.id.cai)
    LinearLayout cai;
    @Bind(R.id.comment_num)
    TextView commentNum;
    @Bind(R.id.comment)
    LinearLayout comment;
    @Bind(R.id.share_num)
    TextView shareNum;
    @Bind(R.id.share)
    LinearLayout share;
    @Bind(R.id.look_num)
    TextView look_num;

    private CommentAdapter adapter;
    private DataBean dataBean;

    public TextViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(this);
    }

    public void bindViewholder(DataBean dataBean, boolean isShow) {
        this.dataBean=dataBean;
        Glide.with(itemView.getContext()).load(dataBean.getGroup().getUser().getAvatar_url()).into(userImg);
        userName.setText(dataBean.getGroup().getUser().getName());
        createTime.setText(DateUtils.stampToDate(dataBean.getGroup().getCreate_time()));
        content.setText(dataBean.getGroup().getText());
        adapter = new CommentAdapter(dataBean.getComments(), itemView.getContext(),true);
        commentList.setAdapter(adapter);

        //是否显示神评list 在详情页不显示
        if (isShow){
            commentList.setVisibility(View.VISIBLE);
        }else {
            commentList.setVisibility(View.GONE);
        }
        zanNum.setText(NumberUtils.numberToThousand(dataBean.getGroup().getDigg_count()));
        caiNum.setText(NumberUtils.numberToThousand(dataBean.getGroup().getBury_count()));
        commentNum.setText(NumberUtils.numberToThousand(dataBean.getGroup().getComment_count()));
        shareNum.setText(NumberUtils.numberToThousand(dataBean.getGroup().getShare_count()));
        look_num.setText("浏览"+dataBean.getGroup().getGo_detail_count()+"次");

    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(itemView.getContext(), TextDetailActivity.class);
        intent.putExtra("data",dataBean.getGroup());
        intent.putExtra("type", DetailHeaderView.TEXT_TYPE);
        itemView.getContext().startActivity(intent);
    }
}
