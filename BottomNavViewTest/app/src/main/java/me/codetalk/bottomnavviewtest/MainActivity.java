package me.codetalk.bottomnavviewtest;

import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // bottom navbar
        BottomNavigationView bottomNavView = findViewById(R.id.nav_bottom_tabbar);
        bottomNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Log.i(TAG, "bottom navbar item selected");

                switch(item.getItemId()) {
                    case R.id.item_fav:

                    case R.id.item_music:

                    case R.id.item_sched:
                }

                return true;
            }
        });

    }
}
