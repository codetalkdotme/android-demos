package me.codetalk.acitivitymodetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class StaSecondActivity extends AppCompatActivity {

    private static final String TAG = "StaSecondActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sta_second);

        // event
        Button btn1  = (Button)findViewById(R.id.sta_second_btn1);
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StaSecondActivity.this, StaFirstActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i(TAG, this.toString());
    }
}
