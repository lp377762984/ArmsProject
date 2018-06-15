package com.nettech.armsproject.mvp.model;

import android.app.Application;

import com.google.gson.Gson;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import com.jess.arms.di.scope.ActivityScope;

import javax.inject.Inject;

import com.nettech.armsproject.bean.MObservable;
import com.nettech.armsproject.bean.Result;
import com.nettech.armsproject.bean.User;
import com.nettech.armsproject.http_services.HttpServices;
import com.nettech.armsproject.mvp.contract.UploadTestContract;

import org.devio.takephoto.model.TImage;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;


@ActivityScope
public class UploadTestModel extends BaseModel implements UploadTestContract.Model {
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public UploadTestModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

    @Override
    public Observable<Result<User>> uploadFile(List<TImage> imgs) {
        Map<String, RequestBody> map = new HashMap<>();
        for (TImage image : imgs) {
            File newFile = new File(image.getCompressPath());
            RequestBody requestBody =
                    RequestBody.create(MediaType.parse("multipart/form-data"), newFile);
            map.put(newFile.getName(), requestBody);
        }
        return mRepositoryManager.obtainRetrofitService(HttpServices.class).uploadFile("aaa",map );
    }

    @Override
    public Observable<Result<User>> uploadSigleFile(TImage img) {
        File file = new File(img.getCompressPath());
        RequestBody requestBody =
                RequestBody.create(MediaType.parse("image/jpeg"), file);//服务端只接受content_type
        /*RequestBody requestBody =
                RequestBody.create(MediaType.parse(""multipart/form-data"), file);*/
        MultipartBody.Part filePart = MultipartBody.Part.createFormData("avatar", file.getName(), requestBody);
        return mRepositoryManager.obtainRetrofitService(HttpServices.class).uploadSigleFile(filePart);
        //return mRepositoryManager.obtainRetrofitService(HttpServices.class).uploadSigleFile(requestBody);
        //return mRepositoryManager.obtainRetrofitService(HttpServices.class).uploadFileBody(requestBody);
    }
}