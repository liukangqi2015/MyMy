package com.liu.mymy.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.liu.mymy.bean.NewsBean;
import com.liu.mymy.viewholder.NewsViewHolder;

/**
 * 新闻列表的Adapter
 * Created by liu on 2016/10/9.
 */
public class NewsAdapter extends RecyclerArrayAdapter<NewsBean>{
    public NewsAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new NewsViewHolder(parent);
    }
}
