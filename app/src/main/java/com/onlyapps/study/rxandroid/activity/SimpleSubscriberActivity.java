package com.onlyapps.study.rxandroid.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.onlyapps.study.rxandroid.R;

import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;

public class SimpleSubscriberActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_textview);

//        Observable<String> simpleObservable =
//                Observable.create(new Observable.OnSubscribe<String>() {
//                    @Override
//                    public void call(Subscriber<? super String> subscriber) {
//                        subscriber.onNext("Hello RxAndroid !!");
//                        subscriber.onCompleted();
//                    }
//                });

        // 하나의 값만 전달하는 Observable을 만드는 유틸리티 just가 있다.
//        Observable<String> simpleObservable = Observable.just("Hello RxAndroid !!");

        // 두개 이상의 onNext를 전달하는 것을 돕는 유틸리티 from이 있다.
        String[] array = {"Hello", "World"};
        Observable<String> simpleObservable = Observable.from(array);

        simpleObservable
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String text) {
                        Log.d(TAG, "call() : " + text);
                        ((TextView) findViewById(R.id.textView)).setText(text);
                    }
                });

        // Action1과 Action0을 예외와 성공 처리에도 사용할 수 있다.
        // subscrbe는 파라미터 2개 (+예외), 3개(+예외, 성공)를 받는다.

//        simpleObservable
//                .subscribe(new Action1<String>() {
//                    @Override
//                    public void call(String text) {
//                        Log.d(TAG, "Action1(DOWN) call : " + text);
//                        ((TextView) findViewById(R.id.textView)).setText(text);
//                    }
//                }, new Action1<Throwable>() {
//                    @Override
//                    public void call(Throwable throwable) {
//                        Log.e(TAG, "Action1() call throwable : " + throwable);
//                    }
//                }, new Action0() {
//                    @Override
//                    public void call() {
//                        Log.d(TAG, "Action0() call()");
//                    }
//                });


        simpleObservable
                .subscribe(text -> {
                    Log.d(TAG, "onNext() : " + text);
                    ((TextView) findViewById(R.id.textView)).setText(text);
                }, throwable -> {
                    Log.e(TAG, "onError() : " + throwable);
                }, () -> {
                    Log.d(TAG, "onComplete()");
                });
    }

}
