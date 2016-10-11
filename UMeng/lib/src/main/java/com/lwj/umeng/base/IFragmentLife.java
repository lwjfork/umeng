package com.lwj.umeng.base;

import android.support.v4.app.Fragment;

/**
 * Created by lwj on 2015/8/6.
 *
 */
public interface IFragmentLife {

    void onCreate(Fragment var1);

    void onResume(Fragment var1);

    void onStart(Fragment var1);

    void onPause(Fragment var1);

    void onStop(Fragment var1);

    void onDestroy(Fragment var1);

}
