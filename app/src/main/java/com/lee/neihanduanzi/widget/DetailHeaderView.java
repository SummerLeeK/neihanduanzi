package com.lee.neihanduanzi.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lee.neihanduanzi.R;
import com.lee.neihanduanzi.adapter.CommentAdapter;
import com.lee.neihanduanzi.bean.GroupBean;
import com.lee.neihanduanzi.bean.HotCommentBean;
import com.lee.neihanduanzi.liao.GifImageType;
import com.lee.neihanduanzi.liao.GifView;
import com.lee.neihanduanzi.utils.DateUtils;
import com.lee.neihanduanzi.utils.NumberUtils;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by u on 2017/6/24.
 */

public class DetailHeaderView extends RelativeLayout {

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
    @Bind(R.id.subtitle)
    TextView subtitle;
    @Bind(R.id.hot_comment)
    MyListView hotComment;
    @Bind(R.id.newComment)
    TextView newComment;
    @Bind(R.id.contrainer)
    LinearLayout contrainer;
    private CommentAdapter adapter;
    private LayoutInflater inflater;
    private GroupBean groupbean;
    private ArrayList<HotCommentBean> hots;
    private Context mContext;

    public static final int TEXT_TYPE = 1;
    public static final int PIC_TYPE = 2;
    public static final int GIF_TYPE = 3;
    public static final int VIDEO_TYPE=4;

    public void setData(GroupBean groupbean, ArrayList<HotCommentBean> hots, int newCommentSize, int type) {
        this.groupbean = groupbean;
        this.hots = hots;
        Glide.with(mContext).load(groupbean.getUser().getAvatar_url()).into(userImg);
        userName.setText(groupbean.getUser().getName());
        createTime.setText(DateUtils.stampToDate(groupbean.getCreate_time()));
        content.setText(groupbean.getText());

        //在详情页不显示神评list

        commentList.setVisibility(View.GONE);
        if (hots.size() == 0) {
            subtitle.setVisibility(GONE);
            hotComment.setVisibility(GONE);
        } else {
            subtitle.setText("热门评论(" + hots.size() + ")");
        }
        if (newCommentSize == 0) {
            newComment.setVisibility(GONE);
        } else {
            newComment.setText("新鲜评论(" + newCommentSize + ")");
        }
        zanNum.setText(NumberUtils.numberToThousand(groupbean.getDigg_count()));
        caiNum.setText(NumberUtils.numberToThousand(groupbean.getBury_count()));
        commentNum.setText(NumberUtils.numberToThousand(groupbean.getComment_count()));
        shareNum.setText(NumberUtils.numberToThousand(groupbean.getShare_count()));
        lookNum.setText("浏览" + groupbean.getGo_detail_count() + "次");

        adapter = new CommentAdapter(hots, mContext, true);
        hotComment.setAdapter(adapter);
        WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();


        switch (type) {
            case TEXT_TYPE:
                break;
            case PIC_TYPE:
                //移除之前所有的子view 避免重复添加
                contrainer.removeAllViews();
                ImageView imageView = new ImageView(mContext);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

                final int precent = width / groupbean.getLarge_image().getR_width();
                final int imageHeight = precent * groupbean.getLarge_image().getR_height();
                Glide.with(mContext).load(groupbean.getLarge_image().getUrl_list().get(0).getUrl()).into(imageView);
                imageView.setLayoutParams(new LinearLayout.LayoutParams(width, imageHeight));
                contrainer.addView(imageView);

                break;
            case GIF_TYPE:
                contrainer.removeAllViews();
                GifView gifView = new GifView(mContext);
                gifView = new GifView(mContext);
                gifView.setGifImageType(GifImageType.COVER);
                gifView.pauseGifAnimation();
                gifView.setLayoutParams(new LinearLayout.LayoutParams(width, (int) ((width / groupbean.getLarge_image().getR_width() * 1.0) * groupbean.getLarge_image().getR_height())));
                contrainer.addView(gifView);
                Glide.with(mContext).load(groupbean.getLarge_image().getUrl_list().get(0).getUrl()).asGif().into(gifView);

                break;
            case VIDEO_TYPE:
                contrainer.removeAllViews();
                CustomVideoView videoView=new CustomVideoView(mContext);
                int videoHeight= (int) (width*1.0/groupbean.getVideo_width()*groupbean.getVideo_height());
                videoView.setLayoutParams(new LinearLayout.LayoutParams(width,videoHeight));
                videoView.setDataBean(groupbean);
                contrainer.addView(videoView);
                break;
        }
        invalidate();
    }


    public DetailHeaderView(Context context) {
        this(context, null);
    }

    public DetailHeaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        inflater = LayoutInflater.from(context);
        initView();

    }

    private void initView() {

        View root = inflater.inflate(R.layout.detail_header_view, this);
        ButterKnife.bind(this, root);


    }


}
