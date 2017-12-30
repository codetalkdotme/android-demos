package me.codetalk.spinnerbuttontest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn;
    private String btnText;
    private Button btnTest;
    private ProgressBar btnLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Button
        btn = findViewById(R.id.btn1);
        btnText = btn.getText().toString();
        btnLoading = findViewById(R.id.btn_loading);

        btnTest = findViewById(R.id.btn_test);
        btnTest.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(btn.isEnabled()) {
            btn.setEnabled(false);
            btn.setText("");
            btnLoading.setVisibility(View.VISIBLE);
        } else {
            btn.setEnabled(true);
            btn.setText(btnText);
            btnLoading.setVisibility(View.GONE);
        }
    }
}
