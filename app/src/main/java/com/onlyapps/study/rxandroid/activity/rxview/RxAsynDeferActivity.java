package com.onlyapps.study.rxandroid.activity.rxview;

import android.os.Bundle;

import com.onlyapps.study.rxandroid.activity.BaseLogComfirmActivity;

import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by hyungsoklee on 2016. 10. 24..
 */
public class RxAsynDeferActivity extends BaseLogComfirmActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        deferAsynTest();
        deferAsynTestDetail();
    }

    public void deferAsynTest() {
        addLog("++ deferAsynTest() : " + Thread.currentThread().getName() + ", create observable");
        Observable<String> observable = Observable.defer(() -> {
            addLog("++ deferAsynTest() : " + Thread.currentThread().getName() + ", defer function call");
            return Observable.just("HelloWorld");
        });
        addLog("++ deferAsynTest() : " + Thread.currentThread().getName() + ", do subscribe");
        observable
                // computation thread 에서 defer function 이 실행됩니다.
                .subscribeOn(Schedulers.computation())
                // 새로운 thread 에서 Subscriber 로 이벤트가 전달됩니다.
                .observeOn(Schedulers.newThread())
                .subscribe(onNext, onError, onComplete);

        addLog("++ deferAsynTest() : " + Thread.currentThread().getName() + ", after subscribe");
    }

    public void deferAsynTestDetail() {
        addLog("++ deferAsynTestDetail() : " + Thread.currentThread().getName() + ", create observable");
        Observable<String> observable = Observable.defer(() -> {
            addLog("++ deferAsynTestDetail() : " + Thread.currentThread().getName() + ", defer function call");
            return Observable.just("HelloWorld");
        });
        addLog("++ deferAsynTestDetail() : " + Thread.currentThread().getName() + ", do subscribe");
        Observable<String> observable2 = observable
                .subscribeOn(Schedulers.computation())
                .observeOn(Schedulers.newThread())
                .map((text) -> {
                    addLog("++ deferAsynTest() : " + Thread.currentThread().getName() + ", map");
                    return "(" + text + ")";
                });
        addLog("++ deferAsynTestDetail() : " + Thread.currentThread().getName() + ", do observable2");
        observable2
                .observeOn(Schedulers.newThread())
                .subscribe(onNext, onError, onComplete);
        addLog("++ deferAsynTestDetail() : " + Thread.currentThread().getName() + ", after subscribe");
    }
}
