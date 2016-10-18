package com.liu.mymy.api;

import com.liu.mymy.bean.GankAndroidBean;
import com.liu.mymy.bean.GankMeiziBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * 干货集中营API
 * Created by liu on 2016/10/14.
 */
public interface GankApi {
    @GET("data/Android/{count}/{page}")
    Observable<GankAndroidBean> getGankAndroid(@Path("count") int count, @Path("page") int page);
    @GET("data/福利/{count}/{page}")
    Observable<GankMeiziBean> getGankMeizi(@Path("count") int count, @Path("page") int page);
}
