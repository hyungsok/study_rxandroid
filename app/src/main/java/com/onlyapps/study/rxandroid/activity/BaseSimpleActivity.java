package com.onlyapps.study.rxandroid.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.onlyapps.study.rxandroid.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public abstract class BaseSimpleActivity extends BaseActivity {

    @Bind(R.id.textView)
    public TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_textview);
        ButterKnife.bind(this);
        mTextView.setText(getClass().getSimpleName());
    }
}
