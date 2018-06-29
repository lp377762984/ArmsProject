package com.nettech.armsproject.bean;

import org.simple.eventbus.EventBus;
import org.simple.eventbus.Subscriber;

import timber.log.Timber;

public class A {

    public void bind() {
        EventBus.getDefault().register(this);
    }

    public void unBind() {
        EventBus.getDefault().unregister(this);
    }

    @Subscriber
    public void onGetEvent(int what) {
        Timber.d("onGetEvent: " + what);
    }

}
