package me.codetalk.numberpickertest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements NumberPicker.OnValueChangeListener{

    TextView textDuration;

    NumberPicker dayPicker;
    NumberPicker hourPicker;
    NumberPicker minPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton btn = findViewById(R.id.btn_show_picker);

        // pickers
        dayPicker = findViewById(R.id.picker_day);
        hourPicker = findViewById(R.id.picker_hour);
        minPicker = findViewById(R.id.picker_min);

        dayPicker.setMinValue(0);
        dayPicker.setMaxValue(6);

        hourPicker.setMinValue(0);
        hourPicker.setMaxValue(23);

        minPicker.setMinValue(0);
        minPicker.setMaxValue(59);

        dayPicker.setOnValueChangedListener(this);
        hourPicker.setOnValueChangedListener(this);
        minPicker.setOnValueChangedListener(this);

        // text
        textDuration = findViewById(R.id.text_duration);
        setDuration();

        LinearLayout layoutPickers = findViewById(R.id.layout_picker_container);
        btn.setOnClickListener(view -> {
            if(layoutPickers.getVisibility() == View.GONE) {
                btn.animate().rotation(btn.getRotation() + 180F).setInterpolator(new AccelerateDecelerateInterpolator());
                layoutPickers.setVisibility(View.VISIBLE);
            } else {
                btn.animate().rotation(btn.getRotation() - 180F).setInterpolator(new AccelerateDecelerateInterpolator());
                layoutPickers.setVisibility(View.GONE);
            }

        });

    }

    private void setDuration() {
        int day = dayPicker.getValue(), hour = hourPicker.getValue(), min = minPicker.getValue();
        String text = String.format("%s天%s时%s分", day, hour, min);

        textDuration.setText(text);
    }

    @Override
    public void onValueChange(NumberPicker numberPicker, int i, int i1) {
        setDuration();
    }

}
