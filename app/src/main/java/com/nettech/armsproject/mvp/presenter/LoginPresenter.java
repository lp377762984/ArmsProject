package com.nettech.armsproject.mvp.presenter;

import android.app.Application;

import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.http.imageloader.ImageLoader;
import com.jess.arms.integration.AppManager;
import com.jess.arms.utils.RxLifecycleUtils;
import com.nettech.armsproject.bean.LoginEntity;
import com.nettech.armsproject.bean.Result;
import com.nettech.armsproject.bean.User;
import com.nettech.armsproject.config.DefaultHandleSubscriber;
import com.nettech.armsproject.mvp.BBasePresenter;
import com.nettech.armsproject.mvp.contract.LoginContract;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;


@ActivityScope
public class LoginPresenter extends BBasePresenter<LoginContract.Model, LoginContract.View> {
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
    //发送验证码
    public void sendCode(String phone) {
        mModel.sendMCode(phone)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(disposable -> mRootView.showLoading())
                .subscribeOn(AndroidSchedulers.mainThread())//
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally(() -> mRootView.hideLoading())
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
                .subscribe(new DefaultHandleSubscriber<Result<User>>(mErrorHandler) {
                    @Override
                    public void onNext(Result<User> userResult) {
                        super.onNext(userResult);
                    }
                }.setHandler(this).setWhat(1));
    }
    //登陆
    public void login(String mobile,String code){
        mModel.login(mobile,code)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(disposable -> mRootView.showLoading())
                .subscribeOn(AndroidSchedulers.mainThread())//
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally(() -> mRootView.hideLoading())
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
                .subscribe(new DefaultHandleSubscriber<Result<LoginEntity>>(mErrorHandler) {
                    @Override
                    public void onNext(Result<LoginEntity> userResult) {
                        super.onNext(userResult);
                    }
                }.setHandler(this).setWhat(2));
    }
    @Override
    public <T> void handle200(int what, Result<T> result) {
        if (what == 1)
            mRootView.sendCode((Result<User>) result);
        else if(what==2)
            mRootView.loginSuccess((Result<LoginEntity>) result);
    }
}
