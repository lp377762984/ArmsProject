package com.nettech.armsproject.mvp.presenter;

import com.jess.arms.mvp.IPresenter;

/**
 * Created by ASUS on 2018/6/6.
 */

public interface ListPresenter extends IPresenter {
    void getListData(int what,Long id);
}
