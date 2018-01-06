package me.codetalk.imageuploadtest.api;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * Created by guobxu on 2018/1/6.
 */

public interface FileUploadApi {


    @Multipart
    @PUT("/flow/fnd/file/upload?pf_type=2")
    Observable<ObjectDataResponse> fileupload(@Query("user_id") Long userId, @Query("access_token") String accessToken,
                                    @Part MultipartBody.Part file);


}
