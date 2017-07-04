package com.lee.neihanduanzi.widget;

import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.IntDef;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.lee.neihanduanzi.R;
import com.lee.neihanduanzi.bean.VideoBean;
import com.lee.neihanduanzi.utils.NumberUtils;
import com.lee.neihanduanzi.widget.media.IjkVideoView;

import butterknife.Bind;
import butterknife.ButterKnife;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/**
 * Created by u on 2017/7/3.
 */

public class CustomVideoView extends RelativeLayout implements View.OnClickListener, IMediaPlayer.OnPreparedListener, IMediaPlayer.OnErrorListener, IMediaPlayer.OnCompletionListener, IMediaPlayer.OnInfoListener, View.OnFocusChangeListener {

    @Bind(R.id.videoview)
    IjkVideoView videoview;
    @Bind(R.id.placeholder)
    ImageView placeholder;
    @Bind(R.id.pause)
    ImageView pause;
    @Bind(R.id.left_tv)
    TextView leftTv;
    @Bind(R.id.full_screen)
    ImageView fullScreen;
    @Bind(R.id.right_tv)
    TextView rightTv;
    @Bind(R.id.progress)
    ProgressBar progress;
    @Bind(R.id.bottom)
    RelativeLayout bottom;
    @Bind(R.id.preprogress)
    ProgressBar preprogress;
    @Bind(R.id.bottomProgress)
    ProgressBar bottomProgress;
    @Bind(R.id.parentPanel)
    RelativeLayout parentPanel;
    private Context mContext;
    private LayoutInflater mInflater;

    private AudioManager audioManager;

    //更新进度条进度
    private static final int UPDATE_DURATION = 0;
    //显示或者隐藏底部活动条
    private static final int SHOW_OR_HIDE_BOTTOMBAR = 1;
    private int currentProgress;

    private boolean isPlaying = false;
    private VideoBean.DataBeanX.DataBean dataBean;

    private boolean isShow = true;
    private IMediaPlayer mediaPlayer;

    //视频是否暂停过
    private boolean isPause = false;
    private STATE current;
    private int currenrPosition=0;



    public enum STATE {
        IDLE,
        STARE,
        PREPARING,
        PREPARED,
        PLAYING,
        PAUSE,
        COMPLETED,
        ERROR
    }

