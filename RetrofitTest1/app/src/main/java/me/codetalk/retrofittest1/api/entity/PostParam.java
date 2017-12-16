package me.codetalk.retrofittest1.api.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

/**
 * Created by Administrator on 2017/12/16.
 */

public class PostParam extends PostBase {

    @JsonProperty("post_tags")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Set<String> tags;

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }
}
