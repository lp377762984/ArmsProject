package com.nettech.armsproject.mvp.ui.activity;

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
import com.jess.arms.utils.ArmsUtils;
import com.nettech.armsproject.R;
import com.nettech.armsproject.TestAdapter;
import com.nettech.armsproject.bean.QuestionBean;
import com.nettech.armsproject.di.component.DaggerTestReuseComponent;
import com.nettech.armsproject.di.module.TestReuseModule;
import com.nettech.armsproject.mvp.contract.TestReuseContract;
import com.nettech.armsproject.mvp.presenter.TestReusePresenter;
import com.nettech.armsproject.view.CustomLoadMoreView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static com.jess.arms.utils.Preconditions.checkNotNull;


public class TestReuseActivity extends BaseActivity<TestReusePresenter> implements TestReuseContract.View {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout refreshLayout;
    private List<QuestionBean> data = new ArrayList<>();
    private boolean isRefresh = true;
    private boolean isComplete;
    private TestAdapter adapter;

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerTestReuseComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .testReuseModule(new TestReuseModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_test_reuse; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
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
                mPresenter.getData(data.get(data.size() - 1).getId());
            }
        }, recyclerView);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                isRefresh = true;
                mPresenter.getData(null);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        mPresenter.getData(null);
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

    @Override
    public void showData(List<QuestionBean> msgs) {
        if (msgs == null || msgs.size() < 6) isComplete = true;
        if (isRefresh) {
            Log.d(TAG, "showData: refresh complete");
            data.clear();
            if (msgs != null){
                data.addAll(msgs);
                adapter.notifyDataSetChanged();
            }
        } else {
            Log.d(TAG, "showData: load more");
            int beforeSize = data.size();
            if (msgs != null){
                data.addAll(msgs);
                adapter.notifyItemRangeInserted(beforeSize, msgs.size());
            }
        }
    }
}
