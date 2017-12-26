package me.codetalk.daggertest1.model;

import android.util.Log;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Lazy;
import dagger.Module;
import dagger.Provides;

/**
 * Created by guobxu on 2017/12/26.
 */
@Module
public class Car {

    private static final String TAG = "Car";

    private Lazy<Engine> engine;
    private Tire tire;
    private Door door;

    @Inject
    public Car(Lazy<Engine> engine, Tire tire, Door door) {
        Log.i(TAG, "Car created!");

        this.engine = engine;
        this.tire = tire;
        this.door = door;
    }

    public Car() {}

//    @Provides @Singleton
//    public static Car createCar() {
//        Log.i(TAG, "new Car()");
//        return new Car();
//    }

    public Engine getEngine() {
        return engine.get();
    }


}
