package me.codetalk.daggertest1.model;

import android.util.Log;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by guobxu on 2017/12/26.
 */
@Module
public class Tire {

    private static final String TAG = "Tire";

    public Tire() {
        Log.i(TAG, "Tire created!");
    }

    @Provides
    @Singleton
    public static Tire newInstance() {
        Log.i(TAG, "newInstance!");

        return new Tire();
    }

}
