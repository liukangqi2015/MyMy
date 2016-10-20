package com.liu.mymy.viewholder;

import android.support.annotation.LayoutRes;
import android.support.v4.view.ViewCompat;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.liu.mymy.R;
import com.liu.mymy.bean.GankMeiziInfo;
import com.liu.mymy.util.ImageLoader;

/**
 * 妹子福利的ViewHolder
 * Created by liu on 2016/10/17.
 */
public class GankMeiziViewHolder extends BaseViewHolder<GankMeiziInfo> {
    private ImageView imageView;
    private TextView textView;

    public GankMeiziViewHolder(ViewGroup parent, @LayoutRes int res) {
        super(parent, res);
        imageView = $(R.id.item_iv);
        textView = $(R.id.item_tv);
    }

    @Override
    public void setData(final GankMeiziInfo data) {
        if (data != null) {
            textView.setText(data.desc);
            ImageLoader.getSingleton().disPlayImage(getContext(),data.url,imageView);
            ViewCompat.setTransitionName(imageView, data.url);
        }
    }
}
