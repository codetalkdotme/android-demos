package me.codetalk.imageuploadtest.api;

/**
 * Created by guobxu on 2017/12/23.
 */

public final class ApiUtils {

    public static <T> T getRestApi(Class<T> apiInterface) {
        return RetrofitClient.getClient(ApiConstants.BASE_URL).create(apiInterface);
    }


}