package com.nettech.armsproject.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

import com.nettech.armsproject.mvp.contract.BaseListContract;
import com.nettech.armsproject.mvp.model.BaseListModel;


@Module
public class BaseListModule {
    private BaseListContract.View view;

    /**
     * 构建BaseListModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public BaseListModule(BaseListContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    BaseListContract.View provideBaseListView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    BaseListContract.Model provideBaseListModel(BaseListModel model) {
        return model;
    }
}