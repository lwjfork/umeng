package com.lwj.umeng.iml;

import android.support.v4.app.Fragment;
import android.util.Log;

import com.lwj.umeng.base.AbsFragmentLife;
import com.lwj.umeng.utils.AnalysisUtil;

/**
 * Created by lwj on 2015/8/6.
 */
public class UmengFragmentLife extends AbsFragmentLife {
    public UmengFragmentLife() {
    }

    public void onResume(Fragment mFragment) {
        super.onResume(mFragment);
        AnalysisUtil.onResume(mFragment);
        Log.v("UmengFragmentLife >>%s","onResume");
    }

    public void onPause(Fragment mFragment) {
        super.onPause(mFragment);
        AnalysisUtil.onPause(mFragment);
        Log.v("UmengFragmentLife >>%s", "onPause");

    }
}
