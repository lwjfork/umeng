package com.lwj.umeng.base;

import android.app.Activity;

/**
 * Created by lwj on 2015/8/6.
 */
public interface IActivityLife {
    void onCreate(Activity var1);

    void onResume(Activity var1);

    void onStart(Activity var1);

    void onPause(Activity var1);

    void onStop(Activity var1);

    void onDestroy(Activity var1);
}
