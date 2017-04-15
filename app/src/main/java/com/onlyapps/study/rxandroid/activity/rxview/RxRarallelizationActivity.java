package com.onlyapps.study.rxandroid.activity.rxview;

import android.os.Bundle;
import android.util.Log;

import com.onlyapps.study.rxandroid.activity.BaseLogComfirmActivity;

import java.util.Random;

import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * 참고
 * http://tomstechnicalblog.blogspot.kr/2015/11/rxjava-achieving-parallelization.html
 */
public class RxRarallelizationActivity extends BaseLogComfirmActivity {

    private static final Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Observable.range(1, 10).flatMap(val ->
                Observable.just(val)
                        .subscribeOn(Schedulers.newThread())
                        .map(this::intenseCalculation))
                .toList()
                .subscribe(val -> Log.d(TAG, "Subscriber received " + val + " on " + Thread.currentThread().getName()));
    }

    public int intenseCalculation(int i) {
        try {
            int randInt = randInt(1, 100);
            addLog("Calculating " + i + " time(" + randInt + ") on " + Thread.currentThread().getName());
            Thread.sleep(randInt);
            return i;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public int randInt(int min, int max) {
        return rand.nextInt((max - min) + 1) + min;
    }
}
