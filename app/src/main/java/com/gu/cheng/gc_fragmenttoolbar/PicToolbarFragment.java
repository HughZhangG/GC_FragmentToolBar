package com.gu.cheng.gc_fragmenttoolbar;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by gc on 2016/8/26.
 */
public class PicToolbarFragment extends Fragment {

    private Context mContext;

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

    }
}
