package com.nettech.armsproject.mvp.model;

import android.app.Application;

import com.google.gson.Gson;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;
import com.nettech.armsproject.bean.LoginEntity;
import com.nettech.armsproject.bean.Result;
import com.nettech.armsproject.bean.User;
import com.nettech.armsproject.http_services.HttpServices;
import com.nettech.armsproject.mvp.contract.LoginContract;

import javax.inject.Inject;

import io.reactivex.Observable;


@ActivityScope
public class LoginModel extends BaseModel implements LoginContract.Model {
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public LoginModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

    @Override
    public Observable<Result<User>> sendMCode(String phone) {
        return mRepositoryManager
                .obtainRetrofitService(HttpServices.class)
                .sendCode(phone);
    }

    @Override
    public Observable<Result<LoginEntity>> login(String phone, String code) {
        return mRepositoryManager
                .obtainRetrofitService(HttpServices.class)
                .login(phone, code);
    }
}