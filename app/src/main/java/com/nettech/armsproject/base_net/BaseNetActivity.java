package com.nettech.armsproject.base_net;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BaseNetActivity extends AppCompatActivity
        implements Callback, HttpResponseHandler {
    private NetworkManager networkManager = new NetworkManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void doNetwork(Call call) {
        networkManager.addCallToQueue(call, this);
    }

    //retrofit
    @Override
    public void onResponse(Call call, Response response) {
        if (response.isSuccessful()) {
            handle200(response.body());
        } else {
            try {
                ResponseBody responseBody = response.errorBody();
                if (responseBody != null) {
                    handleExcept200(responseBody.string());
                }else {
                    handleExcept200(response.message());//?
                }
            } catch (IOException e) {
                handleException(e);
            }
        }
    }

    @Override
    public void onFailure(Call call, Throwable t) {
        handleException(t);
    }

    //mine
    @Override
    public void handleException(Throwable t) {

    }

    @Override
    public <S> void handle200(S data) {

    }

    @Override
    public void handleExcept200(String string) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        networkManager.destroyCall();
    }

}
