package me.codetalk.retrofittest1.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import me.codetalk.retrofittest1.api.entity.PostData;

/**
 * Created by Administrator on 2017/12/15.
 */

public class PostListResponse extends BaseResponse {

    @JsonProperty("ret_data")
    private List<PostData> postList;

    public List<PostData> getPostList() {
        return postList;
    }

    public void setPostList(List<PostData> postList) {
        this.postList = postList;
    }

}

