package me.codetalk.activityfeaturetest.activity;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.readystatesoftware.systembartint.SystemBarTintManager;

import me.codetalk.activityfeaturetest.R;
import me.codetalk.activityfeaturetest.activity.annotation.ActivityFeature;

public class NormalActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

//         create our manager instance after the content view is set
//        SystemBarTintManager tintManager = new SystemBarTintManager(this);
////         enable status bar tint
//        tintManager.setStatusBarTintEnabled(true);
////         enable navigation bar tint
//        tintManager.setNavigationBarTintEnabled(true);
//
//        tintManager.setTintColor(Color.TRANSPARENT);
//        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

    }
}
