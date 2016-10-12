package com.liu.mymy.api;

import com.liu.mymy.bean.ZhiHuBean;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * 知乎日报API
 * Created by liu on 2016/10/10.
 */
public interface ZhiHuApi {
    @GET("api/4/news/latest")
    Call<ZhiHuBean> getZhihuBean();
}
