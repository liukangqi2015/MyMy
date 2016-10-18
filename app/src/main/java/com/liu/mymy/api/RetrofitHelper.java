package com.liu.mymy.api;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 管理接口类
 * Created by liu on 2016/10/10.
 */
public class RetrofitHelper {
    /**
     * 知乎日报base url
     */
    public static final String ZHIHU_BASE_URL = "http://news-at.zhihu.com/";
    /**
     * 干货集中营base url
     */
    public static final String GANK_BASE_URL = "http://gank.io/api/";

    /**
     * 得到知乎日报API
     * @return
     */
    public static ZhiHuApi getZhiHuAPI() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(ZHIHU_BASE_URL).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
        return  retrofit.create(ZhiHuApi.class);
    }

    /**
     * 得到干货集中营的API
     * @return
     */
    public static GankApi getGankAPI(){
        Retrofit retrofit=new Retrofit.Builder().baseUrl(RetrofitHelper.GANK_BASE_URL).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
        return retrofit.create(GankApi.class);
    }


}
