package com.liu.mymy.viewholder;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.liu.mymy.R;
import com.liu.mymy.bean.ZhiHuBean;
import com.liu.mymy.util.ImageLoader;

/**
 * 新闻列表的ViewHolder
 * Created by liu on 2016/10/9.
 */
public class NewsViewHolder extends BaseViewHolder<ZhiHuBean.StoriesBean> {
    private TextView mTv_title;
    private ImageView mIv_thumbnail;


    public NewsViewHolder(ViewGroup parent) {
        super(parent, R.layout.news_item);
        mTv_title = $(R.id.zhihu_title_tv);
        mIv_thumbnail = $(R.id.zhihu_thumbnail_iv);
    }

    @Override
    public void setData(ZhiHuBean.StoriesBean data) {
        if (data != null) {
            mTv_title.setText(data.getTitle());
            ImageLoader.getSingleton().disPlayImage(getContext(), data.getImages().get(0), mIv_thumbnail);
        }

    }
}
