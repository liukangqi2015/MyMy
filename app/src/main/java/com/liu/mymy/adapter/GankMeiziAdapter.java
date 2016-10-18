package com.liu.mymy.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.liu.mymy.R;
import com.liu.mymy.bean.GankMeiziBean;
import com.liu.mymy.viewholder.GankMeiziViewHolder;

/**
 * 妹子福利列表Adapter
 * Created by liu on 2016/10/17.
 */
public class GankMeiziAdapter extends RecyclerArrayAdapter<GankMeiziBean.ResultsBean>{
    public GankMeiziAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new GankMeiziViewHolder(parent, R.layout.item_meizi);
    }
}
