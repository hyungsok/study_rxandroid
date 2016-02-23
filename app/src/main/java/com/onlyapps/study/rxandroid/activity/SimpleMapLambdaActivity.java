package com.onlyapps.study.rxandroid.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.onlyapps.study.rxandroid.R;

import rx.Observable;

public class SimpleMapLambdaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_textview);

        /**
         * SimpleMapActivity 소스와 비교했을 때 간결하게 소스처리가 가능하다.
         */
        Observable<String> simpleObservable = Observable.just("Hello Lambda!!");
        // 단일 라인 람다는 자동으로 반환값이 결정되며 세미콜론을 적지 않습니다.
        // 여러 라인으로 된 람다는 세미콜론을 적고 중괄호도 필요합니다.
        simpleObservable
                .map(text -> text.length())
                .subscribe(
                        length -> ((TextView) findViewById(R.id.textView))
                                .setText("length: " + length));
    }
}
