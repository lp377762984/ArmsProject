package com.nettech.armsproject.http_services;


import com.nettech.armsproject.bean.All;
import com.nettech.armsproject.bean.LoginEntity;
import com.nettech.armsproject.bean.QustionAll;
import com.nettech.armsproject.bean.Result;
import com.nettech.armsproject.bean.User;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;

public interface HttpServices {
    @FormUrlEncoded
    @POST("/getLoginVerify")
    Observable<Result<User>> sendCode(@Field("mobile") String phone);

    @FormUrlEncoded
    @POST("/login")
    Observable<Result<LoginEntity>> login(@Field("mobile") String phone, @Field("verify") String code);
    /*@FormUrlEncoded
    @POST("/login")
    Observable<All> login(@Field("mobile") String phone, @Field("verify") String code);*/

    @FormUrlEncoded
    @POST("/question/omnibus")
    Observable<QustionAll> getRecommends(@Field("questionId") Long questionId);

    @Multipart
    @POST("/user/set")
    Observable<Result<User>> uploadFile(@Part("avatar") String key, @PartMap()Map<String, RequestBody> maps);

    @Multipart
    @POST("/user/set")
    Observable<Result<User>> uploadSigleFile(@Part("avatar") RequestBody file);

    @Multipart
    @POST("/user/set")
    Observable<Result<User>> uploadSigleFile(@Part() MultipartBody.Part file);

    @POST("/user/set")
    Observable<Result<User>> uploadFileBody( @Body RequestBody Body);
}
