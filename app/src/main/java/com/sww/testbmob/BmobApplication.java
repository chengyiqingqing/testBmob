package com.sww.testbmob;

import android.app.Application;

import cn.bmob.v3.Bmob;

public class BmobApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //第一：默认初始化
        Bmob.initialize(this, "7bde3e368deaa51420bb95d5dcb5a8cf");
    }

}