    private Handler update = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            switch (msg.what) {
                case UPDATE_DURATION:
                    int currentDuration = getCurrentDuration();
                    currentProgress = (int) ((getCurrentDuration() * 1.0 / getDuration()) * 100);
                    if (isShow) {
                        progress.setProgress(currentProgress);
                        currentDuration = currentDuration / 1000;
                        leftTv.setText(NumberUtils.numberToPlayTime(currentDuration));
                    } else {
                        bottomProgress.setProgress(currentProgress);
                    }

                    update.sendEmptyMessageDelayed(UPDATE_DURATION, 100);
                    break;
                case SHOW_OR_HIDE_BOTTOMBAR:
                    if (isShow) {
                        isShow = false;
                        hidePlayView();
                        update.sendEmptyMessageDelayed(UPDATE_DURATION, 100);
                    } else {
                        isShow = true;
                        hidePlayView();
                    }
                    break;
            }
        }
    };

    public CustomVideoView(Context context) {
        this(context, null);
    }

    public CustomVideoView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        mInflater = LayoutInflater.from(context);
        initView();
    }

    /**
     * 初始化所有View
     */
    public void initView() {

        View root = mInflater.inflate(R.layout.custom_video_view_layout, this);
        ButterKnife.bind(this, root);
        IjkMediaPlayer.loadLibrariesOnce(null);
        IjkMediaPlayer.native_profileBegin("libijkplayer.so");
        pause.setOnClickListener(this);


    }

    public void setDataBean(VideoBean.DataBeanX.DataBean dataBean) {
        this.dataBean = dataBean;
        Glide.with(mContext).load(dataBean.getGroup().getLarge_cover().getUrl_list().get(0).getUrl()).into(placeholder);
        leftTv.setText(dataBean.getGroup().getGo_detail_count() + "次播放");
        rightTv.setText(NumberUtils.numberToPlayTime((int) dataBean.getGroup().getDuration()));
        progress.setProgress(0);
        progress.setVisibility(GONE);

        current = STATE.IDLE;



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.pause:
                if (current == STATE.PLAYING) {
                    //暂停
                    current = STATE.PAUSE;
                    currenrPosition=getCurrentDuration();
                    pause.setImageResource(R.mipmap.play);
                    videoview.pause();
                    update.removeMessages(UPDATE_DURATION);

                } else {
                    //播放
                    if (current == STATE.PAUSE) {
                        Log.i("info","restart"+currenrPosition);
                        pause.setImageResource(R.mipmap.pause);
                        videoview.seekTo(currenrPosition);
                        videoview.start();
                        progress.setVisibility(VISIBLE);
                        update.sendEmptyMessageDelayed(UPDATE_DURATION, 100);
                        current = STATE.PLAYING;
                    } else if (current == STATE.IDLE||current==STATE.COMPLETED) {
                        Log.i("info","pre");
                        placeholder.setVisibility(GONE);
                        videoview.setVisibility(VISIBLE);

                        pause.setVisibility(GONE);
                        preprogress.setVisibility(VISIBLE);

                        videoview.setRender(IjkVideoView.RENDER_TEXTURE_VIEW);
                        videoview.setVideoURI(Uri.parse(dataBean.getGroup().get_$720p_video().getUrl_list().get(0).getUrl()));
                        videoview.setOnErrorListener(this);
                        videoview.setOnCompletionListener(this);
                        videoview.setOnInfoListener(this);
                        parentPanel.setOnClickListener(this);
                        videoview.setOnPreparedListener(this);
                    }


                }
                break;
            case R.id.parentPanel:
                Log.i("info", "onClick");
                update.sendEmptyMessage(SHOW_OR_HIDE_BOTTOMBAR);
                break;
        }
    }

    /**
     * 将控件重置为初始化的状态
     */
    public void resetAllView() {
        if (current==STATE.PLAYING){
            videoview.stopPlayback();
            if (mediaPlayer!=null){
                mediaPlayer.release();
                mediaPlayer=null;
            }
        }

        update.removeMessages(UPDATE_DURATION);
        videoview.setVisibility(GONE);
        placeholder.setVisibility(VISIBLE);
        pause.setVisibility(VISIBLE);
        preprogress.setVisibility(GONE);
        leftTv.setText(dataBean.getGroup().getGo_detail_count() + "次播放");
        rightTv.setText(NumberUtils.numberToPlayTime((int) dataBean.getGroup().getDuration()));
        progress.setProgress(0);
        progress.setVisibility(GONE);
        bottom.setVisibility(VISIBLE);
        bottomProgress.setVisibility(GONE);
        pause.setImageResource(R.mipmap.play);

    }

    /**
     * 隐藏播放控件
     */
    public void hidePlayView() {
        bottom.setVisibility(isShow == true ? VISIBLE : GONE);
        bottomProgress.setVisibility(isShow == true ? GONE : VISIBLE);
        pause.setVisibility(isShow == true ? VISIBLE : GONE);
    }

    @Override
    public void onPrepared(IMediaPlayer iMediaPlayer) {

        Log.i("info","start");
        mediaPlayer = iMediaPlayer;
        current = STATE.PREPARED;
        preprogress.setVisibility(GONE);
        pause.setVisibility(VISIBLE);
        pause.setImageResource(R.mipmap.pause);
        videoview.start();
        progress.setVisibility(VISIBLE);
        update.sendEmptyMessageDelayed(UPDATE_DURATION, 100);
        current = STATE.PLAYING;
    }

    @Override
    public boolean onError(IMediaPlayer iMediaPlayer, int i, int i1) {
        current = STATE.ERROR;
        Toast.makeText(mContext, "播放器出问题了...", Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public void onCompletion(IMediaPlayer iMediaPlayer) {
        current = STATE.COMPLETED;
        mediaPlayer.release();
        resetAllView();
    }

    @Override
    public boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i1) {
        return true;
    }

    public int getCurrentDuration() {
        return videoview.getCurrentPosition();
    }

    public int getDuration() {
        return videoview.getDuration();
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (!hasFocus){
            Log.i("info","no focus!");
            resetAllView();
        }
    }


    /**
     * 当View不可见 清除播放状态
     * @param visibility
     */
    @Override
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);

        if (visibility==GONE){
            resetAllView();
        }
    }
}
