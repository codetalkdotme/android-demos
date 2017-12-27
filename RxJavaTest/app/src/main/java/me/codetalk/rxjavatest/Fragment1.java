package me.codetalk.rxjavatest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import org.reactivestreams.Subscription;

import java.util.Random;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import me.codetalk.rxjavatest.model.DateNumModel;

/**
 * Created by guobxu on 2017/12/27.
 */

public class Fragment1 extends Fragment {

    private DateNumModel dateNumModel = DateNumModel.getInstance();

    private Disposable dateSubscription = null;

    private Random rand = new Random();

    private TextView textDate;

    private static final String TAG = "Fragment1";

    public Fragment1() {
        subscribeModel();
    }

    public static Fragment1 newInstance() {
        return new Fragment1();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, container, false);

        textDate = view.findViewById(R.id.text_date);

        return view;
    }

    private void subscribeModel() {
        dateSubscription = dateNumModel.getDateSubject().subscribe(rt-> {
                    Log.i(TAG, "Text: " + rt);

                    Log.i(TAG, "Text in textDate: " + textDate.getText());
                    textDate.setText(rt);
                    Log.i(TAG, "Text in textDate: " + textDate.getText());

                    int num = rand.nextInt(1000000);
                    dateNumModel.setNum(num);
                });
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy");

        super.onDestroy();

        dateSubscription.dispose();
    }
}
