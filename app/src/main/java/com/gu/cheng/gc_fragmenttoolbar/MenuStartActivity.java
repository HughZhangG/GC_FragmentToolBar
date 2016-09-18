package com.gu.cheng.gc_fragmenttoolbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MenuStartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_start);
    }

    public void onClick(View v){
        int id = v.getId();
        switch (id){
            case R.id.id_btn_start_main:
                /**
                 * 单独的沉浸式Activity
                 */
                startActivity(new Intent(MenuStartActivity.this,MainActivity.class));
                break;
            case R.id.id_btn_start_viewpager:
                /**
                 * 通过ViewPager切换Fragment的Activity
                 */
                startActivity(new Intent(MenuStartActivity.this,ViewPagerActivity.class));
                break;
            case R.id.id_btn_start_frame_layout:
                /**
                 * 通过FrameLayout切换Fragment的Activity
                 */
                startActivity(new Intent(MenuStartActivity.this,FrameLayoutActivity.class));
                break;
        }
    }
}
