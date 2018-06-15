package com.nettech.armsproject.mvp.ui.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialog;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.utils.ArmsUtils;
import com.jess.arms.utils.DataHelper;
import com.nettech.armsproject.R;
import com.nettech.armsproject.di.component.DaggerUploadTestComponent;
import com.nettech.armsproject.di.module.UploadTestModule;
import com.nettech.armsproject.mvp.contract.UploadTestContract;
import com.nettech.armsproject.mvp.presenter.UploadTestPresenter;

import org.devio.takephoto.app.TakePhoto;
import org.devio.takephoto.app.TakePhotoActivity;
import org.devio.takephoto.app.TakePhotoImpl;
import org.devio.takephoto.compress.CompressConfig;
import org.devio.takephoto.model.CropOptions;
import org.devio.takephoto.model.InvokeParam;
import org.devio.takephoto.model.LubanOptions;
import org.devio.takephoto.model.TContextWrap;
import org.devio.takephoto.model.TResult;
import org.devio.takephoto.permission.InvokeListener;
import org.devio.takephoto.permission.PermissionManager;
import org.devio.takephoto.permission.TakePhotoInvocationHandler;
import org.simple.eventbus.Subscriber;

import java.io.File;

import timber.log.Timber;

import static com.jess.arms.utils.Preconditions.checkNotNull;

@ActivityScope
public class UploadTestActivity extends BaseActivity<UploadTestPresenter> implements UploadTestContract.View, TakePhoto.TakeResultListener, InvokeListener {
    private BottomSheetDialog dialog;
    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerUploadTestComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .uploadTestModule(new UploadTestModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_upload_test; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {
        dialog.dismiss();
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

    private TakePhoto takePhoto;
    private InvokeParam invokeParam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getTakePhoto().onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        getTakePhoto().onSaveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        getTakePhoto().onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionManager.TPermissionType type = PermissionManager.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionManager.handlePermissionsResult(this, type, invokeParam, this);
    }

    /**
     * 获取TakePhoto实例
     *
     * @return
     */
    public TakePhoto getTakePhoto() {
        if (takePhoto == null) {
            takePhoto = (TakePhoto) TakePhotoInvocationHandler.of(this).bind(new TakePhotoImpl(this, this));
        }
        return takePhoto;
    }

    @Override
    public void takeSuccess(TResult result) {
        Timber.i(TAG, "takeSuccess：%s", result.getImage().getCompressPath());
        //mPresenter.uploadFile(result.getImages());
        mPresenter.uploadFile(result.getImage());
    }

    @Override
    public void takeFail(TResult result, String msg) {
        Timber.i(TAG, "takeFail:%s", msg);
    }

    @Override
    public void takeCancel() {
        Log.d(TAG, "takeCancel: ");
    }

    @Override
    public PermissionManager.TPermissionType invoke(InvokeParam invokeParam) {
        PermissionManager.TPermissionType type = PermissionManager.checkPermission(TContextWrap.of(this), invokeParam.getMethod());
        if (PermissionManager.TPermissionType.WAIT.equals(type)) {
            this.invokeParam = invokeParam;
        }
        return type;
    }

    public void uploadFile(View view) {
        if (dialog==null){
            dialog = new BottomSheetDialog(this);
            dialog.setContentView(R.layout.layout_btm);
            File file = new File(DataHelper.getCacheFile(this), "/temp/" + System.currentTimeMillis() + ".jpg");
            Uri imageUri = Uri.fromFile(file);

            TextView camera=dialog.findViewById(R.id.textView);
            TextView gallery=dialog.findViewById(R.id.textView2);
            camera.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    configCompress();//选择前必须调用此方法否则会崩溃
                    takePhoto.onPickFromCaptureWithCrop(imageUri, new CropOptions.Builder().create());
                }
            });
            gallery.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    configCompress();
                    takePhoto.onPickMultipleWithCrop(1, new CropOptions.Builder().create());
                }
            });
        }
        dialog.show();
    }

    private void configCompress() {
        int maxSize = 1000 * 500;
        int width = 720;
        int height = 1280;
        LubanOptions option = new LubanOptions.Builder().setMaxHeight(height).setMaxWidth(width).setMaxSize(maxSize).create();
        CompressConfig config = CompressConfig.ofLuban(option);
        takePhoto.onEnableCompress(config, false);
    }

    // TODO: 2018/6/15  参数如何缓存
    @Subscriber
    private void reDoRequest(int what){

    }
}
