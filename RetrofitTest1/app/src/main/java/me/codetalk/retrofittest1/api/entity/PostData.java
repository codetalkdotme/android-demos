package me.codetalk.retrofittest1.api.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/12/16.
 */

public class PostData extends PostBase {

    @JsonProperty("post_tags")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Tag> tags;

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

}
