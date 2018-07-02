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
import com.nettech.armsproject.http_services.HttpResponseHandler;
import com.nettech.armsproject.mvp.BBasePresenter;
import com.nettech.armsproject.mvp.contract.LoginContract;

import org.simple.eventbus.EventBus;
import org.simple.eventbus.Subscriber;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import timber.log.Timber;


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
        doRequest(buildRequest(mModel.sendMCode(phone)),1);
    }

    //登陆
    public void login(String mobile, String code) {
        doRequest(buildRequest(mModel.login(mobile, code)),2);
    }

    @Override
    public <T> void handle200(int what, Result<T> result) {
        if (what == 1)
            mRootView.sendCode((Result<User>) result);
        else if (what == 2)
            mRootView.loginSuccess((Result<LoginEntity>) result);
    }

    @Override
    public boolean useEventBus() {
        return false;
    }
}
