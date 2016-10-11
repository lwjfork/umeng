package com.lwj.demo;

import android.support.v4.app.Fragment;
import android.util.Log;

import com.lwj.umeng.base.AbsFragmentLife;
import com.lwj.umeng.utils.AnalysisUtil;

import static android.R.attr.fragment;

/**
 * Created by lwj on 16/10/11.
 * liuwenjie@goumin.com
 */

public class ByStrFragmentLife extends AbsFragmentLife {

    @Override
    public void onResume(Fragment mFragment) {
        super.onResume(mFragment);
        String name = getName(mFragment);
        Log.d(mFragment.getClass().getSimpleName()+"--别名---", name);
        AnalysisUtil.onResume(mFragment, name);
    }

    @Override
    public void onPause(Fragment mFragment) {
        String name = getName(mFragment);
        Log.d(mFragment.getClass().getSimpleName()+"--别名---", name);
        AnalysisUtil.onPause(mFragment, name);
    }


    private String getName(Fragment fragment) {
        String acName = fragment.getClass().getSimpleName();
        int strResId = fragment.getResources().getIdentifier(acName, "string", fragment.getActivity().getPackageName());
        if (strResId <= 0) {
            return acName;
        } else {
            String name = fragment.getString(strResId);
            if (name.length() == 0) {
                return acName;
            } else {
                return name;
            }
        }
    }

}
