package com.nettech.armsproject.mvp.model;

import android.app.Application;

import com.google.gson.Gson;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import com.jess.arms.di.scope.ActivityScope;

import javax.inject.Inject;

import com.nettech.armsproject.bean.QustionAll;
import com.nettech.armsproject.http_services.HttpServices;
import com.nettech.armsproject.mvp.contract.TestReuseContract;

import io.reactivex.Observable;


@ActivityScope
public class TestReuseModel extends BaseModel implements TestReuseContract.Model {
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public TestReuseModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

    @Override
    public Observable<QustionAll> getData(Long questionId) {
        return mRepositoryManager.obtainRetrofitService(HttpServices.class).getRecommends(questionId);
    }
}