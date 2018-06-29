package com.nettech.armsproject.bean;

import org.simple.eventbus.EventBus;

public class C {
    public void postEvent(int event){
        EventBus.getDefault().post(event);
    }
}
