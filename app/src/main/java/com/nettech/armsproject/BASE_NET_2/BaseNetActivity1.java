package com.nettech.armsproject.BASE_NET_2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.nettech.armsproject.base_net.HttpResponseHandler;
import com.nettech.armsproject.base_net.NetworkManager;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BaseNetActivity1 extends AppCompatActivity {
    private NetworkManager networkManager = new NetworkManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public <T> void doNetwork(Call<T> call,ResponseHandlerImpl<T> responseHandler) {
        networkManager.addCallToQueue(call,responseHandler );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        networkManager.destroyCall();
    }

}
