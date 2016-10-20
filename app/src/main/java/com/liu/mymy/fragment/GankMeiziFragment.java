package com.liu.mymy.fragment;

import android.content.Intent;
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
import com.liu.mymy.bean.GankMeiziInfo;
import com.liu.mymy.bean.ResultsBean;
import com.liu.mymy.util.DataUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.realm.Realm;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * 妹子福利Fragment
 * Created by liu on 2016/10/17.
 */
public class GankMeiziFragment extends BaseLazyFragment implements SwipeRefreshLayout.OnRefreshListener, RecyclerArrayAdapter.OnLoadMoreListener {
    private static final String TAG=GankMeiziFragment.class.getSimpleName();

    @BindView(R.id.news_erv)
    EasyRecyclerView gankMeiziErv;

    private GankMeiziAdapter gankMeiziAdapter;
//    private MeiziAdapter meiziAdapter;
    private List<GankMeiziInfo> data=new ArrayList<>();
    //每一页数据的大小
    private static int count = 10;
    //页数
    private int page = 0;
    private int imageIndex;

    private Realm realm;

    @Override
    public int getLayout() {
        return R.layout.frag_news;
    }

    @Override
    public void initViews(View view) {
        realm = Realm.getDefaultInstance();
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
//        staggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        gankMeiziErv.setLayoutManager(staggeredGridLayoutManager);
        gankMeiziErv.getSwipeToRefresh().setColorSchemeResources(R.color.colorPrimary);
        gankMeiziAdapter = new GankMeiziAdapter(getActivity());
//        meiziAdapter=new MeiziAdapter(gankMeiziErv.getRecyclerView(),data);
        gankMeiziErv.setAdapterWithProgress(gankMeiziAdapter);
        gankMeiziErv.setRefreshListener(this);
        gankMeiziAdapter.setMore(R.layout.view_more, this);
        gankMeiziAdapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getActivity(), ImagePagerActivity.class);
                intent.putExtra(ImagePagerActivity.POSITION, position);
//                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
////                    Log.e(TAG,"View-"+gankMeiziErv.getRecyclerView().getChildAt(position)+"url-"+data.get(position).url);
////                    startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(getActivity(), gankMeiziErv.getRecyclerView().getChildAt(position),data.get(position).url).toBundle());
//                    startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(getActivity()).toBundle());
//                } else {
//                    startActivity(intent);
//                }
                startActivity(intent);

            }
        });
//        setEnterSharedElementCallback(new SharedElementCallback() {
//
//            @Override
//            public void onMapSharedElements(List<String> names, Map<String, View> sharedElements) {
//
//                super.onMapSharedElements(names, sharedElements);
//                String newTransitionName = data.get(imageIndex).url;
//                View newSharedView = gankMeiziErv.getRecyclerView().findViewWithTag(newTransitionName);
//                if (newSharedView != null) {
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
        clearCache();
        data.clear();
        gankMeiziAdapter.clear();
        page = 1;
        getGankMeiziData();
    }

    private void getGankMeiziData() {
        RetrofitHelper.
                getGankAPI().
                getGankMeizi(count, page).
                compose(this.<GankMeiziBean>bindToLifecycle()).
                map(new Func1<GankMeiziBean, List<GankMeiziInfo>>() {
                    @Override
                    public List<GankMeiziInfo> call(GankMeiziBean gankMeiziBean) {
                        return gankMeiziBean.getResults();
                    }
                }).
                doOnNext(new Action1<List<GankMeiziInfo>>() {
                    @Override
                    public void call(List<GankMeiziInfo> gankInfo) {
                        DataUtil.putGankMeiziCache(gankInfo);
                    }
                }).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Subscriber<List<GankMeiziInfo>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<GankMeiziInfo> gankInfo) {
                        data.addAll(gankInfo);
                        gankMeiziAdapter.addAll(gankInfo);
                    }
                });
    }

    @Override
    public void onRefresh() {
        if (gankMeiziAdapter != null) {
            clearCache();
            data.clear();
            gankMeiziAdapter.clear();
            page = 1;
            getGankMeiziData();
        }
    }

    @Override
    public void onLoadMore() {
        page++;
        getGankMeiziData();
    }

    private void clearCache() {

        try {
            realm.beginTransaction();
            realm.where(ResultsBean.class)
                    .findAll().clear();
            realm.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
