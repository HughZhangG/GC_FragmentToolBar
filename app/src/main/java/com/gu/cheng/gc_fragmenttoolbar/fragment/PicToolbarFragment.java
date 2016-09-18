package com.gu.cheng.gc_fragmenttoolbar.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.gu.cheng.gc_fragmenttoolbar.R;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentStatePagerItemAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gc on 2016/8/26.
 */
public class PicToolbarFragment extends Fragment implements AppBarLayout.OnOffsetChangedListener{

    private static final String TAG = "PicToolbarFragment";
    private Context mContext;
    public static boolean canRefresh;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_index, container, false);


        ViewPager mViewPager = (ViewPager) inflate.findViewById(R.id.id_index_view_pager);

        mViewPager.setAdapter(new MyPagerAdapter(mContext));

        SmartTabLayout tabLayout = (SmartTabLayout) inflate.findViewById(R.id.viewpager_tab);

        ViewPager mContentViewPager = (ViewPager) inflate.findViewById(R.id.id_index_content_view_pager);

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new TextFragment());
        fragments.add(new TextFragment());
        fragments.add(new TextFragment());
        fragments.add(new TextFragment());

        List<String> titles = new ArrayList<>();
        titles.add("推荐");
        titles.add("关注");
        titles.add("本地");
        titles.add("喜欢");


        FragmentPagerItems pages = new FragmentPagerItems(mContext);
        for (String str : titles) {
            pages.add(FragmentPagerItem.of(str, TextFragment.class));
        }

        FragmentStatePagerItemAdapter adapter = new FragmentStatePagerItemAdapter(
                getChildFragmentManager(), pages);

        mContentViewPager.setAdapter(adapter);

        tabLayout.setViewPager(mContentViewPager);


        initToolbar(inflate);


        return inflate;
    }


    private void initToolbar(View inflate) {
        Toolbar toolbar = (Toolbar) inflate.findViewById(R.id.toolbar);
        if (mContext instanceof AppCompatActivity) {
            AppCompatActivity activity = (AppCompatActivity) mContext;
            activity.setSupportActionBar(toolbar);
            ActionBar supportActionBar = activity.getSupportActionBar();


//            supportActionBar.setDisplayHomeAsUpEnabled(true);
//            supportActionBar.setDisplayShowHomeEnabled(true);
//            supportActionBar.setDisplayShowTitleEnabled(false);
//            supportActionBar.setDisplayUseLogoEnabled(false);
//            StatusBarUtil.setTranslucent(activity,0);
        }
        AppBarLayout appBarLayout = (AppBarLayout) inflate.findViewById(R.id.app_bar);
        appBarLayout.addOnOffsetChangedListener(this);

    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {


    }


    private class MyPagerAdapter extends PagerAdapter {


        public MyPagerAdapter(Context mContext) {

        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView = new ImageView(mContext);

            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

            ViewPager.LayoutParams layoutParams = new ViewPager.LayoutParams();

            layoutParams.width = ViewPager.LayoutParams.MATCH_PARENT;

            layoutParams.height = ViewPager.LayoutParams.MATCH_PARENT;

            imageView.setLayoutParams(layoutParams);

            imageView.setBackgroundResource(R.drawable.pic1);

            container.addView(imageView);

            return imageView;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }
}
