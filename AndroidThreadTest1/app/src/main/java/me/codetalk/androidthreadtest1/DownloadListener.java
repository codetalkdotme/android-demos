package me.codetalk.androidthreadtest1;

/**
 * Created by Administrator on 2017/12/17.
 */

public interface DownloadListener {

    public void onProgress(int progress);

    public void onSuccess();

    public void onFailed();

    public void onPaused();

    public void onCanceled();

}
