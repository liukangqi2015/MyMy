package com.liu.mymy.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.liu.mymy.network.TANetChangeObserver;
import com.liu.mymy.network.TANetworkStateReceiver;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

/**
 * 项目Activity基类
 */
public abstract class BaseActivity extends RxAppCompatActivity implements TANetChangeObserver{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        TANetworkStateReceiver.registerNetworkStateReceiver(this);
        TANetworkStateReceiver.registerObserver(this);
        setLayout();
        initView();
        setListener();
        loadData();
    }

    /**
     * 设置布局
     */
    protected abstract void setLayout();

    /**
     * 返回当前Activity的布局Id
     * @return resId
     */
    protected abstract int getLayoutId();

    /**
     * 初始化View
     */
    protected abstract void initView();

    /**
     * 设置监听器
     */
    protected abstract void setListener();

    /**
     * 加载数据
     */
    protected abstract void loadData();

    @Override
    protected void onDestroy() {
        TANetworkStateReceiver.unRegisterNetworkStateReceiver(this);
        TANetworkStateReceiver.removeRegisterObserver(this);
        super.onDestroy();
    }
}
