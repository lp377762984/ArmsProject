package com.nettech.armsproject.http_services;

import com.nettech.armsproject.bean.Result;

public interface HttpResponseHandler<T> {
    void handle10(int what);
    void handle11(int what);
    void handle20(int what);
    void handle200(int what,Result<T> result);
    void handle404(int what,Result<T> result);
}
