package me.codetalk.retrofittest1.api;

import me.codetalk.retrofittest1.api.client.RetrofitClient;

/**
 * Created by Administrator on 2017/12/15.
 */

public class ApiUtils {

    public static PostService getPostService() {
        return RetrofitClient.getClient(Constants.BASE_URL).create(PostService.class);
    }


}
