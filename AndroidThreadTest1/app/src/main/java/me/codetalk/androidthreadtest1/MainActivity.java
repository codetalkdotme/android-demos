package me.codetalk.androidthreadtest1;

import android.Manifest;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.security.Permission;

import me.codetalk.androidthreadtest1.service.DownloadService;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textHello;

    private DownloadService.DownloadBinder downloadBinder;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            downloadBinder = (DownloadService.DownloadBinder)iBinder;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    // messages
    public static final int MSG_UPDATE_TEXT = 1;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if(msg.what == MSG_UPDATE_TEXT) {
                textHello.setText("Nice to meet you!");
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        textHello = findViewById(R.id.text_hello);
//        Button btnChangeTxt = findViewById(R.id.btn_change_txt);
//        btnChangeTxt.setOnClickListener(this);

        // Download
        Button btnStart = findViewById(R.id.btn_start_download),
                btnPause = findViewById(R.id.btn_pause_download),
                btnCancel = findViewById(R.id.btn_cancel_download);
        btnStart.setOnClickListener(this);
        btnPause.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

        // Service
        Intent intent = new Intent(this, DownloadService.class);
        startService(intent);
        bindService(intent, connection, BIND_AUTO_CREATE);
        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[] {
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
            }, 1);
        }

    }

    @Override
    public void onClick(View view) {
//        if(viewId == R.id.btn_change_txt) {
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    Message msg = new Message();
//                    msg.what = MSG_UPDATE_TEXT;
//                    handler.sendMessage(msg);
//                }
//            }).start();
//        }
        if(downloadBinder == null) return;

        switch (view.getId()) {
            case R.id.btn_start_download:
                String url = "https://raw.githubusercontent.com/guolindev/eclipse/master/eclipse-inst-win64.exe";
                downloadBinder.startDownload(url);
                break;
            case R.id.btn_pause_download:
                downloadBinder.pauseDownload();
                break;
            case R.id.btn_cancel_download:
                downloadBinder.cancelDownload();
                break;
            default:
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch(requestCode) {
            case 1:
                if(grantResults.length > 0 && grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "App cannot work if not able to write external storage", Toast.LENGTH_SHORT).show();;
                    finish();
                }
                break;
            default:
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        unbindService(connection);
    }
}
