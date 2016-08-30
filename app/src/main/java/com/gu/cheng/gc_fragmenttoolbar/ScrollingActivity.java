package com.gu.cheng.gc_fragmenttoolbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.gu.cheng.gc_fragmenttoolbar.behavior.ScaleDownShowBehavior;

import java.util.ArrayList;
import java.util.List;

public class ScrollingActivity extends AppCompatActivity {

    private static final String TAG = "ScrollingActivity";
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private BottomSheetBehavior mBottomSheetBehavior;
    private AppBarLayout mAppBarLayout;
    private LayoutInflater mLayoutInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        mViewPager = (ViewPager) findViewById(R.id.id_view_pager);
        mTabLayout = (TabLayout) findViewById(R.id.id_tab_layout);

        final List<Fragment> fragments = new ArrayList<>();
        fragments.add(new PicToolbarFragment());
        fragments.add(new ToolbarFragment());
        List<String> titles = new ArrayList<>();
        titles.add("推荐");
        titles.add("话题");

        SimpleFragmentAdapter mAdapter = new SimpleFragmentAdapter(getSupportFragmentManager(),fragments,titles);

        mViewPager.setAdapter(mAdapter);

        mTabLayout.setupWithViewPager(mViewPager);



//        StatusBarUtil.setTranslucent(ScrollingActivity.this, StatusBarUtil.DEFAULT_STATUS_BAR_ALPHA);

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            // 透明状态栏
//            getWindow().addFlags(
//                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            // 透明导航栏
//            getWindow().addFlags(
//                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//        }

        final FloatingActionButton FAB = (FloatingActionButton) findViewById(R.id.fab);
        FAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Snackbar.make(FAB, "点宝宝干啥", Snackbar.LENGTH_SHORT).show();
                startActivity(new Intent(ScrollingActivity.this,MainActivity.class));
            }
        });

//        ScaleDownShowBehavior scaleDownShowFab = ScaleDownShowBehavior.from(FAB);
//        scaleDownShowFab.setOnStateChangedListener(onStateChangedListener);
//
//
//        mBottomSheetBehavior = BottomSheetBehavior.from(findViewById(R.id.id_tab_layout));


    }



    private ScaleDownShowBehavior.OnStateChangedListener onStateChangedListener = new ScaleDownShowBehavior.OnStateChangedListener() {
        @Override
        public void onChanged(boolean isShow) {
            mBottomSheetBehavior.setState(isShow ? BottomSheetBehavior.STATE_EXPANDED : BottomSheetBehavior.STATE_COLLAPSED);
        }
    };

    private boolean initialize = false;

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (!initialize) {
            initialize = true;
//            mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
