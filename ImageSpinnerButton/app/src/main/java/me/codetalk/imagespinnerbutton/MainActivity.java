package me.codetalk.imagespinnerbutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageSpinnerButton btn = findViewById(R.id.btn_img);
        Button testBtn = findViewById(R.id.test_btn);
        testBtn.setOnClickListener(view -> {
            boolean loading = btn.isLoading();
            btn.setLoading(!loading);
        });

    }
}
