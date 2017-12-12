package com.example.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "SecondActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        // intent extra
        Intent intent = getIntent();
        String data = intent.getStringExtra("extra_data");
        Log.i(TAG, data);

        Button button22 = (Button)findViewById(R.id.button_22);
        button22.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                EditText textfield = (EditText)findViewById(R.id.text_url);
                String url = textfield.getText().toString().trim();
                if(url.length() == 0) {
                    Toast.makeText(SecondActivity.this, "Please input a url!", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                }
            }

        });

        Button dialBtn = (Button)findViewById(R.id.btn_dial);
        dialBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
            }

        });

    }
}
