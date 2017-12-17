package me.codetalk.servicetest1;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MyService.DownloadBinder downloadBinder;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            downloadBinder = (MyService.DownloadBinder)iBinder;
            downloadBinder.startDownload();
            downloadBinder.getProgress();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnStart = findViewById(R.id.btn_start_service);
        btnStart.setOnClickListener(this);
        Button btnStop = findViewById(R.id.btn_stop_service);
        btnStop.setOnClickListener(this);

        Button btnBind = findViewById(R.id.btn_bind_service);
        btnBind.setOnClickListener(this);
        Button btnUnbind = findViewById(R.id.btn_unbind_service);
        btnUnbind.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();
        if(viewId == R.id.btn_start_service) {
            Intent startIntent = new Intent(this, MyService.class);
            startService(startIntent);
        } else if(viewId == R.id.btn_stop_service) {
            Intent stopIntent = new Intent(this, MyService.class);
            stopService(stopIntent);
        } else if(viewId == R.id.btn_bind_service) {
            Intent bindIntent = new Intent(this, MyService.class);
            bindService(bindIntent, connection, BIND_AUTO_CREATE);
        } else if(viewId == R.id.btn_unbind_service) {
            unbindService(connection);
        }

    }
}
