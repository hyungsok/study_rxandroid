package com.onlyapps.study.rxandroid.activity.simple;

import android.os.Bundle;

import com.onlyapps.study.rxandroid.activity.BaseSimpleActivity;

import rx.Observable;

public class SimpleSubscriberActivity extends BaseSimpleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 하나의 값만 전달하는 Observable을 만드는 유틸리티 just가 있다.
        Observable<String> simple = Observable.just("Hello RxAndroid !!");
        simple.subscribe(onNext, onError, onComplete);

        // 두개 이상의 onNext를 전달하는 것을 돕는 유틸리티 from이 있다.
        String[] array = {"Hello", "World"};
        Observable<String> simpleObservableArray = Observable.from(array);
        // Action1과 Action0을 예외와 성공 처리에도 사용할 수 있다.
        // subscrbe는 파라미터 2개 (+예외), 3개(+예외, 성공)를 받는다.
        simpleObservableArray.subscribe(onNext, onError, onComplete);
    }
}
