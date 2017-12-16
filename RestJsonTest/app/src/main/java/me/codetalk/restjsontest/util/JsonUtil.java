package me.codetalk.restjsontest.util;

import com.google.gson.Gson;

/**
 * Created by Administrator on 2017/12/15.
 */

public class JsonUtil {

    private static Gson gson = new Gson();

    public static String toJson(Object object) {

        return gson.toJson(object);
    }


}
