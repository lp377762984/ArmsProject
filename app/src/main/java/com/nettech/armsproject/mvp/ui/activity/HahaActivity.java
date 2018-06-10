package com.nettech.armsproject.mvp.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.jess.arms.di.component.AppComponent;
import com.nettech.armsproject.R;
import com.nettech.armsproject.di.component.DaggerHahaComponent;
import com.nettech.armsproject.di.module.HahaModule;
import com.nettech.armsproject.mvp.base.BaseListActivity;
import com.nettech.armsproject.mvp.presenter.HahaPresenter;


public class HahaActivity extends BaseListActivity<HahaPresenter> {

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerHahaComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .hahaModule(new HahaModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_haha; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

    }
}
