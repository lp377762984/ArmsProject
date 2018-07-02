package com.nettech.armsproject.bean;

import org.simple.eventbus.EventBus;

public class E extends Base{
    public void postThings(){
        EventBus.getDefault().post(new Object());
    }
}
