package com.liu.mymy.fragment;

import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.DividerDecoration;
import com.liu.mymy.R;
import com.liu.mymy.adapter.GankAndroidAdapter;
import com.liu.mymy.api.RetrofitHelper;
import com.liu.mymy.base.BaseLazyFragment;
import com.liu.mymy.bean.GankAndroidBean;
import com.liu.mymy.util.WindowUtil;

import butterknife.BindView;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Android干货Fragment
 * Created by liu on 2016/10/14.
 */
public class GankAndroidFragment extends BaseLazyFragment implements SwipeRefreshLayout.OnRefreshListener,RecyclerArrayAdapter.OnLoadMoreListener {

    @BindView(R.id.news_erv)
    EasyRecyclerView gankAndroidErv;

    private GankAndroidAdapter gankAndroidAdapter;
    private static  int count=10;
    private int page=0;

    @Override
    public int getLayout() {
        return R.layout.frag_news;
    }

    @Override
    public void initViews(View view) {
        gankAndroidErv.setLayoutManager(new LinearLayoutManager(getActivity()));
        gankAndroidErv.getSwipeToRefresh().setColorSchemeResources(R.color.colorPrimary);
        DividerDecoration itemDecoration = new DividerDecoration(Color.BLACK, WindowUtil.dip2px(getContext(),0.5f), 0,0);//颜色 & 高度 & 左边距 & 右边距
        gankAndroidErv.addItemDecoration(itemDecoration);
        gankAndroidAdapter=new GankAndroidAdapter(getActivity());
        gankAndroidErv.setAdapterWithProgress(gankAndroidAdapter);
        gankAndroidErv.setRefreshListener(this);
        gankAndroidAdapter.setMore(R.layout.view_more, this);
    }

    @Override
    public void loadData() {
        gankAndroidAdapter.clear();
        page=1;
        getGankAndroidData(page);
    }

    private void getGankAndroidData(int Page) {
//        Retrofit retrofit=new Retrofit.Builder().baseUrl(RetrofitHelper.GANK_BASE_URL).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
//        GankApi gankApi=retrofit.create(GankApi.class);
        RetrofitHelper.getGankAPI().getGankAndroid(count,page).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<GankAndroidBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(GankAndroidBean gankAndroidBean) {
                if (gankAndroidBean!=null){
                    gankAndroidAdapter.addAll(gankAndroidBean.getResults());
                }
            }
        });
    }

    @Override
    public void onRefresh() {
        if (gankAndroidAdapter!=null){
            page=1;
            gankAndroidAdapter.clear();
            getGankAndroidData(page);
        }
    }

    @Override
    public void onLoadMore() {
        page++;
        getGankAndroidData(page);
    }
}
