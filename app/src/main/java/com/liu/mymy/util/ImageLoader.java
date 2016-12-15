package com.liu.mymy.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

/**
 * 图片加载工具类
 * 图片加载框架为Glide
 * Created by liu on 2016/10/18.
 */
public class ImageLoader {
//    private volatile static ImageLoader imageLoader;

    private ImageLoader() {
    }

//    public static ImageLoader getSingleton() {
//        if (imageLoader == null) {
//            synchronized (ImageLoader.class) {
//                if (imageLoader == null) {
//                    imageLoader = new ImageLoader();
//                }
//            }
//        }
//        return imageLoader;
//    }

    //直接加载网络图片
    public static void disPlayImage(Context context, String url, ImageView imageView){
        Glide.with(context).load(url).centerCrop().crossFade().diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
    }

    //加载网络图片并设置大小
    public static void disPlayImage(Context context, String url, ImageView imageView,int width,int height){
        Glide.with(context).load(url).centerCrop().crossFade().diskCacheStrategy(DiskCacheStrategy.ALL).override(width,height).into(imageView);
    }

    //加载网络图片图片并设置监听器
    public static void disPlayImage(Context context, String url, RequestListener requestListener){
        Glide.with(context).load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .crossFade(0)
                .listener(requestListener)
                .into(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL);
    }
}
