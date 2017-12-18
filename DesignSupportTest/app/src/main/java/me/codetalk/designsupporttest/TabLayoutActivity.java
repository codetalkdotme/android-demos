package me.codetalk.designsupporttest;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import me.codetalk.designsupporttest.adapter.SimpleFragmentPagerAdapter;

public class TabLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);

        // View Pager
        ViewPager viewPager = findViewById(R.id.viewpager_main);
        SimpleFragmentPagerAdapter adapter = new SimpleFragmentPagerAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        // Tab Layout
        TabLayout tabLayout = findViewById(R.id.tab_top);
        tabLayout.setupWithViewPager(viewPager);
    }
}
