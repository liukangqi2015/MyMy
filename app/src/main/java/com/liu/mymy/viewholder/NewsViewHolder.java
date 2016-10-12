package com.liu.mymy.viewholder;

import android.view.ViewGroup;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.liu.mymy.R;
import com.liu.mymy.bean.NewsBean;

/**
 * 新闻列表的ViewHolder
 * Created by liu on 2016/10/9.
 */
public class NewsViewHolder extends BaseViewHolder<NewsBean> {
    private TextView mTv_title;


    public NewsViewHolder(ViewGroup parent) {
        super(parent, R.layout.news_item);
        mTv_title=$(R.id.news_item_tv);
    }

    @Override
    public void setData(NewsBean data) {
        mTv_title.setText(data.getTitle());
    }
}
