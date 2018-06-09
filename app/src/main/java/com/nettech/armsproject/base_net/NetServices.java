package com.nettech.armsproject.base_net;

import com.nettech.armsproject.bean.LoginEntity;
import com.nettech.armsproject.bean.Result;
import com.nettech.armsproject.bean.User;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by ASUS on 2018/4/1.
 */

public interface NetServices {
    @FormUrlEncoded
    @POST("/getLoginVerify")
    Call<Result<User>> sendCode(@Field("mobile") String phone);
    @FormUrlEncoded
    @POST("/login")
    Call<Result<LoginEntity>> login(@Field("mobile") String phone, @Field("verify") String code);

}
