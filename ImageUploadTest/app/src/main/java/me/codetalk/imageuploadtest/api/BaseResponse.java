package me.codetalk.imageuploadtest.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by guobxu on 2017/12/15.
 */

public class BaseResponse {

    @JsonProperty("ret_code")
    private Integer retCode;

    @JsonProperty("ret_msg")
    private String retMsg;

    public Integer getRetCode() {
        return retCode;
    }

    public void setRetCode(Integer retCode) {
        this.retCode = retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }
}
