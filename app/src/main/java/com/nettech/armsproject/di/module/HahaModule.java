package com.nettech.armsproject.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

import com.nettech.armsproject.mvp.base.BaseView;
import com.nettech.armsproject.mvp.contract.HahaContract;
import com.nettech.armsproject.mvp.model.HahaModel;


@Module
public class HahaModule {
    private BaseView view;

    /**
     * 构建HahaModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     */
    public HahaModule(BaseView view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    BaseView provideHahaView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    HahaContract.Model provideHahaModel(HahaModel model) {
        return model;
    }
}