package me.codetalk.networktest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textResp;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSend = findViewById(R.id.btn_send_req);
        textResp = findViewById(R.id.text_response);

        btnSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_send_req) {
            sendRequestWithHttpUrlConnection();
        }
    }

    private void sendRequestWithHttpUrlConnection() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection conn = null;
                BufferedReader reader = null;
                try {
                    URL url = new URL("http://www.163.com/");
                    conn = (HttpURLConnection)url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.setConnectTimeout(8000);
                    conn.setReadTimeout(8000);

                    InputStream in = conn.getInputStream();
                    reader = new BufferedReader(new InputStreamReader(in));
                    StringBuffer resp = new StringBuffer();
                    String line = null;
                    while((line = reader.readLine()) != null) {
                        resp.append(line);
                    }
//                    Log.i(TAG, resp.toString());
                    showResponse(resp.toString());
                } catch (Exception ex) {
                    ex.printStackTrace();
                } finally {
                    if(reader != null) {
                        try {
                            reader.close();
                        } catch(IOException ioe) {
                            ioe.printStackTrace();
                        }
                    }

                    if(conn != null) {
                        conn.disconnect();
                    }
                }
            }
        }).start();
    }

    private void showResponse(final String response) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                textResp.setText(response);
            }
        });
    }

}
