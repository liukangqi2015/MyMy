package com.liu.mymy.viewholder;

import android.graphics.drawable.Animatable;
import android.support.annotation.LayoutRes;
import android.view.ViewGroup;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.liu.mymy.R;
import com.liu.mymy.bean.GankMeiziBean;

/**
 * 妹子福利的ViewHolder
 * Created by liu on 2016/10/17.
 */
public class GankMeiziViewHolder extends BaseViewHolder<GankMeiziBean.ResultsBean> {
    private SimpleDraweeView simpleDraweeView;


    public GankMeiziViewHolder(ViewGroup parent, @LayoutRes int res) {
        super(parent, res);
        simpleDraweeView = $(R.id.item_home_img);
    }

    @Override
    public void setData(final GankMeiziBean.ResultsBean data) {
        if (data != null) {
            DraweeController draweeController = Fresco.newDraweeControllerBuilder().setControllerListener(new ControllerListener<ImageInfo>() {
                @Override
                public void onSubmit(String id, Object callerContext) {

                }

                @Override
                public void onFinalImageSet(String id, ImageInfo imageInfo, Animatable animatable) {

                    int width = simpleDraweeView.getMeasuredWidth();//宽度为屏幕宽度一半
                    int height = imageInfo.getHeight() * width / imageInfo.getWidth();//计算View的高度
                    ViewGroup.LayoutParams params = simpleDraweeView.getLayoutParams();
                    params.height = height;
                    simpleDraweeView.setLayoutParams(params);


                }

                @Override
                public void onIntermediateImageSet(String id, ImageInfo imageInfo) {

                }

                @Override
                public void onIntermediateImageFailed(String id, Throwable throwable) {

                }

                @Override
                public void onFailure(String id, Throwable throwable) {

                }

                @Override
                public void onRelease(String id) {

                }
            }).setUri(data.getUrl()).build();


            simpleDraweeView.setController(draweeController);
        }
    }
}
