package me.codetalk.daggertest1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import javax.inject.Inject;

import me.codetalk.daggertest1.component.CarComponent;
import me.codetalk.daggertest1.component.DaggerCarComponent;
import me.codetalk.daggertest1.model.Car;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Toast.makeText(this, String.valueOf(vehicle.getSpeed()), Toast.LENGTH_SHORT).show();

        Button btn = findViewById(R.id.btn_goto2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.btn_goto2:
                        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        CarComponent carComponent = DaggerCarComponent.builder().build();
        Car car = carComponent.makeCar();
        Log.i(TAG, car.toString());

        Log.i(TAG, car.getEngine().toString());
    }
}
