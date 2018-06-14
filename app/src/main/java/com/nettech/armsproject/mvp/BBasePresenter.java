package com.nettech.armsproject.mvp;


import android.content.Intent;

import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.mvp.IModel;
import com.jess.arms.utils.ArmsUtils;
import com.nettech.armsproject.bean.Result;
import com.nettech.armsproject.http_services.HttpResponseHandler;
import com.nettech.armsproject.mvp.base.BaseView;
import com.nettech.armsproject.mvp.ui.activity.LoginActivity;


public class BBasePresenter<M extends IModel,V extends BaseView> extends BasePresenter<M ,V> implements HttpResponseHandler{
    public BBasePresenter(M model, V rootView) {
        super(model, rootView);
    }

    @Override
    public void handle10(int what,Result result) {
        ArmsUtils.snackbarText(result.msg);
    }

    @Override
    public void handle11(int what,Result result) {
        ArmsUtils.snackbarText(result.msg);
    }

    @Override
    public void handle20(int what,Result result) {
        //mRootView.launchActivity(new Intent(MyApplication.getInstance().getAppComponent().appManager().getCurrentActivity(), LoginActivity.class));
        mRootView.getActivity().startActivityForResult(new Intent(mRootView.getActivity(), LoginActivity.class),what);
    }

    @Override
    public <T> void handle200(int what, Result<T> result) {

    }

    @Override
    public <T> void handle404(int what, Result<T> result) {
        ArmsUtils.snackbarText(result.msg);
    }
}
