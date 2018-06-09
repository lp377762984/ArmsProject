package com.nettech.armsproject.BASE_NET_2;


public interface HttpResponseHandler1<T> {
    void handleException(Throwable t);
    void handle200(T result);
    void handleExcept200(String string);
}
