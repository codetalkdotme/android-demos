package me.codetalk.retrofittest1.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import me.codetalk.retrofittest1.api.entity.Tag;

/**
 * Created by Administrator on 2017/12/15.
 */

public class TagDataResponse extends BaseResponse {

    @JsonProperty("ret_data")
    private List<Tag> tagList;

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }
}
