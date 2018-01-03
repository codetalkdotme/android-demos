package me.codetalk.activityfeaturetest.activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by guobxu on 3/1/2018.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import me.codetalk.activityfeaturetest.activity.annotation.ActivityFeature;


/**
 * Created by guobxu on 24/12/2017.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private static final String TAG = "BaseActivity";

    protected boolean hideActionBar = false;
    protected boolean hideStatusBar = false;
    protected boolean hideBottomNav = false;

    protected boolean isSticky = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // features
        ActivityFeature feature = getClass().getAnnotation(ActivityFeature.class);
        if(feature != null) setupFeature(feature);

        if(hideActionBar || hideStatusBar) {
            ActionBar actionBar = getSupportActionBar();
            if(actionBar != null) actionBar.hide();
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            int visibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            if(hideStatusBar) {
                visibility |= View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_FULLSCREEN;
            }
            if(hideBottomNav) {
                visibility |= View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
            }
            if(hideStatusBar || hideBottomNav) {
                visibility |= (isSticky ? View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY : View.SYSTEM_UI_FLAG_IMMERSIVE);
            }

            getWindow().getDecorView().setSystemUiVisibility(visibility);
        }
    }

    private void setupFeature(ActivityFeature feature) {
        int fval = feature.value();
        if( ( fval & ActivityFeature.HIDEACTIONBAR ) > 0) {
            hideActionBar = true;
        }
        if( ( fval & ActivityFeature.HIDESTATUS ) > 0) {
            hideStatusBar = true;
        }
        if( ( fval & ActivityFeature.HIDEBOTTOMNAV ) > 0) {
            hideBottomNav = true;
        }

        isSticky = feature.sticky();
    }

    protected int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }



}
