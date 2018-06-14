package com.nettech.armsproject.mvp.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.mvp.IPresenter;
import com.nettech.armsproject.R;
import com.nettech.armsproject.TestAdapter;
import com.nettech.armsproject.view.CustomLoadMoreView;

import java.util.ArrayList;
import java.util.List;

public class BaseListActivity<P extends IPresenter> extends BaseActivity<P> implements BaseView {
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
        adapter = new TestAdapter(R.layout.text, data);
        adapter.setEnableLoadMore(true);
        adapter.setLoadMoreView(new CustomLoadMoreView());
        adapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                isRefresh = false;
                pppp();
                //mPresenter.getData(data.get(data.size() - 1).getId());
            }
        }, recyclerView);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                isRefresh = true;
                pppp();
                //mPresenter.getData(null);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        pppp();
        //mPresenter.getData(null);
    }

    @Override
    public void getData(int what, List msgs) {
        if (data.size() < 6) isComplete = true;
        if (isRefresh) {
            data.clear();
            if (msgs != null){
                data.addAll(msgs);
                adapter.notifyDataSetChanged();
            }
        } else {
            int beforeSize = data.size();
            if (msgs != null){
                data.addAll(msgs);
                adapter.notifyItemRangeInserted(beforeSize, msgs.size());
            }
        }
    }

    @Override
    public void showLoading() {
        if (isRefresh) refreshLayout.setRefreshing(true);
        else {
            if (isComplete) adapter.loadMoreEnd();
            else adapter.loadMoreComplete();
        }
    }

    @Override
    public void hideLoading() {
        if (isRefresh) refreshLayout.setRefreshing(false);
        else {
            if (isComplete) adapter.loadMoreEnd();
            else adapter.loadMoreComplete();
        }
    }

    @Override
    public void showMessage(@NonNull String message) {

    }

    @Override
    public void launchActivity(@NonNull Intent intent) {

    }

    @Override
    public void killMyself() {

    }

    public void pppp(){

    }

    @Override
    public Activity getActivity() {
        return this;
    }
}
