package me.codetalk.uilayouttest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLinear = (Button)findViewById(R.id.btn_linear);
        btnLinear.setOnClickListener(this);

        Button btnRelP = (Button)findViewById(R.id.btn_relative_p);
        btnRelP.setOnClickListener(this);

        Button btnRelC = (Button)findViewById(R.id.btn_relative_c);
        btnRelC.setOnClickListener(this);

        Button btnFrame = (Button)findViewById(R.id.btn_frame);
        btnFrame.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();
        if(viewId == R.id.btn_linear) {
            Intent intent = new Intent(MainActivity.this, LinearLayoutActivity.class);
            startActivity(intent);
        } else if(viewId == R.id.btn_relative_p) {
            Intent intent = new Intent(MainActivity.this, RelativeLayoutPActivity.class);
            startActivity(intent);
        } else if(viewId == R.id.btn_relative_c) {
            Intent intent = new Intent(MainActivity.this, RelativeLayoutCActivity.class);
            startActivity(intent);
        } else if(viewId == R.id.btn_frame) {
            Intent intent = new Intent(MainActivity.this, FrameLayoutActivity.class);
            startActivity(intent);
        }
    }
}
