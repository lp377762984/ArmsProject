package com.nettech.armsproject.mvp.contract;

import com.jess.arms.mvp.IView;
import com.jess.arms.mvp.IModel;
import com.nettech.armsproject.bean.Result;
import com.nettech.armsproject.bean.User;

import org.devio.takephoto.model.TImage;

import java.util.List;

import io.reactivex.Observable;


public interface UploadTestContract {
    //对于经常使用的关于UI的方法可以定义到IView中,如显示隐藏进度条,和显示文字消息
    interface View extends IView {

    }

    //Model层定义接口,外部只需关心Model返回的数据,无需关心内部细节,即是否使用缓存
    interface Model extends IModel {
        Observable<Result<User>> uploadFile(List<TImage> imgs);
        Observable<Result<User>> uploadSigleFile(TImage img);
    }
}
