package com.gu.cheng.gc_fragmenttoolbar;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.gu.cheng.gc_fragmenttoolbar.fragment.PicToolbarFragment;
import com.gu.cheng.gc_fragmenttoolbar.fragment.ToolbarFragment;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        /**
         *第一种  通过Viewpager切换Fragment
         */
        initViewPageFragment();

    }

    private void initViewPageFragment() {
        mViewPager = (ViewPager) findViewById(R.id.id_view_pager);
        mTabLayout = (TabLayout) findViewById(R.id.id_tab_layout);

        final List<Fragment> fragments = new ArrayList<>();
        fragments.add(new PicToolbarFragment());
        fragments.add(new ToolbarFragment());
        List<String> titles = new ArrayList<>();
        titles.add("推荐");
        titles.add("话题");

        SimpleFragmentAdapter mAdapter = new SimpleFragmentAdapter(getSupportFragmentManager(),fragments,
                titles);

        mViewPager.setAdapter(mAdapter);

        mTabLayout.setupWithViewPager(mViewPager);
    }
}
