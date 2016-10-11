package com.lwj.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lwj.umeng.ui.UMengBaseFragment;

/**
 * Created by lwj on 16/10/11.
 * liuwenjie@goumin.com
 */

public class TestFragment extends UMengBaseFragment {

    public static TestFragment getInstance() {
        TestFragment fragment = new TestFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        TextView textView = new TextView(getActivity());
        textView.setText("我是fragment");

        return textView;
    }
}
