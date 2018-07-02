package com.nettech.armsproject.mvp.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.nettech.armsproject.R;
import com.nettech.armsproject.bean.D;
import com.nettech.armsproject.bean.E;

public class TestEventBusActivity extends AppCompatActivity {
    private D d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_event_bus);
        d=new D(new E());
        d.register();
    }

    public void postEvent(View view) {
        d.postThings();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        d.unRegister();
    }
}
