package me.codetalk.acitivitymodetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class StoFirstActivity extends AppCompatActivity {

    private static final String TAG = "StoFirstActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sto_first);

        Log.i(TAG, this.toString());

        // event
        Button btn1  = (Button)findViewById(R.id.sto_btn1);
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StoFirstActivity.this, StoFirstActivity.class);
                startActivity(intent);
            }
        });

        // event
        Button btn2  = (Button)findViewById(R.id.sto_btn2);
        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StoFirstActivity.this, StoSecondActivity.class);
                startActivity(intent);
            }
        });

    }
}
