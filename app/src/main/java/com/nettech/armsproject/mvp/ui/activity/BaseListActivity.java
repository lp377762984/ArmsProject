package com.nettech.armsproject.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import com.nettech.armsproject.di.component.DaggerBaseListComponent;
import com.nettech.armsproject.di.module.BaseListModule;
import com.nettech.armsproject.mvp.contract.BaseListContract;
import com.nettech.armsproject.mvp.presenter.BaseListPresenter;

import com.nettech.armsproject.R;


import static com.jess.arms.utils.Preconditions.checkNotNull;


public class BaseListActivity extends BaseActivity<BaseListPresenter> implements BaseListContract.View {

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerBaseListComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .baseListModule(new BaseListModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_base_list; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        ArmsUtils.snackbarText(message);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        ArmsUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {
        finish();
    }
}
