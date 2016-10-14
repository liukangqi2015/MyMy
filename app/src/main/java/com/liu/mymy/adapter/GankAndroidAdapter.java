package com.liu.mymy.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.liu.mymy.R;
import com.liu.mymy.bean.GankAndroidBean;
import com.liu.mymy.viewholder.GankAndroidViewHolder;

/**
 * 干货集中营Android列表的Adapter
 * Created by liu on 2016/10/14.
 */
public class GankAndroidAdapter extends RecyclerArrayAdapter<GankAndroidBean.ResultsBean>{
    public GankAndroidAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new GankAndroidViewHolder(parent, R.layout.gank_android_item);
    }
}
