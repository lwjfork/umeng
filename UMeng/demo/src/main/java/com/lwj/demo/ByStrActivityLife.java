package com.lwj.demo;

import android.app.Activity;
import android.util.Log;

import com.lwj.umeng.base.AbsActivityLife;
import com.lwj.umeng.utils.AnalysisUtil;

/**
 * Created by lwj on 16/10/11.
 * liuwenjie@goumin.com
 */

public class ByStrActivityLife extends AbsActivityLife {
    @Override
    public void onResume(Activity _activity) {
        super.onResume(_activity);
        String name = getName(_activity);
        Log.d(_activity.getClass().getSimpleName()+"--别名---", name);
        AnalysisUtil.onResume(_activity, name);
    }

    @Override
    public void onPause(Activity _activity) {
        String name = getName(_activity);
        Log.d(_activity.getClass().getSimpleName()+"--别名---", name);
        AnalysisUtil.onPause(_activity, name);
    }


    private String getName(Activity _activity) {
        String acName = _activity.getClass().getSimpleName();
        int strResId = _activity.getResources().getIdentifier(acName, "string", _activity.getPackageName());
        if (strResId <= 0) {
            return acName;
        } else {
            String name = _activity.getString(strResId);
            if (name.length() == 0) {
                return acName;
            } else {
                return name;
            }
        }
    }

}
