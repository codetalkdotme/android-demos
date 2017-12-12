package me.codetalk.acitivitymodetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class StaFirstActivity extends AppCompatActivity {

    private static final String TAG = "StaFirstActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sta_first);

        Log.i(TAG, this.toString());

        // event
        Button btn1  = (Button)findViewById(R.id.sta_btn1);
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StaFirstActivity.this, StaFirstActivity.class);
                startActivity(intent);
            }
        });

        // event
        Button btn2  = (Button)findViewById(R.id.sta_btn2);
        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StaFirstActivity.this, StaSecondActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.i(TAG, this.toString());
    }
}
