package com.nettech.armsproject.bean;

public class D extends Base {
    private E e;

    public D(E e) {
        this.e = e;
    }

    public void postThings(){
        e.postThings();
    }
}
