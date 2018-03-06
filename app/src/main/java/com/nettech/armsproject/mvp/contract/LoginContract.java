package com.nettech.armsproject.mvp.contract;

import android.app.Activity;

import com.jess.arms.mvp.IModel;
import com.jess.arms.mvp.IView;
import com.nettech.armsproject.bean.LoginEntity;
import com.nettech.armsproject.bean.Result;
import com.nettech.armsproject.bean.User;

import io.reactivex.Observable;


public interface LoginContract {
    //对于经常使用的关于UI的方法可以定义到IView中,如显示隐藏进度条,和显示文字消息
    interface View extends IView {
        Activity getActivity();
        void sendCode(Result<User> results);
        void loginSuccess(Result<LoginEntity> results);
    }

    //Model层定义接口,外部只需关心Model返回的数据,无需关心内部细节,即是否使用缓存
    interface Model extends IModel {
        Observable<Result<User>> sendMCode(String phone);
        Observable<Result<LoginEntity>> login(String phone, String code);
    }
}
