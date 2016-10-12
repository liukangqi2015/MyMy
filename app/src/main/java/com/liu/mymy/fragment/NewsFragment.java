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
import com.liu.mymy.bean.NewsBean;
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
    private ArrayList<NewsBean> newsData=new ArrayList<>();

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
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e(TAG,"onViewCreated");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e(TAG,"onPause");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.frag_news;
    }

    @Override
    protected void init(View view, Bundle savedInstanceState) {
        newsErv.setLayoutManager(new LinearLayoutManager(getHoldingActivity()));
        newsAdapter=new NewsAdapter(getHoldingActivity());
        for (int i=0;i<20;i++){
            NewsBean newsBean=new NewsBean();
            newsBean.setTitle(i+"");
            newsData.add(newsBean);
        }
        setData();
        newsAdapter.addAll(newsData);
        newsErv.setAdapter(newsAdapter);

    }

    private void setData() {
        Retrofit retrofit=new Retrofit.Builder().baseUrl(API.ZHIHU_BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        ZhiHuApi zhihuapi=retrofit.create(ZhiHuApi.class);
        Call<ZhiHuBean> call=zhihuapi.getZhihuBean();
        call.enqueue(new Callback<ZhiHuBean>() {
            @Override
            public void onResponse(Call<ZhiHuBean> call, Response<ZhiHuBean> response) {
                Log.e(TAG,response.body().getDate());
            }

            @Override
            public void onFailure(Call<ZhiHuBean> call, Throwable t) {

            }
        });
    }


    /**
     *加载数据
     */
    @Override
    public void onLazyLoad() {

    }
}
