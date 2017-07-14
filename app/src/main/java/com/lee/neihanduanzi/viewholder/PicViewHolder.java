package com.lee.neihanduanzi.viewholder;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.lee.neihanduanzi.R;
import com.lee.neihanduanzi.activity.TextDetailActivity;
import com.lee.neihanduanzi.adapter.CommentAdapter;
import com.lee.neihanduanzi.bean.DataBean;
import com.lee.neihanduanzi.utils.DateUtils;
import com.lee.neihanduanzi.utils.NumberUtils;
import com.lee.neihanduanzi.widget.DetailHeaderView;
import com.lee.neihanduanzi.widget.MyListView;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;


/**
 * Created by u on 2017/6/29.
 */

public class PicViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

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
    @Bind(R.id.contrainer)
    LinearLayout linearLayout;
    PhotoView image;
    private CommentAdapter adapter;
    private DataBean dataBean;


    private Dialog dialog;
    private PhotoView photoView;
//    private ImageView imageView;
//    private Button save;
//    private Button shareBtn;

    public PicViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        dialog=new Dialog(itemView.getContext(),R.style.FullScreen);
        dialog.setContentView(R.layout.dialog_view);
//        imageView= (ImageView) dialog.findViewById(R.id.back);
//        save= (Button) dialog.findViewById(R.id.save);
//        shareBtn= (Button) dialog.findViewById(R.id.share);
        photoView= (PhotoView) dialog.findViewById(R.id.photo);
        PhotoViewAttacher photoViewAttacher=new PhotoViewAttacher(photoView);
        photoViewAttacher.setOnViewTapListener(new PhotoViewAttacher.OnViewTapListener() {
            @Override
            public void onViewTap(View view, float x, float y) {
                dialog.dismiss();
            }
        });
        itemView.setOnClickListener(this);
//        imageView.setOnClickListener(this);
//        save.setOnClickListener(this);
//        shareBtn.setOnClickListener(this);
    }

    public void bindViewHolder(final DataBean dataBean, boolean isShow) {
        this.dataBean = dataBean;
        Glide.with(itemView.getContext()).load(dataBean.getGroup().getUser().getAvatar_url()).into(userImg);
        userName.setText(dataBean.getGroup().getUser().getName());
        createTime.setText(DateUtils.stampToDate(dataBean.getGroup().getCreate_time()));
        if (dataBean.getGroup().getText().equals("")){
            content.setVisibility(View.GONE);
        }
        content.setText(dataBean.getGroup().getText());
        adapter = new CommentAdapter(dataBean.getComments(), itemView.getContext(), true);
        commentList.setAdapter(adapter);
        WindowManager wm = (WindowManager) this.itemView.getContext().getSystemService(Context.WINDOW_SERVICE);

        final int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();
        final int precent = width / dataBean.getGroup().getMiddle_image().getR_width();
        final int imageHeight = precent * dataBean.getGroup().getMiddle_image().getR_height();

        linearLayout.removeAllViews();
        image=new PhotoView(this.itemView.getContext());
        image.setZoomable(false);
        image.setScaleType(ImageView.ScaleType.CENTER_CROP);
        image.setLayoutParams(new LinearLayout.LayoutParams(width,imageHeight));
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)  {
                Log.i("info",width+""+imageHeight);
                photoView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                Glide.with(itemView.getContext()).load(dataBean.getGroup().getLarge_image().getUrl_list().get(0).getUrl()).into(photoView);
                dialog.show();
            }
        });
        linearLayout.addView(image);

        Glide.with(itemView.getContext()).load(dataBean.getGroup().getLarge_image().getUrl_list().get(0).getUrl()).into(image);

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
        if (v.getId()==itemView.getId()){

            Intent intent=new Intent(itemView.getContext(), TextDetailActivity.class);
            intent.putExtra("data",dataBean.getGroup());
            intent.putExtra("type", DetailHeaderView.PIC_TYPE);
            itemView.getContext().startActivity(intent);

        }
//        if (v.getId()==imageView.getId()){
//            dialog.dismiss();
//        }
//        if (v.getId()==save.getId()){
//
//
//        }
//        if (v.getId()==shareBtn.getId()){
//
//        }

    }
}
