package com.nettech.armsproject.di.component;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.nettech.armsproject.di.module.BaseListModule;

import com.jess.arms.di.scope.ActivityScope;
import com.nettech.armsproject.mvp.ui.activity.BaseListActivity;

@ActivityScope
@Component(modules = BaseListModule.class, dependencies = AppComponent.class)
public interface BaseListComponent {
    void inject(BaseListActivity activity);
}