package com.nettech.armsproject.mvp;

import android.content.Intent;

import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.mvp.IModel;
import com.jess.arms.mvp.IView;
import com.jess.arms.utils.ArmsUtils;
import com.nettech.armsproject.bean.Result;
import com.nettech.armsproject.config.MyApplication;
import com.nettech.armsproject.http_services.HttpResponseHandler;
import com.nettech.armsproject.mvp.ui.activity.LoginActivity;


public class BBasePresenter<M extends IModel,V extends IView,T> extends BasePresenter<M ,V> implements HttpResponseHandler<T> {
    public BBasePresenter(M model, V rootView) {
        super(model, rootView);
    }

    public BBasePresenter(V rootView) {
        super(rootView);
    }

    public BBasePresenter() {
    }

    @Override
    public void handle10(int what) {
        ArmsUtils.snackbarText("请求头参数错误");
    }

    @Override
    public void handle11(int what) {
        ArmsUtils.snackbarText("sign验证失败或非法请求");
    }

    @Override
    public void handle20(int what) {
        mRootView.launchActivity(new Intent(MyApplication.getInstance().getAppComponent().appManager().getCurrentActivity(), LoginActivity.class));
    }

    @Override
    public void handle200(int what, Result<T> result) {

    }

    @Override
    public void handle404(int what, Result<T> result) {
        ArmsUtils.snackbarText(result.msg);
    }
}
