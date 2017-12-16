package me.codetalk.retrofittest1.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Administrator on 2017/12/15.
 */

public class ObjectDataResponse extends BaseResponse {

    @JsonProperty("ret_data")
    private Object retData; // object or list

    public Object getRetData() {
        return retData;
    }

    public void setRetData(Object retData) {
        this.retData = retData;
    }

}
