package com.onlyapps.study.rxandroid.activity.rxview;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.jakewharton.rxbinding.view.RxView;
import com.onlyapps.study.rxandroid.R;
import com.onlyapps.study.rxandroid.activity.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;

public class RxViewMergeScanActivity extends BaseActivity {

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

        mLeftButton.setText("-1 마이너스");
        mRightButton.setText("+1 플러스");
        mTextView.setText("0");

        Observable<Integer> lefts = RxView.clicks(mLeftButton).map(event -> -1);
        Observable<Integer> rights = RxView.clicks(mRightButton).map(event -> 1);

        Observable<Integer> together = Observable.merge(lefts, rights);
        together.scan(0, (sum, number) -> sum + number)
                .subscribe(
                        number -> mTextView.setText(String.valueOf(number.toString())),
                        onError,
                        onComplete);

    }
}
