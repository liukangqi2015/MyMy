package com.liu.mymy.fragment;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.liu.mymy.R;
import com.liu.mymy.activity.ImagePagerActivity;
import com.liu.mymy.adapter.GankMeiziAdapter;
import com.liu.mymy.api.RetrofitHelper;
import com.liu.mymy.base.BaseLazyFragment;
import com.liu.mymy.bean.GankMeiziBean;

import java.util.ArrayList;

import butterknife.BindView;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 妹子福利Fragment
 * Created by liu on 2016/10/17.
 */
public class GankMeiziFragment extends BaseLazyFragment implements SwipeRefreshLayout.OnRefreshListener,RecyclerArrayAdapter.OnLoadMoreListener {

    @BindView(R.id.news_erv)
    EasyRecyclerView gankMeiziErv;

    private GankMeiziAdapter gankMeiziAdapter;
    private ArrayList<GankMeiziBean.ResultsBean> data=new ArrayList<>();
    //每一页数据的大小
    private static  int count=10;
    //页数
    private int page=0;
    private int imageIndex;

    @Override
    public int getLayout() {
        return R.layout.frag_news;
    }

    @Override
    public void initViews(View view) {
        StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
//        staggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        gankMeiziErv.setLayoutManager(staggeredGridLayoutManager);
        gankMeiziErv.getSwipeToRefresh().setColorSchemeResources(R.color.colorPrimary);
        gankMeiziAdapter=new GankMeiziAdapter(getActivity());
        gankMeiziErv.setAdapterWithProgress(gankMeiziAdapter);
        gankMeiziErv.setRefreshListener(this);
        gankMeiziAdapter.setMore(R.layout.view_more, this);
        gankMeiziAdapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent=new Intent(getActivity(),ImagePagerActivity.class);
                intent.putExtra(ImagePagerActivity.POSITION,position);
                if (Build.VERSION.SDK_INT>Build.VERSION_CODES.LOLLIPOP){
                    startActivity(intent,ActivityOptions.makeSceneTransitionAnimation(getActivity(),gankMeiziErv.getRecyclerView().getChildAt(position),gankMeiziAdapter.getItem(position).getUrl()).toBundle());
                }else{
                    startActivity(intent);
                }

            }
        });
//        setEnterSharedElementCallback(new SharedElementCallback()
//        {
//
//            @Override
//            public void onMapSharedElements(List<String> names, Map<String,View> sharedElements)
//            {
//
//                super.onMapSharedElements(names, sharedElements);
//                String newTransitionName = data.get(imageIndex).getUrl();
//                View newSharedView = gankMeiziErv.getRecyclerView().findViewWithTag(newTransitionName);
//                if (newSharedView != null)
//                {
//                    names.clear();
//                    names.add(newTransitionName);
//                    sharedElements.clear();
//                    sharedElements.put(newTransitionName, newSharedView);
//                }
//            }
//        });
    }

    @Override
    public void loadData() {
        gankMeiziAdapter.clear();
        page=1;
        getGankMeiziData(page);
    }

    private void getGankMeiziData(int page){
        RetrofitHelper.getGankAPI().getGankMeizi(count,page).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<GankMeiziBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(GankMeiziBean gankMeiziBean) {
                if (gankMeiziBean!=null){
                    data.addAll(gankMeiziBean.getResults());
                    gankMeiziAdapter.addAll(data);
                }
            }
        });
    }

    @Override
    public void onRefresh() {
        if (gankMeiziAdapter!=null){
            gankMeiziAdapter.clear();
            page=1;
            getGankMeiziData(page);
        }
    }

    @Override
    public void onLoadMore() {
        page++;
        getGankMeiziData(page);
    }
}
