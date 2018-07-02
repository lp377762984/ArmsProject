package com.nettech.armsproject.mvp;


import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import com.jess.arms.base.delegate.IFragment;
import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.mvp.IModel;
import com.jess.arms.mvp.IView;
import com.jess.arms.utils.ArmsUtils;
import com.jess.arms.utils.RxLifecycleUtils;
import com.nettech.armsproject.bean.MObservable;
import com.nettech.armsproject.bean.Resend;
import com.nettech.armsproject.bean.Result;
import com.nettech.armsproject.config.DefaultHandleSubscriber;
import com.nettech.armsproject.config.MyApplication;
import com.nettech.armsproject.http_services.HttpResponseHandler;
import com.nettech.armsproject.mvp.ui.activity.LoginActivity;

import org.simple.eventbus.EventBus;
import org.simple.eventbus.Subscriber;

import java.io.Serializable;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import timber.log.Timber;


public class BBasePresenter<M extends IModel, V extends IView> extends BasePresenter<M, V> implements HttpResponseHandler {
    @Inject
    RxErrorHandler mErrorHandler;
    protected Resend resend;

    public BBasePresenter(M model, V rootView) {
        super(model, rootView);
    }

    @Override
    public void handle10(int what, Result result) {
        ArmsUtils.snackbarText(result.msg);
    }

    @Override
    public void handle11(int what, Result result) {
        ArmsUtils.snackbarText(result.msg);
    }

    @Override
    public void handle20(int what, Result result) {
        //mRootView.launchActivity(new Intent(MyApplication.getInstance().getAppComponent().appManager().getCurrentActivity(), LoginActivity.class));
        Activity topActivity = MyApplication.getInstance().getAppComponent().appManager().getTopActivity();
        Intent intent = new Intent(topActivity, LoginActivity.class);
        //intent.putExtra("reSend", resend);
        topActivity.startActivity(intent);
    }

    @Override
    public <T> void handle200(int what, Result<T> result) {

    }

    @Override
    public <T> void handle404(int what, Result<T> result) {
        ArmsUtils.snackbarText(result.msg);
    }

    //执行网络请求
    protected <T> void doRequest(Observable<T> observable, RxErrorHandler errorHandler, int what, HttpResponseHandler handler) {
        resend = new Resend((observable), what);
        observable.subscribe(new DefaultHandleSubscriber<T>(errorHandler, what, handler));
    }

    //执行网络请求
    protected <T> void doRequest(Observable<T> observable, RxErrorHandler errorHandler, int what) {
        doRequest(observable, errorHandler, what, this);
    }

    protected <T> void doRequest(Observable<T> observable, int what) {
        doRequest(observable, mErrorHandler, what, this);
    }


    //生成网络请求
    protected <T> Observable<T> buildRequest(Observable<T> observable, boolean needLoading) {
        return observable
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(disposable -> {
                    if (needLoading) mRootView.showLoading();
                })
                .subscribeOn(AndroidSchedulers.mainThread())//
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally(() -> {
                    if (needLoading) mRootView.hideLoading();
                })
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView));
    }

    //生成网络请求
    protected <T> Observable<T> buildRequest(Observable<T> observable) {
        return buildRequest(observable, true);
    }

    @Subscriber()
    public void reDoRequest(Object o) {//子类中定义eventBus方法，会重复收到事件。暂时解决办法将loginPresenter的useEventBus return false,
        if (resend != null) {
            Timber.d("reDoRequest");
            doRequest(resend.observable, mErrorHandler, resend.what);
        }
    }

    @Subscriber(tag = "bbb")
    public void reDoRequest2(int what) {
        Timber.d("reDoRequest2: %s", what);
    }
}
