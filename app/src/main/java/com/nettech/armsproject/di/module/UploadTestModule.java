package com.nettech.armsproject.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

import com.nettech.armsproject.mvp.contract.UploadTestContract;
import com.nettech.armsproject.mvp.model.UploadTestModel;


@Module
public class UploadTestModule {
    private UploadTestContract.View view;

    /**
     * 构建UploadTestModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public UploadTestModule(UploadTestContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    UploadTestContract.View provideUploadTestView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    UploadTestContract.Model provideUploadTestModel(UploadTestModel model) {
        return model;
    }
}