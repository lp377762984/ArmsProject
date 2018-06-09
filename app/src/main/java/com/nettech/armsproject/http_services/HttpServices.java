package com.nettech.armsproject.http_services;


import com.nettech.armsproject.bean.LoginEntity;
import com.nettech.armsproject.bean.MsgAll;
import com.nettech.armsproject.bean.QustionAll;
import com.nettech.armsproject.bean.Result;
import com.nettech.armsproject.bean.User;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface HttpServices {
    @FormUrlEncoded
    @POST("/getLoginVerify")
    Observable<Result<User>> sendCode(@Field("mobile") String phone);
    @FormUrlEncoded
    @POST("/login")
    Observable<Result<LoginEntity>> login(@Field("mobile") String phone, @Field("verify") String code);
    @FormUrlEncoded
    @POST("/question/omnibus")
    Observable<QustionAll> getRecommends(@Field("questionId") Long questionId);
}
