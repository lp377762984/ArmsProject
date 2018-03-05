package com.nettech.armsproject.http_services;


import com.nettech.armsproject.bean.Result;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface HttpServices {
    @FormUrlEncoded
    @POST("/getLoginVerify")
    Observable<Result<String>> sendCode(@Field("mobile") String phone);
}
