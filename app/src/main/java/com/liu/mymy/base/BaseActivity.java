package com.liu.mymy.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * 项目Activity基类
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        setLayout();
        initView();
        setOnClickListener();
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
    protected abstract void setOnClickListener();

    /**
     * 加载数据
     */
    protected abstract void loadData();
}
