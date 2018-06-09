package com.nettech.armsproject.mvp.presenter;

import android.app.Application;

import com.jess.arms.http.imageloader.ImageLoader;
import com.jess.arms.integration.AppManager;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.mvp.IModel;
import com.jess.arms.mvp.IView;
import com.nettech.armsproject.bean.QustionAll;
import com.nettech.armsproject.http_services.HttpServices;
import com.nettech.armsproject.mvp.base.BaseView;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber;

/**
 * Created by ASUS on 2018/6/6.
 */

public class UserPresenter<M extends IModel, V extends IView> extends BasePresenter<M,V> {
    @Inject
    RxErrorHandler mErrorHandler;
    private IRepositoryManager mRepositoryManager;//用于管理网络请求层,以及数据缓存层

    public UserPresenter(IRepositoryManager repositoryManager) {
        this.mRepositoryManager = repositoryManager;
    }
    public void getMsgData(Long id,BaseView view,int what){
        mRepositoryManager.obtainRetrofitService(HttpServices.class).getRecommends(id)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(disposable -> {
                    view.showLoading();
                })
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally(() -> {
                    view.hideLoading();
                })
                .subscribe(new ErrorHandleSubscriber<QustionAll>(mErrorHandler) {
                    @Override
                    public void onNext(QustionAll qustionAll) {
                        view.getData(what,qustionAll.getData());
                    }
                });
    }
}
