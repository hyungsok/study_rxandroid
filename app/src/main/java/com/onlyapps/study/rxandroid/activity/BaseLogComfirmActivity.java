package com.onlyapps.study.rxandroid.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.onlyapps.study.rxandroid.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.functions.Action0;
import rx.functions.Action1;

/**
 * Created by hyungsoklee on 2016. 10. 24..
 */
public abstract class BaseLogComfirmActivity extends BaseActivity {
    @Bind(R.id.linear_layout)
    LinearLayout mLinearLayout;

    protected final Action1<String> onNext = text ->
            addLog("++ onNext(" + Thread.currentThread().getName() + ") : " + text);
    protected final Action1<Throwable> onError = throwable ->
            addLog("++ onError(" + Thread.currentThread().getName() + ")");
    protected final Action0 onComplete = () ->
            addLog("++ onComplete(" + Thread.currentThread().getName() + ")");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_comfirm);
        ButterKnife.bind(this);
    }

    protected void addLog(String text) {
        Log.d(TAG, text);

        new Handler(Looper.getMainLooper()).post(() -> {
            TextView textView = new TextView(getApplicationContext());
            textView.setText(text);
            textView.setTextColor(getResources().getColor(android.R.color.black));
            mLinearLayout.addView(textView);
        });
    }
}
