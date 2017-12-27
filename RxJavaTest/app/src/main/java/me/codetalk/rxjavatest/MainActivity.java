package me.codetalk.rxjavatest;

import java.util.concurrent.TimeUnit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Button
        Button btn = findViewById(R.id.btn_publish_obj);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }

        });

        // Test
        testObservable();

    }

    private void testObservable() {
        // RxJava
        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onNext(4);

                e.onComplete();
            }
        });

        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i(TAG, "onSubscribe: ");
            }

            @Override
            public void onNext(Integer val) {
                Log.i(TAG, "onNext: " + val);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: ");
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "onComplete: All Done!");
            }
        };
//        observable.subscribe(observer);

        // just
        Observable<String> justObservable = Observable.just("Hello World!");
        // array
        Observable<Integer> arrObservable = Observable.fromArray(new Integer[]{1,2,3,4});
        // range
        Observable<Integer> rangeObservable = Observable.range(0, 5); // 0 1 2 3 4
        // interval 0 1 2 3 ....  emit each second
        Observable<Long> intervalObservable = Observable.interval(1, TimeUnit.SECONDS); //
        // empty
        Observable<String> stringObservable = Observable.empty();


//        intervalObservable.subscribe(observer);
    }
}
