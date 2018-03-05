package com.nettech.armsproject.bean;

import com.google.gson.annotations.SerializedName;

public class Result<T> {
    public int code;
    public String msg;
    public T data;
    @SerializedName("version_upgrade")
    AppUpdate update;
    public static class AppUpdate{
        public int android_type;
        public int ios_type;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", update=" + update +
                '}';
    }
}
