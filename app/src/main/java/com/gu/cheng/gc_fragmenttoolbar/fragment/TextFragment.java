package com.gu.cheng.gc_fragmenttoolbar.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gu.cheng.gc_fragmenttoolbar.R;

/**
 * Created by gc on 2016/8/30.
 */
public class TextFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        View inflate = inflater.inflate(R.layout.content_scrolling, container, false);
        return inflate;
    }
}
