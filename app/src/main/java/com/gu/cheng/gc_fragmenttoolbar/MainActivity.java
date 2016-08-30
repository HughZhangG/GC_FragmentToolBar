package com.gu.cheng.gc_fragmenttoolbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jaeger.library.StatusBarUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StatusBarUtil.setTranslucent(MainActivity.this, StatusBarUtil.DEFAULT_STATUS_BAR_ALPHA);
    }
}
