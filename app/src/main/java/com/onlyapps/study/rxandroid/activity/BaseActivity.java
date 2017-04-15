package com.onlyapps.study.rxandroid.activity;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import rx.functions.Action0;
import rx.functions.Action1;

/**
 * Created by hyungsoklee on 2016. 10. 4..
 */

public class BaseActivity extends AppCompatActivity {
    protected static final String TAG = "RxAndroid";

    protected final Action1<String> onNext = text -> Log.i(TAG, "++ onNext() : " + text);
    protected final Action1<Throwable> onError = throwable -> {
        Toast.makeText(getApplicationContext(), throwable.toString(), Toast.LENGTH_SHORT).show();
        Log.e(TAG, "++ onError()");
    };
    protected final Action0 onComplete = () -> Log.d(TAG, "++ onComplete()");
}
