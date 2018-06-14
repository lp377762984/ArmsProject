package com.nettech.armsproject.mvp.model;

import android.app.Application;

import com.google.gson.Gson;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;
import com.nettech.armsproject.bean.LoginEntity;
import com.nettech.armsproject.bean.Result;
import com.nettech.armsproject.bean.User;
import com.nettech.armsproject.http_services.CommonCache;
import com.nettech.armsproject.http_services.HttpServices;
import com.nettech.armsproject.mvp.contract.LoginContract;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.EvictDynamicKey;
import io.rx_cache2.Reply;
import timber.log.Timber;


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
       /* return Observable.just(mRepositoryManager.obtainRetrofitService(HttpServices.class).login(phone,code))
                .flatMap(new Function<Observable<Result<LoginEntity>>, ObservableSource<Result<LoginEntity>>>() {
                    @Override
                    public ObservableSource<Result<LoginEntity>> apply(Observable<Result<LoginEntity>> resultObservable) throws Exception {
                        return mRepositoryManager.obtainCacheService(CommonCache.class)
                                .getUsers(resultObservable,new DynamicKey(1),new EvictDynamicKey(false))
                                .map(new Function<Reply<Result<LoginEntity>>, Result<LoginEntity>>() {
                                    @Override
                                    public Result<LoginEntity> apply(Reply<Result<LoginEntity>> resultReply) throws Exception {
                                        Timber.tag("LoginModel").d(resultReply.getSource().name());
                                        return resultReply.getData();
                                    }
                                });
                    }
                });*/
       //使用缓存有泛型问题
        return mRepositoryManager.obtainRetrofitService(HttpServices.class).login(phone,code);
    }
}