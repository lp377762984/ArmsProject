package com.nettech.armsproject.base_net;

public interface HttpResponseHandler {
    void handleException(Throwable t);
    <T> void handle200(T result);
    void handleExcept200(String string);
}
