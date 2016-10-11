package com.lwj.demo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.lwj.umeng.ui.UMengBaseActivity;

/**
 * Created by lwj on 16/10/11.
 * liuwenjie@goumin.com
 */

public class TestActivity extends UMengBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        addFragmentIntoActivity(this,TestFragment.getInstance(),R.id.fl_container);
    }



    public static void addFragmentIntoActivity(FragmentActivity activity, Fragment fragment, int fragmentId) {
        FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
        ft.replace(fragmentId, fragment);
        ft.commitAllowingStateLoss();
    }
}
