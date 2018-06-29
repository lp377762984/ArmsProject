package com.nettech.armsproject.bean;


import java.io.Serializable;

import io.reactivex.Observable;

public class Resend implements Serializable {
    public Observable observable;
    public int what;

    public Resend(Observable observable, int what) {
        this.observable = observable;
        this.what = what;
    }
}
