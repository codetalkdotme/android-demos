package me.codetalk.designsupporttest;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SnackbarActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "SnackbarActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snackbar);

        Button btn = findViewById(R.id.btn_snackbar);
        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btn_snackbar:
                Snackbar.make(view, "Action", Snackbar.LENGTH_LONG).setAction("Action!", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.i(TAG, "Action Done!");
                    }
                }).show();
                break;
        }
    }
}
