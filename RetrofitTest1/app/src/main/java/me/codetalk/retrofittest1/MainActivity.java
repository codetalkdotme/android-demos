package me.codetalk.retrofittest1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import me.codetalk.retrofittest1.adapter.PostAdapter;
import me.codetalk.retrofittest1.api.ApiUtils;
import me.codetalk.retrofittest1.api.PostService;
import me.codetalk.retrofittest1.api.entity.PostData;
import me.codetalk.retrofittest1.api.response.PostListResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private RecyclerView postListView;

    private PostService postService;

    private PostAdapter postAdapter;

    // pagenation
    int page = 0;
    int count = 5;

    // action
    static final String ACTION_CREATE_POST = "me.codetalk.action.CREATE_POST";

    // request codes
    static final int REQ_NEW_POST_ID = 101; // newly created post ID

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        postService = ApiUtils.getPostService();
        postListView = findViewById(R.id.list_post);

        postAdapter = new PostAdapter(this, new ArrayList<PostData>(), new PostAdapter.PostItemListener() {
            @Override
            public void onPostClick(Long id) {
                Toast.makeText(MainActivity.this, "You clicked post id " + id, Toast.LENGTH_SHORT).show();
            }

        });
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        postListView.setLayoutManager(layoutManager);
        postListView.setAdapter(postAdapter);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        postListView.addItemDecoration(itemDecoration);

        loadPosts();
    }

    private void loadPosts() {
        Log.i(TAG, "Prepare to call postService.listPost...");

        postService.listPost(page * count, count).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(postListResp -> {
                    postAdapter.updatePosts(postListResp.getPostList());
                }, throwable -> {
                    throwable.printStackTrace();
                    Toast.makeText(MainActivity.this, "Load posts failed!", Toast.LENGTH_SHORT).show();
                });

//        postService.listPost(page * count, count).enqueue(new Callback<PostListResponse>() {
//            @Override
//            public void onResponse(Call<PostListResponse> call, Response<PostListResponse> response) {
//                if(response.isSuccessful()) {
//                    postAdapter.updatePosts(response.body().getPostList());
//                } else {
//                    int statusCode  = response.code();
//                    Toast.makeText(MainActivity.this, "Load posts failed! Status code = " + statusCode, Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<PostListResponse> call, Throwable t) {
//                t.printStackTrace();
//                Toast.makeText(MainActivity.this, "Load posts failed!", Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_post_list, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if(itemId == R.id.item_create_post) {
            Intent intent = new Intent(ACTION_CREATE_POST);
            startActivityForResult(intent, REQ_NEW_POST_ID);
        }

        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQ_NEW_POST_ID) {
            if(resultCode == RESULT_OK) {
                loadPosts();
            }
        }
    }
}










