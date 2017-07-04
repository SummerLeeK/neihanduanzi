package com.lee.neihanduanzi.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.lee.neihanduanzi.R;
import com.lee.neihanduanzi.bean.HotCommentBean;
import com.lee.neihanduanzi.utils.NumberUtils;

import java.util.List;

/**
 * Created by u on 2017/6/23.
 */

public class CommentAdapter extends BaseAdapter {
    private List<HotCommentBean> commentBeen;
    private LayoutInflater inflater;
    private Context context;
    private boolean isTop;

    public CommentAdapter(List<HotCommentBean> commentBeen, Context context,boolean isTop) {
        this.commentBeen = commentBeen;
        inflater=LayoutInflater.from(context);
        this.context=context;
        this.isTop=isTop;
    }

    @Override
    public int getCount() {
        return commentBeen.size();
    }

    @Override
    public Object getItem(int position) {
        return commentBeen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView==null){
            convertView=inflater.inflate(R.layout.hot_comment_item_view,null);
            holder=new ViewHolder();
            holder.userImg= (ImageView) convertView.findViewById(R.id.user_img);
            holder.userName= (TextView) convertView.findViewById(R.id.user_name);
            holder.content= (TextView) convertView.findViewById(R.id.content);
            holder.zanNum= (TextView) convertView.findViewById(R.id.zan_num);
            holder.linearLayout= (LinearLayout) convertView.findViewById(R.id.zan);
            holder.hot_text= (TextView) convertView.findViewById(R.id.hot_text);
            convertView.setTag(holder);
        }


        holder= (ViewHolder) convertView.getTag();
        if (isTop){
            holder.hot_text.setVisibility(View.VISIBLE);
        }else {
            holder.hot_text.setVisibility(View.GONE);
        }
        Glide.with(context).load(commentBeen.get(position).getAvatar_url()).into(holder.userImg);

        holder.userName.setText(commentBeen.get(position).getUser_name());
        holder.content.setText(commentBeen.get(position).getText());
        holder.zanNum.setText(NumberUtils.numberToThousand(commentBeen.get(position).getDigg_count()));
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"暂不支持点赞功能哦",Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }

    static class ViewHolder{
        ImageView userImg;
        TextView userName;
        LinearLayout linearLayout;
        TextView zanNum;
        TextView content;
        TextView hot_text;
    }
}
