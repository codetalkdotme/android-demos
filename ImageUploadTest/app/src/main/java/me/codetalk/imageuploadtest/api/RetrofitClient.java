package me.codetalk.imageuploadtest.api;

import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by guobxu on 2017/12/15.
 */

public final class RetrofitClient {

    private static Retrofit client = null;

    private static final long TIMEOUT = 10L; // seconds

    private static final long KEEP_ALIVE_DURATION = 60 * 1000; // 60 seconds

    private static final String TAG = "RetrofitClient";

    public static Retrofit getClient(String baseUrl) {
        if(client == null) {
            client = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(createOkHttpClient())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(JacksonConverterFactory.create())
                    .build();
        }

        return client;
    }

    private static OkHttpClient createOkHttpClient() {
        System.setProperty("http.keepAlive", "true");
        System.setProperty("http.keepAliveDuration", String.valueOf(KEEP_ALIVE_DURATION));

        return new OkHttpClient.Builder()
                        .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                        .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
                        .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                        .build();
    }



}
