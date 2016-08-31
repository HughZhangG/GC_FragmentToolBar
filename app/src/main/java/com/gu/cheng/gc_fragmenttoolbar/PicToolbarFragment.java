package com.gu.cheng.gc_fragmenttoolbar;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import in.srain.cube.views.ptr.header.StoreHouseHeader;

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
        initToolbar(inflate);

//        FloatingActionButton button = (FloatingActionButton) inflate.findViewById(R.id.fab);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(mContext,MainActivity.class));
//            }
//        });

        initPtrFrameLayout(inflate);

        return inflate;
    }

    private void initPtrFrameLayout(View inflate) {
        final PtrClassicFrameLayout ptrFrameLayout = (PtrClassicFrameLayout) inflate.findViewById(R.id.id_pull_to_refresh);
        StoreHouseHeader header = new StoreHouseHeader(getContext());
//        header.setPadding(0, ScreenUtils.dip2px(mContext, 20), 0, ScreenUtils.dip2px(mContext, 20));
//        header.initWithString("LOADING");
//        header.setBackgroundColor(ContextCompat.getColor(mContext, R.color.white));
//        ptrFrameLayout.setDurationToCloseHeader(1500);
//        ptrFrameLayout.setHeaderView(header);
//        ptrFrameLayout.addPtrUIHandler(header);
        ptrFrameLayout.setPtrHandler(new PtrHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                //判断appbarlayout的监听verticalOffSet==0时才可以刷新
                return canRefresh && PtrDefaultHandler.checkContentCanBePulledDown(frame, content, header);
            }
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                ptrFrameLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
//                        SearchLog();
                        ptrFrameLayout.refreshComplete();
                    }
                }, 1500);
            }
        });
    }

    private void initToolbar(View inflate) {
       /* Toolbar toolbar = (Toolbar) inflate.findViewById(R.id.toolbar);
        if (mContext instanceof AppCompatActivity) {
            AppCompatActivity activity = (AppCompatActivity) mContext;
            activity.setSupportActionBar(toolbar);
            ActionBar supportActionBar = activity.getSupportActionBar();


//            supportActionBar.setDisplayHomeAsUpEnabled(true);
//            supportActionBar.setDisplayShowHomeEnabled(true);
//            supportActionBar.setDisplayShowTitleEnabled(false);
//            supportActionBar.setDisplayUseLogoEnabled(false);
//            StatusBarUtil.setTranslucent(activity,0);
        }*/
        AppBarLayout appBarLayout = (AppBarLayout) inflate.findViewById(R.id.app_bar);
        appBarLayout.addOnOffsetChangedListener(this);

    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
//        if (operatelogFragment == null)
//            return;
        Log.d(TAG, "onOffsetChanged:verticalOffset: "+verticalOffset);
        if (verticalOffset == 0) {
            PicToolbarFragment.canRefresh = true;
//            operatelogFragment.setCanRefresh(true);
        } else {
            PicToolbarFragment.canRefresh = false;
//            operatelogFragment.setCanRefresh(false);
        }
    }


}
