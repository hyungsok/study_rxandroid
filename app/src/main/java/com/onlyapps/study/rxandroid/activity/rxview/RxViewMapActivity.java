package com.onlyapps.study.rxandroid.activity.rxview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jakewharton.rxbinding.view.RxView;
import com.onlyapps.study.rxandroid.R;
import com.onlyapps.study.rxandroid.activity.BaseActivity;

import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hyungsoklee on 2016. 10. 4..
 */

public class RxViewMapActivity extends BaseActivity {
    @Bind(R.id.textView)
    TextView mTextView;

    @Bind(R.id.button)
    Button mButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_button);
        ButterKnife.bind(this);

        RxView.clicks(mButton)
                .map(event -> new Random().nextInt(101))
                .subscribe(
                        value -> mTextView.setText("Value : " + value),
                        onError,
                        onComplete);
    }
}
