package me.codetalk.rxjavatest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import me.codetalk.rxjavatest.model.DateNumModel;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "SecondActivity";

    private FragmentManager mFragmentManager;

    private DateNumModel dateModel = DateNumModel.getInstance();

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private TextView textNum = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mFragmentManager = getSupportFragmentManager();
        Fragment fragment1 = Fragment1.newInstance();
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment1);
        fragmentTransaction.commit();

        // Button
        Button btn = findViewById(R.id.btn_pub_date);
        btn.setOnClickListener(this);

        Button btnNext = findViewById(R.id.btn_next_fragment);
        btnNext.setOnClickListener(this);

        textNum = findViewById(R.id.text_num);

        // subscribe
        subscribeModel();
    }

    private void subscribeModel() {
        dateModel.getNumSubject().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(rt -> {
                    Log.i(TAG, "Num: " + rt);

                    textNum.setText(String.valueOf(rt));
                });
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btn_pub_date:
                dateModel.setDate(dateFormat.format(new Date()));
                break;
            case R.id.btn_next_fragment:
                Fragment prevFragment = mFragmentManager.findFragmentById(R.id.fragment_container);
                Fragment nextFragment = null;
                if(prevFragment instanceof Fragment1) {
                    nextFragment = Fragment2.newInstance();
                } else {
                    nextFragment = Fragment1.newInstance();
                }

                FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, nextFragment);
                fragmentTransaction.commitAllowingStateLoss();

                break;
        }
    }
}
