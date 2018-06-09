package com.nettech.armsproject.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

import com.nettech.armsproject.mvp.contract.TestReuseContract;
import com.nettech.armsproject.mvp.model.TestReuseModel;


@Module
public class TestReuseModule {
    private TestReuseContract.View view;

    /**
     * 构建TestReuseModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public TestReuseModule(TestReuseContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    TestReuseContract.View provideTestReuseView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    TestReuseContract.Model provideTestReuseModel(TestReuseModel model) {
        return model;
    }
}