package com.example.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class XActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_x);

        // buton X
        Button btnx = (Button)findViewById(R.id.btn_x_ok);
        btnx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("ret_data", "Hello FirstActivity from X!");
                setResult(RESULT_OK, intent);

                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("ret_data", "Hello FirstActivity from X!");
        setResult(RESULT_OK, intent);

        finish();
    }


}
