package com.onlyapps.study.rxandroid.activity.rxview;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jakewharton.rxbinding.view.RxView;
import com.onlyapps.study.rxandroid.R;
import com.onlyapps.study.rxandroid.activity.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;

public class RxViewMergeActivity extends BaseActivity {

    @Bind(R.id.left_button)
    Button mLeftButton;

    @Bind(R.id.right_button)
    Button mRightButton;

    @Bind(R.id.textView)
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_left_right_button_textview);
        ButterKnife.bind(this);

        Observable<String> lefts = RxView.clicks(mLeftButton).map(event -> "left");
        Observable<String> rights = RxView.clicks(mRightButton).map(event -> "right");
        Observable<String> together = Observable.merge(lefts, rights);
        // together.subscribe(text -> mTextView.setText(text));

        together.map(text -> text.toUpperCase())
                .subscribe(
                        text -> mTextView.setText(text),
                        onError,
                        onComplete);

    }
}
