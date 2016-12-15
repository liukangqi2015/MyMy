package com.liu.mymy.viewholder;

import android.support.annotation.LayoutRes;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.liu.mymy.R;
import com.liu.mymy.bean.GankAndroidBean;
import com.liu.mymy.util.ChangeTimeFormat;
import com.liu.mymy.util.ImageLoader;

/**
 * 干货集中营Android列表的ViewHolder
 * Created by liu on 2016/10/14.
 */
public class GankAndroidViewHolder extends BaseViewHolder<GankAndroidBean.ResultsBean>{
    private TextView mTv_title,mTv_username,mTv_date;
    private ImageView mIv;

    public GankAndroidViewHolder(ViewGroup parent, @LayoutRes int res) {
        super(parent, res);
        mTv_title=$(R.id.gank_android_title_tv);
        mTv_username=$(R.id.gank_android_username_tv);
        mTv_date=$(R.id.gank_android_date_tv);
        mIv=$(R.id.gank_android_iv);
    }

    @Override
    public void setData(GankAndroidBean.ResultsBean data) {
        if (data!=null){
            mTv_title.setText(data.getDesc());
            mTv_date.setText(ChangeTimeFormat.changeToYearMonthDay(ChangeTimeFormat.changeStringToDate(data.getCreatedAt())));
            mTv_username.setText(data.getWho());
            //加载图片
            if (data.getImages()!=null&&data.getImages().size()>0){
                ImageLoader.disPlayImage(getContext(), data.getImages().get(0),mIv);
                mIv.setVisibility(View.VISIBLE);
            }else {
                mIv.setVisibility(View.GONE);
            }

        }

    }


}
