package me.codetalk.designsupporttest;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnText = findViewById(R.id.btn_text);
        btnText.setOnClickListener(this);

        Button btnFab = findViewById(R.id.btn_floating_action_btn);
        btnFab.setOnClickListener(this);

        Button btnTabLayout = findViewById(R.id.btn_tablayout);
        btnTabLayout.setOnClickListener(this);

        Button btnSnackbar = findViewById(R.id.btn_snackbar_act);
        btnSnackbar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btn_text:
                Intent textInputIntent = new Intent(this, TextInputActivity.class);
                startActivity(textInputIntent);
                break;
            case R.id.btn_floating_action_btn:
                Intent fabIntent = new Intent(this, FloatingActionButtonActivity.class);
                startActivity(fabIntent);
                break;
            case R.id.btn_tablayout:
                Intent tabIntent = new Intent(this, TabLayoutActivity.class);
                startActivity(tabIntent);
                break;
            case R.id.btn_snackbar_act:
                Intent snackIntent = new Intent(this, SnackbarActivity.class);
                startActivity(snackIntent);
                break;
        }
    }
}
