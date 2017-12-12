package com.example.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    static final int REQ_CODE_X = 101;
    static final int REQ_CODE_Y = 102;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.first_layout);

        // Toast
        Button button1 = (Button)findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FirstActivity.this, "You clicked Button 1", Toast.LENGTH_SHORT)
                        .show();
//                finish();
            }
        });

        // Intent
        Button button2 = (Button)findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                intent.putExtra("extra_data", "Hello SecondActivity!");

                startActivity(intent);
            }
        });

        // Implicit Intent
        Button button3 = (Button)findViewById(R.id.button_3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.activitytest.ACTION_START");
                intent.addCategory("com.example.activitytest.MY_CATEGORY");
                startActivity(intent);
            }
        });

        // start activity for result
        Button btnForRt = (Button)findViewById(R.id.btn_act_for_result);
        btnForRt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.activitytest.ACTION_START");
                intent.addCategory("com.example.activitytest.MY_CATEGORY");
                startActivity(intent);
            }
        });

        // buton X
        Button btnx = (Button)findViewById(R.id.btn_x);
        btnx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.activitytest.ACTION_START");
                intent.addCategory("com.example.activitytest.MY_CATEGORY_X");
                startActivityForResult(intent, REQ_CODE_X);
            }
        });

        // buton Y
        Button btny = (Button)findViewById(R.id.btn_y);
        btny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.activitytest.ACTION_START");
                intent.addCategory("com.example.activitytest.MY_CATEGORY_Y");
                startActivityForResult(intent, REQ_CODE_Y);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case REQ_CODE_X:
                if(resultCode == RESULT_OK) {
                    String rtData = data.getStringExtra("ret_data");
                    Toast.makeText(FirstActivity.this, rtData, Toast.LENGTH_SHORT).show();
                }
                break;
            case REQ_CODE_Y:
                if(resultCode == RESULT_OK) {
                    String rtData = data.getStringExtra("ret_data");
                    Toast.makeText(FirstActivity.this, rtData, Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }

    // Main menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(FirstActivity.this, "You clicked Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(FirstActivity.this, "You clicked Remove", Toast.LENGTH_SHORT).show();
                break;
            default:
        }

        return true;
    }


}
