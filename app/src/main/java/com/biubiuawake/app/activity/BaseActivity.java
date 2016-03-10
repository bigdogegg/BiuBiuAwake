package com.biubiuawake.app.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/3/9 0009.
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected abstract int getContentView();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        ButterKnife.bind(this);
        init();
    }
    protected abstract void init();
}
