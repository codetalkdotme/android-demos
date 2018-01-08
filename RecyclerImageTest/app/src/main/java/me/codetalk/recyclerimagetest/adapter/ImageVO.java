package me.codetalk.recyclerimagetest.adapter;

import android.net.Uri;

/**
 * Created by guobxu on 2018/1/8.
 */

public class ImageVO {

    private Uri uri;
    private String filePath;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }



}
