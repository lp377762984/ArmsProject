package com.nettech.armsproject.bean;


import java.io.Serializable;

public class Resend implements Serializable {
    public MObservable observable;
    public int what;

    public Resend(MObservable observable, int what) {
        this.observable = observable;
        this.what = what;
    }
}
