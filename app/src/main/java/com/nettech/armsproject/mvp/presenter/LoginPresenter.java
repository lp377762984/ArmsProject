package com.nettech.armsproject.mvp.presenter;

import android.app.Application;
import android.content.Intent;

import com.jess.arms.base.BaseApplication;
import com.jess.arms.integration.AppManager;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.http.imageloader.ImageLoader;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

import javax.inject.Inject;

import com.jess.arms.utils.ArmsUtils;
import com.nettech.armsproject.bean.Result;
import com.nettech.armsproject.bean.User;
import com.nettech.armsproject.config.DefaultHandleSubscriber;
import com.nettech.armsproject.config.MyApplication;
import com.nettech.armsproject.http_services.HttpResponseHandler;
import com.nettech.armsproject.mvp.BBasePresenter;
import com.nettech.armsproject.mvp.contract.LoginContract;
import com.nettech.armsproject.mvp.ui.activity.LoginActivity;

import java.io.IOException;


@ActivityScope
public class LoginPresenter extends BBasePresenter<LoginContract.Model, LoginContract.View,User> {
    @Inject
    RxErrorHandler mErrorHandler;
    @Inject
    Application mApplication;
    @Inject
    ImageLoader mImageLoader;
    @Inject
    AppManager mAppManager;

    @Inject
    public LoginPresenter(LoginContract.Model model, LoginContract.View rootView) {
        super(model, rootView);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mErrorHandler = null;
        this.mAppManager = null;
        this.mImageLoader = null;
        this.mApplication = null;
    }

    public void sendCode(String phone) {
        if (mRootView.phoneError(phone)) {
            mModel.sendMCode(phone)
                    .subscribeOn(Schedulers.io())
                    .doOnSubscribe(disposable -> mRootView.showLoading())
                    .observeOn(AndroidSchedulers.mainThread())

                    .doFinally(() -> mRootView.hideLoading())
                    .subscribe(new DefaultHandleSubscriber<Result<User>>(mErrorHandler) {
                        @Override
                        public void onNext(Result<User> userResult) {
                            super.onNext(userResult);
                        }
                    }.setHandler(this).setWhat(1));
        }
    }

    @Override
    public void handle200(int what,Result<User> result) {
        mRootView.sendCode(result);
    }
}
