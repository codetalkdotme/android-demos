package me.codetalk.spinnerbuttontest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import me.codetalk.spinnerbuttontest.custom.SpinnerButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn;
    private String btnText;
    private Button btnTest;
    private Button btnTest2;
    private ProgressBar btnLoading;

    private SpinnerButton spinnerButton;

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

        btnTest2 = findViewById(R.id.btn_test2);
        btnTest2.setOnClickListener(this);

        spinnerButton = findViewById(R.id.spinner_btn);
    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();
        if(viewId == R.id.btn_test) {
            if(btn.isEnabled()) {
                btn.setEnabled(false);
                btn.setText("");
                btnLoading.setVisibility(View.VISIBLE);
            } else {
                btn.setEnabled(true);
                btn.setText(btnText);
                btnLoading.setVisibility(View.GONE);
            }
        } else if(viewId == R.id.btn_test2) {
            if(spinnerButton.isEnabled()) {
                spinnerButton.setEnabled(false);
            } else {
                spinnerButton.setEnabled(true);
            }
        }
    }
}
