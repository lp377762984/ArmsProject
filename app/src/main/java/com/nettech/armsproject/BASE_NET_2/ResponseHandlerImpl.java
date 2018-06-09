package com.nettech.armsproject.BASE_NET_2;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ASUS on 2018/4/1.
 */

public class ResponseHandlerImpl<T> implements HttpResponseHandler1<T>, Callback<T> {
    @Override
    public void handleException(Throwable t) {

    }

    @Override
    public void handle200(T result) {

    }

    @Override
    public void handleExcept200(String string) {

    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
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
    public void onFailure(Call<T> call, Throwable t) {
        handleException(t);
    }
}
