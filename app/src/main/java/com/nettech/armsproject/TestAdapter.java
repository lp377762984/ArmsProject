package com.nettech.armsproject;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.nettech.armsproject.bean.QuestionBean;

import java.util.List;

/**
 * Created by ASUS on 2018/6/5.
 */

public class TestAdapter extends BaseQuickAdapter<QuestionBean, BaseViewHolder> {
    public TestAdapter(int layoutResId, @Nullable List<QuestionBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, QuestionBean item) {
        helper.setText(R.id.tv_title, item.getTitle());
    }
}
