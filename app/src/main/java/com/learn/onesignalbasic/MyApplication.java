package com.learn.onesignalbasic;

import android.app.Application;

import com.onesignal.OneSignal;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        OneSignal.startInit(this)
                .setNotificationOpenedHandler(new MyNotificationOpenedHandler(this))
                .setNotificationReceivedHandler(new MyNotificationReceivedHandler())
                .init();

    }
}
