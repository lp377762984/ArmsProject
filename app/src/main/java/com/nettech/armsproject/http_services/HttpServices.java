package com.nettech.armsproject.http_services;

import io.reactivex.Observable;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface HttpServices {
    @POST("/getLoginVerify")
    Observable<String> sendCode(@Query("phone") String phone);
}
