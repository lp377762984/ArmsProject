package com.nettech.armsproject.http_services;

import com.nettech.armsproject.bean.Result;

public interface HttpResponseHandler {
    void handle10(int what,Result result);
    void handle11(int what,Result result);
    void handle20(int what,Result result);
    <T> void  handle200(int what,Result<T> result);
    <T>  void handle404(int what,Result<T> result);
}
