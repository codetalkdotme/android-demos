package com.example.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class YActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_y);

        // buton Y
        Button btny = (Button)findViewById(R.id.btn_y_ok);
        btny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("ret_data", "Hello FirstActivity from Y!");
                setResult(RESULT_OK, intent);

                finish();
            }
        });
    }
}
