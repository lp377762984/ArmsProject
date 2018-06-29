package com.nettech.armsproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.nettech.armsproject.bean.A;
import com.nettech.armsproject.bean.B;
import com.nettech.armsproject.bean.C;

import org.simple.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class Test2Activity extends AppCompatActivity {
    private B b;
    private C c;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
        ButterKnife.bind(this);
        b = new B();
        c = new C();
    }

    @OnClick({R.id.btn_bind, R.id.btn_unbind, R.id.btn_post})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_bind:
                b.bind();
                break;
            case R.id.btn_unbind:
                b.unBind();
                break;
            case R.id.btn_post:
                c.postEvent(1);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
