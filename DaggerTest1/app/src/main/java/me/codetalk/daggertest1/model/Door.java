package me.codetalk.daggertest1.model;

import android.util.Log;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by guobxu on 2017/12/26.
 */
@Module
public class Door {

    private static final String TAG = "Door";

    public Door() {
        Log.i(TAG, "Door created!");
    }

    @Provides @Singleton
    public static Door newInstance() {
        Log.i(TAG, "newInstance!");

        return new Door();
    }

}
