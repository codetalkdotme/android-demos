package me.codetalk.imageuploadtest;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import me.codetalk.imageuploadtest.api.ApiUtils;
import me.codetalk.imageuploadtest.api.FileUploadApi;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Multipart;

public class MainActivity extends AppCompatActivity {

    private static final int REQ_CODE_IMAGE = 1;  // image

    private static final int REQ_CODE_PERM_WRITE_EXTERNAL = 11;

    private static final String TAG = "MainActivity";

    TextView textFileUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Views
        Button btnUpload = findViewById(R.id.btn_upload);
        textFileUrl = findViewById(R.id.text_fileurl);

        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[] {
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
            }, REQ_CODE_PERM_WRITE_EXTERNAL);
        }

        btnUpload.setOnClickListener(view -> {
            Intent photoPickIntent = new Intent(Intent.ACTION_PICK);
            photoPickIntent.setType("image/*");
            startActivityForResult(photoPickIntent, REQ_CODE_IMAGE);
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch(requestCode) {
            case REQ_CODE_PERM_WRITE_EXTERNAL:
                if(grantResults.length > 0 && grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "App cannot work if not able to write external storage", Toast.LENGTH_SHORT).show();;
                    finish();
                }
                break;
            default:
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode != RESULT_OK) return;

        if(requestCode == REQ_CODE_IMAGE) {
            Uri selectedImage = data.getData();

            String filePath = getRealPathFromURI(selectedImage);
            File file = new File(filePath);
            RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
            MultipartBody.Part part = MultipartBody.Part.createFormData("file", file.getName(), requestFile);

            FileUploadApi uploadApi = ApiUtils.getRestApi(FileUploadApi.class);
            uploadApi.fileupload(7L, "6d3f517e-a421-45fc-b006-f413923cce0a", part).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                    .subscribe(rt -> {
                        if(rt.getRetCode() == 1) {
                            Map<String, Object> rtData = (Map<String, Object>)rt.getRetData();
                            String fileUrl = (String)rtData.get("file_url");
                            textFileUrl.setText(fileUrl);
                            Log.d(TAG, fileUrl);
                        } else {
                            Toast.makeText(this, rt.getRetMsg(), Toast.LENGTH_SHORT).show();
                        }
                    }, throwable -> {
                        throwable.printStackTrace();
                        Toast.makeText(this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
                    });;
        }
    }

    public String getRealPathFromURI(Uri contentUri) {
        Cursor cursor = null;
        try {
            String[] proj = { MediaStore.Images.Media.DATA };
            cursor = getContentResolver().query(contentUri,  proj, null, null, null);
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();

            return cursor.getString(column_index);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

}
