package com.lwj.umeng.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;


import com.lwj.umeng.base.IFragmentLife;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by lwj on 2015/8/6.
 */
public class UMengBaseFragment extends Fragment{
    public static ArrayList<IFragmentLife> mSubscribers = new ArrayList();


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Iterator i$ = mSubscribers.iterator();

        while(i$.hasNext()) {
            IFragmentLife mFragLife = (IFragmentLife)i$.next();
            mFragLife.onCreate(this);
        }

    }

    public void onResume() {
        super.onResume();
        Iterator i$ = mSubscribers.iterator();

        while(i$.hasNext()) {
            IFragmentLife mFragLife = (IFragmentLife)i$.next();
            mFragLife.onResume(this);
        }
    }
    public void onPause() {
        super.onPause();
        Iterator i$ = mSubscribers.iterator();
        while(i$.hasNext()) {
            IFragmentLife mFragLife = (IFragmentLife)i$.next();
            mFragLife.onPause(this);
        }
    }
    public void onStart() {
        super.onStart();
        Iterator i$ = mSubscribers.iterator();
        while(i$.hasNext()) {
            IFragmentLife mFragLife = (IFragmentLife)i$.next();
            mFragLife.onStart(this);
        }
    }
    public void onStop() {
        super.onStop();
        Iterator i$ = mSubscribers.iterator();
        while(i$.hasNext()) {
            IFragmentLife mFragLife = (IFragmentLife)i$.next();
            mFragLife.onStop(this);
        }
    }
    public void onDestroy() {
        super.onDestroy();
        Iterator i$ = mSubscribers.iterator();

        while(i$.hasNext()) {
            IFragmentLife mFragLife = (IFragmentLife)i$.next();
            mFragLife.onDestroy(this);
        }
    }

    public static void addSubscriber(IFragmentLife _fragmentLife) {
        mSubscribers.add(_fragmentLife);
    }


}
