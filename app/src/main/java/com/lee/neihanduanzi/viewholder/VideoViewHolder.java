package com.lee.neihanduanzi.viewholder;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lee.neihanduanzi.R;
import com.lee.neihanduanzi.activity.TextDetailActivity;
import com.lee.neihanduanzi.adapter.CommentAdapter;
import com.lee.neihanduanzi.bean.DataBean;
import com.lee.neihanduanzi.utils.DateUtils;
import com.lee.neihanduanzi.utils.NumberUtils;
import com.lee.neihanduanzi.widget.CustomVideoView;
import com.lee.neihanduanzi.widget.DetailHeaderView;
import com.lee.neihanduanzi.widget.MyListView;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by u on 2017/6/30.
 */

public class VideoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @Bind(R.id.user_img)
    CircleImageView userImg;
    @Bind(R.id.user_name)
    TextView userName;
    @Bind(R.id.create_time)
    TextView createTime;
    @Bind(R.id.content)
    TextView content;
    @Bind(R.id.contrainer)
    LinearLayout contrainer;
    @Bind(R.id.comment_list)
    MyListView commentList;
    @Bind(R.id.look_num)
    TextView lookNum;
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
    private CommentAdapter adapter;
    private DataBean dataBean;

    private CustomVideoView videoView;



    public VideoViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        itemView.setOnClickListener(this);
    }

    public void bindViewHolder(DataBean dataBean,boolean isShow,int position){
        this.dataBean=dataBean;
        contrainer.removeAllViews();
        Glide.with(itemView.getContext()).load(dataBean.getGroup().getUser().getAvatar_url()).into(userImg);
        userName.setText(dataBean.getGroup().getUser().getName());
        createTime.setText(DateUtils.stampToDate(dataBean.getGroup().getCreate_time()));
        content.setText(dataBean.getGroup().getText());
        adapter = new CommentAdapter(dataBean.getComments(), itemView.getContext(),true);
        commentList.setAdapter(adapter);
        videoView=new CustomVideoView(itemView.getContext());
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
        lookNum.setText("浏览"+dataBean.getGroup().getGo_detail_count()+"次");

        WindowManager wm = (WindowManager) this.itemView.getContext().getSystemService(Context.WINDOW_SERVICE);
        final int width = wm.getDefaultDisplay().getWidth();
        int videoHeight= (int) (width*1.0/dataBean.getGroup().getVideo_width()*dataBean.getGroup().getVideo_height());
        videoView.setLayoutParams(new LinearLayout.LayoutParams(width,videoHeight));
        videoView.setDataBean(dataBean.getGroup());
        contrainer.addView(videoView);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(itemView.getContext(), TextDetailActivity.class);
        intent.putExtra("type", DetailHeaderView.VIDEO_TYPE);
        intent.putExtra("data",dataBean.getGroup());
        itemView.getContext().startActivity(intent);
    }
}
