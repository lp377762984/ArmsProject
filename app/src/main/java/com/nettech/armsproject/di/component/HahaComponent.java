package com.nettech.armsproject.di.component;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.nettech.armsproject.di.module.HahaModule;

import com.jess.arms.di.scope.ActivityScope;
import com.nettech.armsproject.mvp.ui.activity.HahaActivity;

@ActivityScope
@Component(modules = HahaModule.class, dependencies = AppComponent.class)
public interface HahaComponent {
    void inject(HahaActivity activity);
}