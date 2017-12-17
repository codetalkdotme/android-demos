package me.codetalk.androidthreadtest1.task;

import android.os.AsyncTask;
import android.os.Environment;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

import me.codetalk.androidthreadtest1.DownloadListener;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/12/17.
 */

public class DownloadTask extends AsyncTask<String, Integer, Integer> {

    static final int TYPE_SUCCESS = 1;
    static final int TYPE_FAILED = 2;
    static final int TYPE_PAUSED = 3;
    static final int TYPE_CANCELED = 4;

    private boolean isCanceled = false;
    private boolean isPaused = false;

    private int lastProgress;

    private DownloadListener listener;

    public DownloadTask(DownloadListener listener) {
        this.listener = listener;
    }

    @Override
    protected Integer doInBackground(String... params) {
        InputStream in = null;
        RandomAccessFile savedFile = null;
        File file = null;
        try {
            long downloadedLen = 0; // already downloaded
            String downloadUrl = params[0];

            String filename = downloadUrl.substring(downloadUrl.lastIndexOf("/"));
            String dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
            file = new File(dir + filename);
            if(file.exists()) {
                downloadedLen = file.length();
            }

            long contentLen = getContentLength(downloadUrl);
            if(contentLen == 0) {
                return TYPE_FAILED;
            } else if(contentLen == downloadedLen){
                return TYPE_SUCCESS;
            }

            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().addHeader("RANGE","bytes=" + downloadedLen + "-")
                    .url(downloadUrl).build();
            Response response = client.newCall(request).execute();
            if(response != null) {
                in = response.body().byteStream();
                savedFile = new RandomAccessFile(file, "rw");
                savedFile.seek(downloadedLen);

                byte[] b = new byte[4096];
                int total = 0, len = -1;
                while((len = in.read(b)) != -1) {
                    if(isCanceled) {
                        return TYPE_CANCELED;
                    } else if(isPaused) {
                        return TYPE_PAUSED;
                    } else {
                        total += len;
                        savedFile.write(b, 0, len);

                        // progress
                        int progress = (int)((total + downloadedLen) * 100 / contentLen);
                        publishProgress(progress);
                    }
                }

                response.body().close();
                return TYPE_SUCCESS;
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (in != null) in.close();
                if (savedFile != null) savedFile.close();
            }catch(Exception ex) {
                ex.printStackTrace();
            }
        }

        return TYPE_FAILED;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        int progress = values[0];

        if(progress > lastProgress) {
            listener.onProgress(progress);
            lastProgress = progress;
        }
    }

    @Override
    protected void onPostExecute(Integer status) {
        switch (status) {
            case TYPE_SUCCESS:
                listener.onSuccess();
                break;
            case TYPE_FAILED:
                listener.onFailed();
                break;
            case TYPE_PAUSED:
                listener.onPaused();
                break;
            case TYPE_CANCELED:
                listener.onCanceled();
                break;
            default:
                break;
        }

    }

    public void pauseDownload() {
        isPaused = true;
    }

    public void cancelDownload() {
        isCanceled = true;
    }

    private long getContentLength(String downloadUrl) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(downloadUrl).build();
        Response response = client.newCall(request).execute();

        if(response != null && response.isSuccessful()) {
            long contentLen = response.body().contentLength();
            response.close();

            return contentLen;
        }

        return 0;
    }


}
