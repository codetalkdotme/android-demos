package me.codetalk.uiwidgettest;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";

    private EditText editText = null;

    private ImageView imageView = null;

    private ProgressBar progressBar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // btn1
        Button btn1 = (Button)findViewById(R.id.btn_1);
        btn1.setOnClickListener(this);

        // Edit Text
        editText = findViewById(R.id.edit_1);

        // Image View
        imageView = findViewById(R.id.imageview_1);
        imageView.setImageResource(R.drawable.img_2);

        // Progress Bar
        progressBar = (ProgressBar)findViewById(R.id.progress_bar_1);

        // btn toggle progress bar
        Button btnTogbar = (Button)findViewById(R.id.btn_toggle_bar);
        btnTogbar.setOnClickListener(this);

        // btn show alert
        Button btnAlert = (Button)findViewById(R.id.btn_show_alert);
        btnAlert.setOnClickListener(this);

        // btn show progress dialog
        Button btnPrgDialog = (Button)findViewById(R.id.btn_show_progress_dialog);
        btnPrgDialog.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();
        if(viewId == R.id.btn_1) {
            String text = editText.getText().toString();

            Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
        } else if(viewId == R.id.btn_toggle_bar) {
//            if(progressBar.getVisibility() == View.GONE) {
//                progressBar.setVisibility(View.VISIBLE);
//            } else {
//                progressBar.setVisibility(View.GONE);
//            }
            int progress = progressBar.getProgress();
            progress += 10;
            progressBar.setProgress(progress);
        } else if(viewId == R.id.btn_show_alert) {
            AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
            dialog.setTitle("This is a dialog");
            dialog.setMessage("Something important!");
            dialog.setCancelable(false);
            dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Log.i(TAG, "Clicked ok, i = " + i);
                }
            });
            dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Log.i(TAG, "Clicked cancel, i = " + i);
                }
            });

            dialog.show();
        } else if(viewId == R.id.btn_show_progress_dialog) {
            ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setTitle("This is progress dialog");
            progressDialog.setMessage("Loading...");
            progressDialog.setCancelable(true);
            progressDialog.show();
        }
    }
}
