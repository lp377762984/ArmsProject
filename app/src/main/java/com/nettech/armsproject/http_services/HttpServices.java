package com.nettech.armsproject.http_services;


import com.nettech.armsproject.bean.Result;
import com.nettech.armsproject.bean.User;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface HttpServices {
    @FormUrlEncoded
    @POST("/getLoginVerify")
    Observable<Result<User>> sendCode(@Field("mobile") String phone);
}
