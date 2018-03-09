package com.droi.hava;

import android.app.Application;

import com.droi.immodule.IMRong;

import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;

/**
 * Created by zzb on 2018/3/7.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
//        RongIM.init(this);
        IMRong immodule = IMRong.getInstance();
        immodule.Init(this);
    }
}
