package com.lwj.umeng.iml;

import android.app.Activity;
import android.util.Log;

import com.lwj.umeng.base.AbsActivityLife;
import com.lwj.umeng.utils.AnalysisUtil;


/**
 * Created by lwj on 2015/8/6.
 */
public class UmengActivityLife extends AbsActivityLife {
    public UmengActivityLife() {
    }

    public void onResume(Activity _activity) {
        super.onResume(_activity);
        AnalysisUtil.onResume(_activity);
        Log.v("UmengFragmentLife >>%s", "onResume");
    }

    public void onPause(Activity _activity) {
        super.onPause(_activity);
        AnalysisUtil.onPause(_activity);
        Log.v("UmengFragmentLife >>%s", "onPause");
    }
}
