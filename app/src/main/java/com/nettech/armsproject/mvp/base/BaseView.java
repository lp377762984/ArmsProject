package com.nettech.armsproject.mvp.base;

import com.jess.arms.mvp.IView;

import java.util.List;

/**
 * Created by ASUS on 2018/6/6.
 */

public interface BaseView extends IView{
    void getData(int what,List data);
}
