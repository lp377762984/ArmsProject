package com.nettech.armsproject.mvp.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.mvp.IPresenter;

import java.util.ArrayList;
import java.util.List;

public class BBaseActivity<P extends IPresenter> extends BaseActivity<P> {
    protected BaseQuickAdapter adapter;
    protected List data= new ArrayList<>();
    protected SwipeRefreshLayout refreshLayout;
    protected RecyclerView recyclerView;
    protected boolean isRefresh = true;
    protected boolean isComplete;
    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {

    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return 0;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
    }
}
