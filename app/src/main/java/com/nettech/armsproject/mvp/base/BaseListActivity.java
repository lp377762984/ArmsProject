package com.nettech.armsproject.mvp.base;

import android.content.Intent;
import android.os.Bundle;

import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.mvp.IPresenter;
import com.jess.arms.mvp.IView;
import com.nettech.armsproject.mvp.presenter.ListPresenter;
import com.nettech.armsproject.mvp.presenter.UserPresenter;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by ASUS on 2018/6/6.
 */

public class BaseListActivity<P extends ListPresenter> extends BaseActivity<P> implements BaseView {

    @Override
    public void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    public int initView(Bundle savedInstanceState) {
        return 0;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        mPresenter.getListData(0,65645465465454L);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void launchActivity(Intent intent) {

    }

    @Override
    public void killMyself() {

    }


    @Override
    public <T> void getData(int what, List<T> data) {

    }
}
