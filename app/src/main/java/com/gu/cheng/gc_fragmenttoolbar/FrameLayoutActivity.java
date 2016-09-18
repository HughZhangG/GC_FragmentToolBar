package com.gu.cheng.gc_fragmenttoolbar;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.gu.cheng.gc_fragmenttoolbar.behavior.ScaleDownShowBehavior;
import com.gu.cheng.gc_fragmenttoolbar.fragment.PicToolbarFragment;
import com.gu.cheng.gc_fragmenttoolbar.fragment.ToolbarFragment;

import java.util.ArrayList;
import java.util.List;

public class FrameLayoutActivity extends AppCompatActivity {

    private static final String TAG = "ScrollingActivity";

    private BottomSheetBehavior mBottomSheetBehavior;
    private AppBarLayout mAppBarLayout;
    private LayoutInflater mLayoutInflater;
    private Fragment mCurrentFragment;
    private List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout);

        final FloatingActionButton FAB = (FloatingActionButton) findViewById(R.id.fab);
        FAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(FrameLayoutActivity.this,MainActivity.class));
            }
        });

        fragments = new ArrayList<>();
        fragments.add(new PicToolbarFragment());
        fragments.add(new ToolbarFragment());

        /**
         * 第二种  使用frameLayout切换Fragment
         */
        addFragment(fragments.get(0));




        TabLayout tabLayout = (TabLayout) findViewById(R.id.id_tab_layout);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                addFragment(fragments.get(position));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void addFragment(Fragment fragment) {

        Log.d(TAG, "addFragment: "+mCurrentFragment +"---"+fragment);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if (mCurrentFragment != null) {
            if (mCurrentFragment == fragment) {
                return;
            } else {
                transaction.hide(mCurrentFragment);
            }
        }

        if (!fragment.isAdded()) {
            transaction.add(R.id.id_fragment_content, fragment);
        }else {
            transaction.show(fragment);
        }


//        transaction.addToBackStack(null);

        transaction.commit();
        mCurrentFragment = fragment;

    }

    @Override
    public void onAttachFragment(android.app.Fragment fragment) {
        super.onAttachFragment(fragment);

    }

    private ScaleDownShowBehavior.OnStateChangedListener onStateChangedListener = new ScaleDownShowBehavior.OnStateChangedListener() {
        @Override
        public void onChanged(boolean isShow) {
            mBottomSheetBehavior.setState(isShow ? BottomSheetBehavior.STATE_EXPANDED : BottomSheetBehavior.STATE_COLLAPSED);
        }
    };

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
