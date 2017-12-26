package me.codetalk.daggertest1.model;

import android.util.Log;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by guobxu on 2017/12/26.
 */
@Module
public class Engine {

    private static final String TAG = "Engine";

    public Engine() {
        Log.i(TAG, "Engine created!");
    }

    @Provides
    @Singleton
    public static Engine newInstance() {
        Log.i(TAG, "newInstance!");

        return new Engine();
    }

//    @Provides @Singleton
//    public static Car createCar() {
//        Log.i(TAG, "new Car()");
//        return new Car();
//    }

//    @Provides @Singleton
//    public static Car createCar() {
//        Log.i(TAG, "new Car()");
//        return new Car();
//    }

}
