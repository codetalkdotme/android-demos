package me.codetalk.activityfeaturetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import me.codetalk.activityfeaturetest.activity.Activity1;
import me.codetalk.activityfeaturetest.activity.Activity2;
import me.codetalk.activityfeaturetest.activity.Activity3;
import me.codetalk.activityfeaturetest.activity.Activity4;
import me.codetalk.activityfeaturetest.activity.Activity5;
import me.codetalk.activityfeaturetest.activity.Activity6;
import me.codetalk.activityfeaturetest.activity.NormalActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_normal).setOnClickListener(this);
        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);
        findViewById(R.id.btn5).setOnClickListener(this);
        findViewById(R.id.btn6).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Class target = null;
        switch(view.getId()) {
            case R.id.btn_normal:
                target = NormalActivity.class;
                break;
            case R.id.btn1:
                target = Activity1.class;
                break;
            case R.id.btn2:
                target = Activity2.class;
                break;
            case R.id.btn3:
                target = Activity3.class;
                break;
            case R.id.btn4:
                target = Activity4.class;
                break;
            case R.id.btn5:
                target = Activity5.class;
                break;
            case R.id.btn6:
                target = Activity6.class;
                break;
        }

        Intent intent = new Intent(this, target);
        startActivity(intent);
    }
}
