package com.nettech.armsproject.mvp.ui.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import com.nettech.armsproject.bean.Result;
import com.nettech.armsproject.bean.User;
import com.nettech.armsproject.di.component.DaggerLoginComponent;
import com.nettech.armsproject.di.module.LoginModule;
import com.nettech.armsproject.mvp.contract.LoginContract;
import com.nettech.armsproject.mvp.presenter.LoginPresenter;

import com.nettech.armsproject.R;
import com.nettech.armsproject.uitls.RegexUtils;


import java.io.IOException;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import timber.log.Timber;

import static com.jess.arms.utils.Preconditions.checkNotNull;


public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View {
    @BindView(R.id.login_iv_avatar)
    ImageView userHead;
    @BindView(R.id.login_et_number)
    EditText etPhone;
    @BindView(R.id.login_et_code)
    EditText etCode;
    @BindView(R.id.login_btn)
    Button loginBtn;
    @BindView(R.id.login_time_tv)
    TextView tvSend;
    @Inject
    LoginPresenter mPresenter;
    private ProgressDialog progress;

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerLoginComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .loginModule(new LoginModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_login; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

    }

    @Override
    public void showLoading() {
        if (progress == null){
            progress = new ProgressDialog(this);
            progress.setCanceledOnTouchOutside(false);
            progress.setCancelable(false);
        }
        else
        progress.show();
    }

    @Override
    public void hideLoading() {
        if (progress != null && progress.isShowing()) progress.dismiss();
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
    public Activity getActivity() {
        return this;
    }

    @Override
    public void sendCode(Result<User> results) {
        ArmsUtils.makeText(this, results.toString());
    }

    @Override
    public boolean phoneError(String msg) {
        if (msg.length() != 0) {//没输入的情况下
            if (RegexUtils.isMobilePhoneNum(msg)) {
                return true;
            } else {
                ArmsUtils.makeText(this, "输入不符合规范，请重新输入");
            }
        } else {
            ArmsUtils.makeText(this, "请输入11位手机号码");
        }
        return false;
    }

    @OnClick(R.id.login_time_tv)
    public void sendCode(View view) {
        mPresenter.sendCode(etPhone.getText().toString());
    }
}
