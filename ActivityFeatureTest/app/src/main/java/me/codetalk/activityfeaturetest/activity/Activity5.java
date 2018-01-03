package me.codetalk.activityfeaturetest.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import me.codetalk.activityfeaturetest.R;
import me.codetalk.activityfeaturetest.activity.annotation.ActivityFeature;

import static me.codetalk.activityfeaturetest.activity.annotation.ActivityFeature.HIDEBOTTOMNAV;
import static me.codetalk.activityfeaturetest.activity.annotation.ActivityFeature.HIDESTATUS;

@ActivityFeature(value= HIDEBOTTOMNAV)
public class Activity5 extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_6);
    }
}
