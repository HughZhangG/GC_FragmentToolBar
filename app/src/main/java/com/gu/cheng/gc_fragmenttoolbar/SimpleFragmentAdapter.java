package com.gu.cheng.gc_fragmenttoolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by gc on 2016/8/26.
 */
public class SimpleFragmentAdapter extends FragmentPagerAdapter{

    private List<Fragment> fragmentList;
    private List<String> titleList;
    public SimpleFragmentAdapter(FragmentManager supportFragmentManager, List<Fragment> fragments,
                                 List<String> titles) {
        super(supportFragmentManager);
        fragmentList = fragments;
        titleList = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList == null ? 0 : fragmentList.size();
    }
}
