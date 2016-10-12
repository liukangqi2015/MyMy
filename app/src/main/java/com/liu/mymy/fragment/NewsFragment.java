package com.liu.mymy.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.liu.mymy.R;
import com.liu.mymy.adapter.NewsAdapter;
import com.liu.mymy.api.API;
import com.liu.mymy.api.ZhiHuApi;
import com.liu.mymy.base.BaseLazyFragment;
import com.liu.mymy.bean.ZhiHuBean;

import java.util.ArrayList;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 新闻Fragment
 */
public class NewsFragment extends BaseLazyFragment {
    private static final String TAG=NewsFragment.class.getSimpleName();

    @BindView(R.id.news_erv)
    EasyRecyclerView newsErv;

    private NewsAdapter newsAdapter;
    private ArrayList<ZhiHuBean.StoriesBean> newsData=new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG,"onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(TAG,"onCreateView");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public int getLayout() {
        return  R.layout.frag_news;
    }

    @Override
    public void initViews(View view) {
        newsErv.setLayoutManager(new LinearLayoutManager(getActivity()));
        newsAdapter=new NewsAdapter(getActivity());
//        for (int i=0;i<20;i++){
//            ZhiHuBean.StoriesBean newsBean=new ZhiHuBean.StoriesBean();
//            newsBean.setTitle(i+"");
//            newsData.add(newsBean);
//        }
//        setData();
//        newsAdapter.addAll(newsData);
        newsErv.setAdapter(newsAdapter);
    }

    @Override
    public void loadData() {
        Log.e(TAG,"loadData");
        setData();
    }

    private void setData() {
        Retrofit retrofit=new Retrofit.Builder().baseUrl(API.ZHIHU_BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        ZhiHuApi zhihuapi=retrofit.create(ZhiHuApi.class);
        Call<ZhiHuBean> call=zhihuapi.getZhihuBean();
        call.enqueue(new Callback<ZhiHuBean>() {
            @Override
            public void onResponse(Call<ZhiHuBean> call, Response<ZhiHuBean> response) {
                if (response!=null){
                    newsAdapter.addAll(response.body().getStories());
                }
            }

            @Override
            public void onFailure(Call<ZhiHuBean> call, Throwable t) {

            }
        });
    }



}
