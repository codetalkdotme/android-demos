package me.codetalk.retrofittest1.api;

import io.reactivex.Observable;
import me.codetalk.retrofittest1.api.entity.PostParam;
import me.codetalk.retrofittest1.api.response.PostListResponse;
import me.codetalk.retrofittest1.api.response.BaseResponse;
import me.codetalk.retrofittest1.api.response.TagDataResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2017/12/15.
 */

public interface PostService {

    @POST("/post/create")
    Observable<BaseResponse> createPost(@Body PostParam post);

    @GET("/post/list")
    Observable<PostListResponse> listPost(@Query("begin") Integer begin, @Query("count") Integer count);

    @GET("/tag/listall")
    Observable<TagDataResponse> listAllTags();

}
