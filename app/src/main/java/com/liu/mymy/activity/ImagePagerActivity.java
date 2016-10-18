package com.liu.mymy.activity;

import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.SharedElementCallback;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.liu.mymy.R;
import com.liu.mymy.base.BaseActivity;
import com.liu.mymy.widget.HackyViewPager;

import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 展示图片的Activity
 * Created by liu on 2016/10/18.
 */
public class ImagePagerActivity extends BaseActivity {
    public static String POSITION="postion";
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.app_bar_layout)
    AppBarLayout appBarLayout;
    @BindView(R.id.image_vp)
    HackyViewPager imageVp;

    //当前图片的位置
    private int currentIndex;

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
        initToolBar();
        setEnterSharedElementCallback(new SharedElementCallback()
        {

            @Override
            public void onMapSharedElements(List<String> names, Map<String,View> sharedElements)
            {

//                GankMeizi gankMeizi = gankMeizis.get(imageVp.getCurrentItem());
//                GankMeiziFragment fragment = (GankMeiziFragment)
//                        mPagerAdapter.instantiateItem(imageVp, currentIndex);
//                sharedElements.clear();
//                sharedElements.put(gankMeizi.getUrl(), fragment.getSharedElement());
            }
        });
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

    @Override
    protected void setListener() {

    }

    @Override
    protected void loadData() {

    }


//    private class MeiziPagerAdapter extends FragmentStatePagerAdapter
//    {
//
//
//        public MeiziPagerAdapter(FragmentManager fm)
//        {
//
//            super(fm);
//        }
//
//        @Override
//        public Fragment getItem(int position)
//        {
//
//            return MeiziDetailsFragment.
//                    newInstance(gankMeizis.get(position).getUrl());
//        }
//
//
//        @Override
//        public int getCount()
//        {
//
//            return gankMeizis.size();
//        }
//    }

}
