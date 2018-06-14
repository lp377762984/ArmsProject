package com.nettech.armsproject.di.component;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.nettech.armsproject.di.module.UploadTestModule;

import com.jess.arms.di.scope.ActivityScope;
import com.nettech.armsproject.mvp.ui.activity.UploadTestActivity;

@ActivityScope
@Component(modules = UploadTestModule.class, dependencies = AppComponent.class)
public interface UploadTestComponent {
    void inject(UploadTestActivity activity);
}