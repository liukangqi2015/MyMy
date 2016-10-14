package com.liu.mymy.api;

import com.liu.mymy.bean.ZhiHuBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * 知乎日报API
 * Created by liu on 2016/10/10.
 */
public interface ZhiHuApi {
    @GET("api/4/news/latest")
    Observable<ZhiHuBean> getLastZhihuBean();
    @GET("/api/4/news/before/{date}")
    Observable<ZhiHuBean> getDailyZhihuBean(@Path("date") String date);
}
