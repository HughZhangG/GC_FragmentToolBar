package com.gu.cheng.gc_fragmenttoolbar;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.gu.cheng.gc_fragmenttoolbar.fragment.TextFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private List<Fragment> fragments;
    private List<String> titles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        StatusBarUtil.setTranslucent(MainActivity.this, StatusBarUtil.DEFAULT_STATUS_BAR_ALPHA);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initData();

        ViewPager viewPager = (ViewPager) findViewById(R.id.id_view_pager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.id_tab_layout);



        SimpleFragmentAdapter adapter = new SimpleFragmentAdapter(getSupportFragmentManager(),fragments,titles);

        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);

    }

    private void initData() {
        fragments = new ArrayList<>();
        fragments.add(new TextFragment());
        fragments.add(new TextFragment());
        fragments.add(new TextFragment());
        fragments.add(new TextFragment());

        titles = new ArrayList<>();
        titles.add("推荐");
        titles.add("关注");
        titles.add("本地");
        titles.add("喜欢");
    }

}
