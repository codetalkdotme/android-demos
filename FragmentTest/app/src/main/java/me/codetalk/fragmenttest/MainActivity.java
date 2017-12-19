package me.codetalk.fragmenttest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import me.codetalk.fragmenttest.fragment.AnotherRightFragment;
import me.codetalk.fragmenttest.fragment.RightFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.btn_replace_fragment);
        button.setOnClickListener(this);

        replaceFragment(new RightFragment());
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btn_replace_fragment:
                replaceFragment(new AnotherRightFragment());
                break;
            default:
                break;
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction txn = fragmentManager.beginTransaction();
        txn.replace(R.id.right_layout, fragment);
        txn.addToBackStack(null);
        txn.commit();
    }
}
