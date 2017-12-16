package me.codetalk.retrofittest1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.codetalk.retrofittest1.adapter.TagAdapter;
import me.codetalk.retrofittest1.api.ApiUtils;
import me.codetalk.retrofittest1.api.PostService;
import me.codetalk.retrofittest1.api.entity.PostParam;
import me.codetalk.retrofittest1.api.response.BaseResponse;
import me.codetalk.retrofittest1.api.response.TagDataResponse;
import me.codetalk.retrofittest1.api.entity.Tag;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "PostActivity";

    private EditText inputContent;
    private EditText inputAuthor;
    private RecyclerView listTags;
    private Button btnPost;

    private TagAdapter tagAdapter;

    private Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        this.inputContent = findViewById(R.id.input_post_content);
        this.inputAuthor = findViewById(R.id.input_author);
        this.listTags = findViewById(R.id.list_tags);
        this.btnPost = findViewById(R.id.btn_create_post);
        this.btnPost.setOnClickListener(this);

        tagAdapter = new TagAdapter(this, new ArrayList<Tag>());
        this.listTags.setAdapter(tagAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        this.listTags.setLayoutManager(layoutManager);

        loadTags();
    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();
        if(viewId == R.id.btn_create_post) {
            PostService postSerivce = ApiUtils.getPostService();

            PostParam newPost = new PostParam();
            newPost.setId(rand.nextInt(10000) + 100L);
            newPost.setAuthor(inputAuthor.getText().toString());
            newPost.setContent(inputContent.getText().toString());
            newPost.setCreateDate(System.currentTimeMillis());

            newPost.setTags(tagAdapter.getSelectedTags());

            postSerivce.createPost(newPost).enqueue(new Callback<BaseResponse>() {
                @Override
                public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                    if(response.isSuccessful()) {
                        BaseResponse rt = response.body();
                        if(rt.getRetCode() == 1) {// return to post list
                            setResult(RESULT_OK);
                            finish();
                        } else {
                            Toast.makeText(PostActivity.this, rt.getRetMsg(), Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(PostActivity.this, "Error create post!", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<BaseResponse> call, Throwable t) {
                    Toast.makeText(PostActivity.this, "Error create post!", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void loadTags() {
        PostService postService = ApiUtils.getPostService();
        postService.listAllTags().enqueue(new Callback<TagDataResponse>() {
            @Override
            public void onResponse(Call<TagDataResponse> call, Response<TagDataResponse> response) {
                if(response.isSuccessful()) {
                    List<Tag> tagList = response.body().getTagList();
                    tagAdapter.updateTags(tagList);
                }
            }

            @Override
            public void onFailure(Call<TagDataResponse> call, Throwable t) {

            }
        });
    }

}
