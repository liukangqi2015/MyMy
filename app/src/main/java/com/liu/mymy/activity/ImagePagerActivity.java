package com.liu.mymy.activity;

import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.liu.mymy.R;
import com.liu.mymy.base.BaseActivity;
import com.liu.mymy.bean.ResultsBean;
import com.liu.mymy.fragment.MeiziDetailFragment;
import com.liu.mymy.widget.HackyViewPager;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * 展示图片的Activity
 * Created by liu on 2016/10/18.
 */
public class ImagePagerActivity extends BaseActivity {
    public static String POSITION="position";
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.app_bar_layout)
    AppBarLayout appBarLayout;
    @BindView(R.id.image_vp)
    HackyViewPager imageVp;

    //当前图片的位置
    private int currentIndex;

    private Realm realm;

    private boolean isHide = false;

    private RealmResults<ResultsBean> gankMeizis;

    private MeiziPagerAdapter mPagerAdapter;
    private String url;


    @Override
    protected void setLayout() {
        setContentView(getLayoutId());
        ButterKnife.bind(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_image_pager;
    }

    @Override
    protected void initView() {
        Intent intent=getIntent();
        if (intent!=null){
            currentIndex=intent.getIntExtra(POSITION,-1);
        }
        realm = Realm.getDefaultInstance();
        gankMeizis = realm.where(ResultsBean.class).findAll();
        initToolBar();
//        setEnterSharedElementCallback(new SharedElementCallback()
//        {
//
//            @Override
//            public void onMapSharedElements(List<String> names, Map<String,View> sharedElements)
//            {
//
//                ResultsBean gankMeizi = gankMeizis.get(imageVp.getCurrentItem());
//                MeiziDetailFragment fragment = (MeiziDetailFragment)
//                        mPagerAdapter.instantiateItem(imageVp, currentIndex);
//                sharedElements.clear();
//                sharedElements.put(gankMeizi.getUrl(), fragment.getSharedElement());
//            }
//        });
    }

    private void initToolBar() {

        toolbar.setNavigationIcon(R.drawable.ic_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {

                onBackPressed();
            }
        });
        toolbar.inflateMenu(R.menu.menu_meizi);


        //设置toolbar的颜色
        appBarLayout.setAlpha(0.5f);
        toolbar.setBackgroundResource(R.color.black_90);
        appBarLayout.setBackgroundResource(R.color.black_90);
    }

    /**
     * 保存图片到本地
     */
    private void saveImage()
    {

//        RxMenuItem.clicks(toolbar.getMenu().findItem(R.id.action_fuli_save))
//                .compose(bindToLifecycle())
//                .compose(RxPermissions.getInstance(ImagePagerActivity.this)
//                        .ensure(Manifest.permission.WRITE_EXTERNAL_STORAGE))
//                .observeOn(Schedulers.io())
//                .filter(new Func1<Boolean,Boolean>()
//                {
//
//                    @Override
//                    public Boolean call(Boolean aBoolean)
//                    {
//
//                        return aBoolean;
//                    }
//                })
//                .flatMap(new Func1<Boolean, Observable<Uri>>()
//                {
//
//                    @Override
//                    public Observable<Uri> call(Boolean aBoolean)
//                    {
//
//                        return GlideDownloadImageUtil.saveImageToLocal(GankMeiziPageActivity.this, url);
//                    }
//                })
//                .map(new Func1<Uri,String>()
//                {
//
//                    @Override
//                    public String call(Uri uri)
//                    {
//
//                        String msg = String.format("图片已保存至 %s 文件夹",
//                                new File(Environment.getExternalStorageDirectory(),
//                                        ConstantUtil.FILE_DIR)
//                                        .getAbsolutePath());
//                        return msg;
//                    }
//                })
//                .observeOn(AndroidSchedulers.mainThread())
//                .retry()
//                .subscribe(new Action1<String>()
//                {
//
//                    @Override
//                    public void call(String s)
//                    {
//
//                        Toast.makeText(GankMeiziPageActivity.this, s,
//                                Toast.LENGTH_SHORT).show();
//                    }
//                }, new Action1<Throwable>()
//                {
//
//                    @Override
//                    public void call(Throwable throwable)
//                    {
//
//                        Toast.makeText(GankMeiziPageActivity.this, "保存失败,请重试",
//                                Toast.LENGTH_SHORT).show();
//                    }
//                });
    }

    @Override
    protected void setListener() {
        imageVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                toolbar.setTitle(gankMeizis.get(position).getDesc());
                currentIndex = position;
                url = gankMeizis.get(currentIndex).getUrl();
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected void loadData() {
        mPagerAdapter = new MeiziPagerAdapter(getSupportFragmentManager());
        imageVp.setAdapter(mPagerAdapter);
    }

    @Override
    protected void onResume()
    {

        super.onResume();
        imageVp.setCurrentItem(currentIndex);
        url = gankMeizis.get(currentIndex).getUrl();
    }

    private class MeiziPagerAdapter extends FragmentStatePagerAdapter
    {


        public MeiziPagerAdapter(FragmentManager fm)
        {

            super(fm);
        }

        @Override
        public Fragment getItem(int position)
        {

            return MeiziDetailFragment.
                    newInstance(gankMeizis.get(position).getUrl());
        }


        @Override
        public int getCount()
        {

            return gankMeizis.size();
        }
    }

}
