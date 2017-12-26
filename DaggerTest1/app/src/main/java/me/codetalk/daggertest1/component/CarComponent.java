package me.codetalk.daggertest1.component;

import javax.inject.Singleton;

import dagger.Component;
import me.codetalk.daggertest1.model.Car;
import me.codetalk.daggertest1.model.Door;
import me.codetalk.daggertest1.model.Engine;
import me.codetalk.daggertest1.model.Tire;

/**
 * Created by guobxu on 2017/12/26.
 */

@Singleton
@Component(modules = {Door.class, Engine.class, Tire.class})
public interface CarComponent {

    Car makeCar();

}
