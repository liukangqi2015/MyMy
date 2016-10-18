package com.liu.mymy.viewholder;

import android.support.annotation.LayoutRes;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.liu.mymy.R;
import com.liu.mymy.bean.GankMeiziBean;
import com.liu.mymy.util.ImageLoader;

/**
 * 妹子福利的ViewHolder
 * Created by liu on 2016/10/17.
 */
public class GankMeiziViewHolder extends BaseViewHolder<GankMeiziBean.ResultsBean> {
    private ImageView imageView;
    private TextView textView;

    public GankMeiziViewHolder(ViewGroup parent, @LayoutRes int res) {
        super(parent, res);
        imageView = $(R.id.item_iv);
        textView = $(R.id.item_tv);
    }

    @Override
    public void setData(final GankMeiziBean.ResultsBean data) {
        if (data != null) {
            textView.setText(data.getDesc());
            ImageLoader.getSingleton().disPlayImage(getContext(),data.getUrl(),imageView);
        }
    }
}
