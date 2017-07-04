package com.lee.neihanduanzi.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lee.neihanduanzi.R;
import com.lee.neihanduanzi.bean.GroupBean;
import com.lee.neihanduanzi.bean.TextBean;
import com.lee.neihanduanzi.utils.DateUtils;
import com.lee.neihanduanzi.utils.NumberUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by u on 2017/6/24.
 */

public class HeadViewHolder extends RecyclerView.ViewHolder {
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

    private GroupBean groupBean;

    public HeadViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
    public void bindViewholder(GroupBean groupBean, boolean isShow) {
        this.groupBean=groupBean;
        Glide.with(itemView.getContext()).load(groupBean.getUser().getAvatar_url()).into(userImg);
        userName.setText(groupBean.getUser().getName());
        createTime.setText(DateUtils.stampToDate(groupBean.getCreate_time()));
        content.setText(groupBean.getText());

        //是否显示神评list 在详情页不显示
        if (isShow){
            commentList.setVisibility(View.VISIBLE);
        }else {
            commentList.setVisibility(View.GONE);
        }
        zanNum.setText(NumberUtils.numberToThousand(groupBean.getDigg_count()));
        caiNum.setText(NumberUtils.numberToThousand(groupBean.getBury_count()));
        commentNum.setText(NumberUtils.numberToThousand(groupBean.getComment_count()));
        shareNum.setText(NumberUtils.numberToThousand(groupBean.getShare_count()));
        look_num.setText("浏览"+groupBean.getGo_detail_count()+"次");

    }
}
