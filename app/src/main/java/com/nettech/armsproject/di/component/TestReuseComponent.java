package com.nettech.armsproject.di.component;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.nettech.armsproject.di.module.TestReuseModule;

import com.jess.arms.di.scope.ActivityScope;
import com.nettech.armsproject.mvp.ui.activity.TestReuseActivity;

@ActivityScope
@Component(modules = TestReuseModule.class, dependencies = AppComponent.class)
public interface TestReuseComponent {
    void inject(TestReuseActivity activity);
}