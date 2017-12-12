package me.codetalk.acitivitymodetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SiFirstActivity extends AppCompatActivity {

    private static final String TAG = "SiFirstActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_si_first);

        Log.i(TAG, "Task id = [" + getTaskId() + "]");

        // event
        Button btn1  = (Button)findViewById(R.id.si_btn1);
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SiFirstActivity.this, SiSecondActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.i(TAG, "Task id = [" + getTaskId() + "]");
    }
}
