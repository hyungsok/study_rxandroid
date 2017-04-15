package com.onlyapps.study.rxandroid.activity.simple;

import android.os.Bundle;

import com.onlyapps.study.rxandroid.activity.BaseSimpleActivity;

import rx.Observable;

public class SimpleMapActivity extends BaseSimpleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 문자열로 부터 간단히 옵저버블을 생성한다.
        Observable<String> simpleObservable = Observable.just("Hello RxAndroid");

        // map을 통해 스트림에 있는 "Hello RxAndroid"를 대문자로 변환하는 과정을 추가한다.
        simpleObservable
                .map(text -> text.toUpperCase())
                .subscribe(text -> mTextView.setText(text));
    }
}
