package me.codetalk.acitivitymodetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SFirstActivity extends AppCompatActivity {

    private static final String TAG = "SFirstActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sfirst);

        Log.i(TAG, this.toString());

        // event
        Button sbtn1  = (Button)findViewById(R.id.s_btn_1);
        sbtn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SFirstActivity.this, SFirstActivity.class);
                startActivity(intent);
            }
        });
    }
}
