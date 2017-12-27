package me.codetalk.rxjavatest.model;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by guobxu on 2017/12/27.
 */

public class DateNumModel {

    private PublishSubject<String> dateSubject = PublishSubject.create();

    private PublishSubject<Integer> numSubject = PublishSubject.create();

    private static DateNumModel dateNumModel = new DateNumModel();

    public static DateNumModel getInstance() {
        return dateNumModel;
    }

    public void setDate(String date) {
        dateSubject.onNext(date);
    }

    public void setNum(Integer num) {
        numSubject.onNext(num);
    }

    public Observable<String> getDateSubject() {
        return dateSubject;
    }

    public Observable<Integer> getNumSubject() {
        return numSubject;
    }


}
