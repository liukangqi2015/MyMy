package com.liu.mymy;

import android.content.Intent;
import android.graphics.Color;
import android.provider.Settings;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.liu.mymy.base.BaseActivity;
import com.liu.mymy.fragment.GankAndroidFragment;
import com.liu.mymy.fragment.GankMeiziFragment;
import com.liu.mymy.fragment.NewsFragment;
import com.liu.mymy.network.TANetWorkUtil;
import com.liu.mymy.util.LogUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.vp)
    ViewPager mViewPager;
    @BindView(R.id.tl)
    TabLayout mTl;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private String[] mTitles = {"新闻", "干货", "福利"};
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private MyPagerAdapter mAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        toolbar.setTitle(R.string.app_name);
        toolbar.setTitleTextColor(Color.WHITE);
        mFragments.add(new NewsFragment());
        mFragments.add(new GankAndroidFragment());
        mFragments.add(new GankMeiziFragment());

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void loadData() {
        mViewPager.setOffscreenPageLimit(2);
        mAdapter = new MyPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mTl.setupWithViewPager(mViewPager);
        mTl.setTabMode(TabLayout.MODE_FIXED);
        mViewPager.setCurrentItem(0);
    }


    @Override
    protected void setLayout() {
        setContentView(getLayoutId());
        ButterKnife.bind(this);
    }

    @Override
    public void onConnect(TANetWorkUtil.netType type) {

    }

    @Override
    public void onDisConnect() {
        LogUtil.e(TAG, "网络不可用");
        Snackbar snackbar = Snackbar.make(mViewPager, getResources().getString(R.string.network_warn), Snackbar.LENGTH_LONG);
        snackbar.setAction(getResources().getString(R.string.network_setting), new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 跳转到系统的网络设置界面
                Intent intent = null;
                // 先判断当前系统版本
                if (android.os.Build.VERSION.SDK_INT > 10) {  // 3.0以上
                    intent = new Intent(android.provider.Settings
                            .ACTION_WIFI_SETTINGS);
                } else {
                    intent = new Intent();
                    intent.setClassName("com.android.settings",
                            Settings.ACTION_WIFI_SETTINGS);
                }
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        snackbar.getView().setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        snackbar.show();
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            Log.e(getClass().getSimpleName(), "getItem");
            return mFragments.get(position);
        }

    }

    /**
     * 最后按下的时间
     */
    private long lastTime;

    /**
     * 按二次返回键退出应用
     */
    @Override
    public void onBackPressed() {
        long currentTime = System.currentTimeMillis();

        if (currentTime - lastTime < 2 * 1000) {
            super.onBackPressed();
        } else {
//            Toast.makeText(this, "再按一次退出应用", Toast.LENGTH_SHORT).show();
            Snackbar snackbar = Snackbar.make(mViewPager, getResources().getString(R.string.snack_bar_text), Snackbar.LENGTH_SHORT);
            snackbar.getView().setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            snackbar.show();
            lastTime = currentTime;
        }

    }

//    @Override
//    protected void onResume() {
//        NetworkConnectChangedReceiver.getInstance().registerNetworkConnectChangedReceiver(this);
//        super.onResume();
//    }
//
//    @Override
//    protected void onPause() {
//        NetworkConnectChangedReceiver.getInstance().unRegisterNetworkConnectChangedReceiver(this);
//        super.onPause();
//    }
}
