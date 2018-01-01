package me.codetalk.spinnerbuttontest.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import me.codetalk.spinnerbuttontest.R;

/**
 * Created by guobxu on 1/1/2018.
 */

public class SpinnerButton extends RelativeLayout {

    private Button actionButton;
    private String btnText;
    private ProgressBar spinner;

    private boolean enabled = true;

    public SpinnerButton(Context context) {
        super(context);
        init();
    }

    public SpinnerButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SpinnerButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.spinner_button, this);

        actionButton = findViewById(R.id.btn_action);
        btnText = actionButton.getText().toString();
        spinner = findViewById(R.id.spinner_loading);
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;

        if(enabled) {
            actionButton.setEnabled(true);
            actionButton.setText(btnText);
            spinner.setVisibility(View.GONE);
        } else {
            actionButton.setEnabled(false);
            actionButton.setText("");
            spinner.setVisibility(View.VISIBLE);
        }
    }

}
