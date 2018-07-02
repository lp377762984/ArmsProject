package com.nettech.armsproject.bean;

import org.simple.eventbus.EventBus;
import org.simple.eventbus.Subscriber;

import timber.log.Timber;

public class Base {
    public void register(){
        EventBus.getDefault().register(this);
    }

    public void unRegister(){
        EventBus.getDefault().register(this);
    }

    @Subscriber()
    public void doSomething(Object o){
        Timber.d("doSomething: ");
    }
}
