package me.codetalk.retrofittest1.api.client;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by Administrator on 2017/12/15.
 */

public final class RetrofitClient {

    private static Retrofit client = null;

    public static Retrofit getClient(String baseUrl) {
        if(client == null) {
            client = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(JacksonConverterFactory.create())
                    .build();
        }

        return client;
    }


}
