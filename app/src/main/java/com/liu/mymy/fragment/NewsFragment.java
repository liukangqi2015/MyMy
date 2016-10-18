package com.liu.mymy.fragment;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.liu.mymy.R;
import com.liu.mymy.adapter.NewsAdapter;
import com.liu.mymy.api.RetrofitHelper;
import com.liu.mymy.base.BaseLazyFragment;
import com.liu.mymy.bean.ZhiHuBean;

import butterknife.BindView;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 新闻Fragment
 */
public class NewsFragment extends BaseLazyFragment implements SwipeRefreshLayout.OnRefreshListener, RecyclerArrayAdapter.OnLoadMoreListener {
//    private static final String TAG = NewsFragment.class.getSimpleName();

    @BindView(R.id.news_erv)
    EasyRecyclerView newsErv;

    private NewsAdapter newsAdapter;
    //    private ArrayList<ZhiHuBean.StoriesBean> newsData = new ArrayList<>();
    //当前日期
    private String currentDate;
    private Handler handler = new Handler();

    @Override
    public int getLayout() {
        return R.layout.frag_news;
    }

    @Override
    public void initViews(View view) {
        newsErv.setLayoutManager(new LinearLayoutManager(getActivity()));
        newsErv.getSwipeToRefresh().setColorSchemeResources(R.color.colorPrimary);
        newsAdapter = new NewsAdapter(getActivity());
//        newsErv.setAdapter(newsAdapter);
        //调用一个配有progress的设置Adapter的方法
        newsErv.setAdapterWithProgress(newsAdapter);
        newsErv.setRefreshListener(this);
        newsAdapter.setMore(R.layout.view_more, this);
        newsAdapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getActivity(),position+"",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void loadData() {
        getLastZhihuData();
    }

    private void getLastZhihuData() {
//        Retrofit retrofit = new Retrofit.Builder().baseUrl(RetrofitHelper.ZHIHU_BASE_URL).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
//        final ZhiHuApi zhihuapi = retrofit.create(ZhiHuApi.class);
        //简单的Retrofit请求
//        Call<ZhiHuBean> call=zhihuapi.getZhihuBean();
//        call.enqueue(new Callback<ZhiHuBean>() {
//            @Override
//            public void onResponse(Call<ZhiHuBean> call, Response<ZhiHuBean> response) {
//                if (response!=null){
//                    newsAdapter.addAll(response.body().getStories());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ZhiHuBean> call, Throwable t) {
//
//            }
//        });
        //Retrofit与RxJava结合
        RetrofitHelper.getZhiHuAPI().getLastZhihuBean().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<ZhiHuBean>() {
            @Override
            public void onCompleted() {
//                Log.e(TAG,"onCompleted");
            }

            @Override
            public void onError(Throwable e) {
//                Log.e(TAG,"onError");
            }

            @Override
            public void onNext(ZhiHuBean zhiHuBean) {
//                Log.e(TAG,"onNext");
                if (zhiHuBean != null) {
                    currentDate = zhiHuBean.getDate();
                    if (zhiHuBean.getStories() != null) {
                        newsAdapter.addAll(zhiHuBean.getStories());
                    }
                }
            }
        });
    }


    @Override
    public void onRefresh() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                newsAdapter.clear();
                getLastZhihuData();
            }
        }, 2000);
    }

    @Override
    public void onLoadMore() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                getDailyZhihuData();
            }
        }, 2000);
    }

    private void getDailyZhihuData() {
//        Retrofit retrofit = new Retrofit.Builder().baseUrl(RetrofitHelper.ZHIHU_BASE_URL).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
//        final ZhiHuApi zhihuapi = retrofit.create(ZhiHuApi.class);
        RetrofitHelper.getZhiHuAPI().getDailyZhihuBean(currentDate).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<ZhiHuBean>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(ZhiHuBean zhiHuBean) {
                if (zhiHuBean != null) {
                    currentDate = zhiHuBean.getDate();
                    if (zhiHuBean.getStories() != null) {
                        newsAdapter.addAll(zhiHuBean.getStories());
                    }
                }
            }
        });
    }
}
