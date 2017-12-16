package me.codetalk.retrofittest1.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import me.codetalk.retrofittest1.api.entity.PostData;

/**
 * Created by Administrator on 2017/12/16.
 */

public class PostResponse extends BaseResponse {

    @JsonProperty("ret_data")
    private PostData post;

    public PostData getPost() {
        return post;
    }

    public void setPost(PostData post) {
        this.post = post;
    }
}
