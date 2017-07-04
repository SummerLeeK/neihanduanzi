package com.lee.neihanduanzi.viewholder;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lee.neihanduanzi.R;
import com.lee.neihanduanzi.activity.TextDetailActivity;
import com.lee.neihanduanzi.adapter.CommentAdapter;
import com.lee.neihanduanzi.bean.DataBean;
import com.lee.neihanduanzi.bean.PicBean;
import com.lee.neihanduanzi.liao.GifImageType;
import com.lee.neihanduanzi.liao.GifView;
import com.lee.neihanduanzi.utils.DateUtils;
import com.lee.neihanduanzi.utils.NumberUtils;
import com.lee.neihanduanzi.widget.DetailHeaderView;
import com.lee.neihanduanzi.widget.MyListView;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import uk.co.senab.photoview.PhotoView;

/**
 * Created by u on 2017/6/29.
 */

public class GifViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


    @Bind(R.id.user_img)
    CircleImageView userImg;
    @Bind(R.id.user_name)
    TextView userName;
    @Bind(R.id.create_time)
    TextView createTime;
    @Bind(R.id.content)
    TextView content;
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
    @Bind(R.id.gif_contain)
    LinearLayout linearLayout;

    private DataBean dataBean;
    private CommentAdapter adapter;

    private GifView gifView;
    private boolean isPlay = false;

    public GifViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(this);
    }

    public void bindViewHolder(final DataBean dataBean, boolean isShow) {
        this.dataBean = dataBean;
        Glide.with(itemView.getContext()).load(dataBean.getGroup().getUser().getAvatar_url()).into(userImg);
        userName.setText(dataBean.getGroup().getUser().getName());
        createTime.setText(DateUtils.stampToDate(dataBean.getGroup().getCreate_time()));
        content.setText(dataBean.getGroup().getText());
        adapter = new CommentAdapter(dataBean.getComments(), itemView.getContext(), true);
        commentList.setAdapter(adapter);
        if (dataBean.getGroup().getText().equals("")){
            content.setVisibility(View.GONE);
        }
        WindowManager wm = (WindowManager) this.itemView.getContext().getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();

//        Log.i("info","gif_video"+dataBean.getGroup().getGifvideo().getOrigin_video().getUrl_list().get(0).getUrl());
        linearLayout.removeAllViews();
        gifView = new GifView(this.itemView.getContext());
        gifView.setGifImageType(GifImageType.COVER);
        gifView.pauseGifAnimation();
        gifView.setOnClickListener(this);
        gifView.setLayoutParams(new LinearLayout.LayoutParams(width, (int) ((width/dataBean.getGroup().getLarge_image().getR_width()*1.0)*dataBean.getGroup().getLarge_image().getR_height())));
        linearLayout.addView(gifView);
        Glide.with(itemView.getContext()).load(dataBean.getGroup().getLarge_image().getUrl_list().get(0).getUrl()).asGif().into(gifView);
        //是否显示神评list 在详情页不显示
        if (isShow) {
            commentList.setVisibility(View.VISIBLE);
        } else {
            commentList.setVisibility(View.GONE);
        }
        zanNum.setText(NumberUtils.numberToThousand(dataBean.getGroup().getDigg_count()));
        caiNum.setText(NumberUtils.numberToThousand(dataBean.getGroup().getBury_count()));
        commentNum.setText(NumberUtils.numberToThousand(dataBean.getGroup().getComment_count()));
        shareNum.setText(NumberUtils.numberToThousand(dataBean.getGroup().getShare_count()));
        lookNum.setText("浏览" + dataBean.getGroup().getGo_detail_count() + "次");

    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(itemView.getContext(), TextDetailActivity.class);
        intent.putExtra("data",dataBean.getGroup());
        intent.putExtra("type", DetailHeaderView.GIF_TYPE);
        itemView.getContext().startActivity(intent);
    }
}
