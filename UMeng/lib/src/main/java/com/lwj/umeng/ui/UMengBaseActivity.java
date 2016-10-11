package com.lwj.umeng.ui;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;


import com.lwj.umeng.base.IActivityLife;

import java.util.ArrayList;
import java.util.Iterator;


public class UMengBaseActivity extends FragmentActivity {
    public static ArrayList<IActivityLife> mSubscribers = new ArrayList();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onBaseActivityCreate(savedInstanceState);
    }
    protected void onBaseActivityCreate(Bundle savedInstanceState) {
        Iterator bundle = mSubscribers.iterator();
        while(bundle.hasNext()) {
            IActivityLife mLife = (IActivityLife)bundle.next();
            mLife.onCreate(this);
        }
    }

    protected void onStart() {
        super.onStart();
        onBaseActivityStart();
    }

    public void onBaseActivityStart() {
        Iterator i$ = mSubscribers.iterator();
        while(i$.hasNext()) {
            IActivityLife mLife = (IActivityLife)i$.next();
            mLife.onStart(this);
        }
    }


    protected void onResume() {
        super.onResume();
        this.onBaseActivityResume();
    }
    public void onBaseActivityResume() {
        Iterator i$ = mSubscribers.iterator();
        while(i$.hasNext()) {
            IActivityLife mLife = (IActivityLife)i$.next();
            mLife.onResume(this);
        }
    }

    protected void onPause() {
        super.onPause();
        this.onBaseActivityPause();
    }

    public void onBaseActivityPause() {
        Iterator i$ = mSubscribers.iterator();
        while(i$.hasNext()) {
            IActivityLife mLife = (IActivityLife)i$.next();
            mLife.onPause(this);
        }
    }

    protected void onStop() {
        super.onStop();
        onBaseActivityStop();
    }
    public void onBaseActivityStop() {
        Iterator i$ = mSubscribers.iterator();
        while(i$.hasNext()) {
            IActivityLife mLife = (IActivityLife)i$.next();
            mLife.onStop(this);
        }
    }
    protected void onDestroy() {
        super.onDestroy();
       onBaseActivityDestroy();
    }
    public void onBaseActivityDestroy(){
        Iterator i$ = mSubscribers.iterator();
        while(i$.hasNext()) {
            IActivityLife mLife = (IActivityLife)i$.next();
            mLife.onDestroy(this);
        }
    }

    public static void addSubscriber(IActivityLife _activityLife) {
        mSubscribers.add(_activityLife);
    }
}
