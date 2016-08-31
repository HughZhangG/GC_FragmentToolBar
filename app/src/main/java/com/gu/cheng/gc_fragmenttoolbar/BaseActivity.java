package com.gu.cheng.gc_fragmenttoolbar;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_base);

//        setTranslucentStatus(isApplyStatusBarTranslucency());

//        if (isApplyKitKatTranslucency()) {
//            setSystemBarTintDrawable(getResources().getDrawable(R.drawable.sr_primary));
//        }


    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        if (toolbar != null){
            setSupportActionBar(toolbar);
        }
    }

    /**
     * set status bar translucency
     *
     * @param on
     */
    protected void setTranslucentStatus(boolean on) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window win = getWindow();
            WindowManager.LayoutParams winParams = win.getAttributes();
            final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
            if (on) {
                winParams.flags |= bits;
            } else {
                winParams.flags &= ~bits;
            }
            win.setAttributes(winParams);
        }
    }

    /**
     * is applyStatusBarTranslucency
     *
     * @return
     */
//    protected abstract boolean isApplyStatusBarTranslucency();

//    protected abstract boolean isApplyKitKatTranslucency();
}
