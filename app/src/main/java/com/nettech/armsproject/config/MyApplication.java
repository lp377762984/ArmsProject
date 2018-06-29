package com.nettech.armsproject.config;

import com.jess.arms.base.BaseApplication;


public class MyApplication extends BaseApplication {
    private static MyApplication app;

    @Override
    public void onCreate() {
        //Thread.setDefaultUncaughtExceptionHandler(new CrashHandler(this));
        app = this;
        super.onCreate();

    }

    public static MyApplication getInstance() {
        return app;
    }
}
