package com.nettech.armsproject.mvp.ui.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.integration.lifecycle.Lifecycleable;
import com.jess.arms.utils.ArmsUtils;
import com.jess.arms.utils.RxLifecycleUtils;
import com.nettech.armsproject.R;
import com.nettech.armsproject.bean.LoginEntity;
import com.nettech.armsproject.bean.Resend;
import com.nettech.armsproject.bean.Result;
import com.nettech.armsproject.bean.User;
import com.nettech.armsproject.config.AppConfig;
import com.nettech.armsproject.di.component.DaggerLoginComponent;
import com.nettech.armsproject.di.module.LoginModule;
import com.nettech.armsproject.mvp.contract.LoginContract;
import com.nettech.armsproject.mvp.presenter.LoginPresenter;
import com.nettech.armsproject.uitls.DialogUtils;
import com.nettech.armsproject.uitls.RegexUtils;

import org.simple.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

import static com.jess.arms.utils.Preconditions.checkNotNull;


public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View, TextWatcher {
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
    private TextView aaa;
    @Inject
    LoginPresenter mPresenter;
    private Dialog progress;
    private static int CODE_TIME = 30;

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
        etCode.addTextChangedListener(this);
    }

    @Override
    public void showLoading() {
        if (progress == null) {
            progress = DialogUtils.createWaitDialog(this);
            progress.setCanceledOnTouchOutside(false);
            progress.setCancelable(false);
        }
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
        aaa.setText("hahha");
        ArmsUtils.makeText(this.getApplicationContext(), results.msg);
        etCode.requestFocus();
        etCode.setFocusable(true);
        Observable.interval(0, 1, TimeUnit.SECONDS)
                .compose(RxLifecycleUtils.bindToLifecycle((Lifecycleable) this))
                .subscribeOn(Schedulers.io())
                .take(CODE_TIME, TimeUnit.SECONDS)
                .doOnSubscribe(disposable -> tvSend.setEnabled(false))
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .map(aLong -> CODE_TIME - aLong)
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onNext(Long aLong) {
                        //Timber.d("%s", aLong);
                        tvSend.setText(aLong + "s后重新发送");
                    }

                    @Override
                    public void onError(Throwable e) {
                        tvSend.setEnabled(true);
                        tvSend.setText("获取验证码");
                    }

                    @Override
                    public void onComplete() {
                        tvSend.setEnabled(true);
                        tvSend.setText("获取验证码");
                    }
                });
    }

    @Override
    public void loginSuccess(Result<LoginEntity> results) {
        ArmsUtils.makeText(this.getApplicationContext(),results.msg);
        AppConfig.getInstance().putString("session_id",results.data.update_token.sessionId);
        AppConfig.getInstance().putString("access_token",results.data.update_token.accessToken);
        ArmsUtils.startActivity(UploadTestActivity.class);
        Resend resend= (Resend) getIntent().getSerializableExtra("reSend");
        if (resend!=null){
            EventBus.getDefault().post(resend);
        }
        /*int what = getIntent().getIntExtra("what", -1);
        if (what!=-1) EventBus.getDefault().post(what);*/
        finish();
    }

    @OnClick({R.id.login_time_tv,R.id.login_btn})
    public void sendCode(View view) {
        String s = etPhone.getText().toString();
        switch (view.getId()){
            case R.id.login_time_tv:
                if (checkError(s))
                    mPresenter.sendCode(s);
                break;
            case R.id.login_btn:
                mPresenter.login(s,etCode.getText().toString());
                break;
        }
    }

    public boolean checkError(String msg) {
        if (msg.length() != 0)
            if (RegexUtils.isMobilePhoneNum(msg)) return true;
             else ArmsUtils.makeText(this.getApplicationContext(), "输入不符合规范，请重新输入");
         else ArmsUtils.makeText(this.getApplicationContext(), "请输入11位手机号码");
        return false;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        loginBtn.setEnabled(s.length() > 0);
    }
}
