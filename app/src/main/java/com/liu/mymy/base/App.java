package com.liu.mymy.base;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * 本App的Application
 * Created by liu on 2016/10/12.
 */
public class App extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
