package me.codetalk.daggertest1.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import me.codetalk.daggertest1.model.Engine;

/**
 * Created by guobxu on 2017/12/26.
 */

@Module
public class EngineModule {

    @Provides @Singleton
    public Engine provideEngine() {
        return new Engine();
    }

}
