package com.nettech.armsproject.mvp.presenter;

import android.annotation.SuppressLint;
import android.app.Application;
import android.support.annotation.NonNull;
import android.util.Log;

import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.http.imageloader.ImageLoader;
import com.jess.arms.integration.AppManager;
import com.jess.arms.utils.ArmsUtils;
import com.nettech.armsproject.bean.Result;
import com.nettech.armsproject.bean.User;
import com.nettech.armsproject.config.DefaultHandleSubscriber;
import com.nettech.armsproject.mvp.BBasePresenter;
import com.nettech.armsproject.mvp.contract.UploadTestContract;

import org.devio.takephoto.model.TImage;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import me.jessyan.progressmanager.ProgressListener;
import me.jessyan.progressmanager.ProgressManager;
import me.jessyan.progressmanager.body.ProgressInfo;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import timber.log.Timber;


@ActivityScope
public class UploadTestPresenter extends BBasePresenter<UploadTestContract.Model, UploadTestContract.View> {
    private ProgressInfo mLastUploadingingInfo;
    @Inject
    RxErrorHandler mErrorHandler;
    @Inject
    Application mApplication;
    @Inject
    ImageLoader mImageLoader;
    @Inject
    AppManager mAppManager;

    @Inject
    public UploadTestPresenter(UploadTestContract.Model model, UploadTestContract.View rootView) {
        super(model, rootView);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mErrorHandler = null;
        this.mAppManager = null;
        this.mImageLoader = null;
        this.mApplication = null;
    }

    public void uploadFile(List<TImage> images) {
        mModel.uploadFile(images)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DefaultHandleSubscriber<Result<User>>(mErrorHandler) {
                    @Override
                    public void onNext(Result<User> userResult) {
                        super.onNext(userResult);
                    }
                }.setHandler(this));
    }

    public void uploadFile(TImage images) {
        ProgressManager.getInstance().addRequestListener("http://app.qlqwgw.com/user/set", getUploadListener());
        mModel.uploadSigleFile(images)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally(() -> mRootView.hideLoading())
                .subscribe(new DefaultHandleSubscriber<Result<User>>(mErrorHandler) {
                    @Override
                    public void onNext(Result<User> userResult) {
                        super.onNext(userResult);
                    }
                }.setHandler(this).setWhat(2));
    }

    @Override
    public <T> void handle200(int what, Result<T> result) {
        super.handle200(what, result);
        if (what==2){
            mRootView.showMessage(result.msg);
        }
    }

    @NonNull
    private ProgressListener getUploadListener() {
        return new ProgressListener() {
            @SuppressLint("TimberArgCount")
            @Override
            public void onProgress(ProgressInfo progressInfo) {
                // 如果你不屏蔽用户重复点击上传或下载按钮,就可能存在同一个 Url 地址,上一次的上传或下载操作都还没结束,
                // 又开始了新的上传或下载操作,那现在就需要用到 id(请求开始时的时间) 来区分正在执行的进度信息
                // 这里我就取最新的上传进度用来展示,顺便展示下 id 的用法

                Timber.d("--Upload-- " + progressInfo.getPercent() + " %  " + progressInfo.getSpeed() + " byte/s  " + progressInfo.toString());

                if (mLastUploadingingInfo == null) {
                    mLastUploadingingInfo = progressInfo;
                }

                //因为是以请求开始时的时间作为 Id ,所以值越大,说明该请求越新
                if (progressInfo.getId() < mLastUploadingingInfo.getId()) {
                    return;
                } else if (progressInfo.getId() > mLastUploadingingInfo.getId()) {
                    mLastUploadingingInfo = progressInfo;
                }

                int progress = mLastUploadingingInfo.getPercent();
                //mUploadProgress.setProgress(progress);
                //mUploadProgressText.setText(progress + "%");
                //Log.d(TAG, "--Upload-- " + progress + " %  " + mLastUploadingingInfo.getSpeed() + " byte/s  " + mLastUploadingingInfo.toString());
                if (mLastUploadingingInfo.isFinish()) {
                    //说明已经上传完成
                    Timber.d("--Upload-- finish");
                }
            }

            @Override
            public void onError(long id, Exception e) {
//                mHandler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        mUploadProgress.setProgress(0);
//                        mUploadProgressText.setText("error");
//                    }
//                });
            }
        };
    }

}
