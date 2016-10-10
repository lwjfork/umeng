package com.lwj.umeng.utils;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import java.util.HashMap;
import java.util.List;

/**
 * Created by lwj on 2015/8/6.
 *
 */
public class AnalysisUtil {
    public AnalysisUtil() {
    }

    public static void onResume(Activity ac) {
        if(ac instanceof FragmentActivity){

            List<Fragment> fragments = ((FragmentActivity) ac).getSupportFragmentManager().getFragments();
            if(null != fragments && fragments.size() >0){
                onResume(ac, false);
            }else {
                onResume(ac, true);
            }
        }else {
            onResume(ac, true);
        }
    }

    public static void onResume(Activity ac, boolean isPage) {
        String acName = ac.getClass().getSimpleName().toString();
        onResume(ac, isPage, acName);
    }

    public static void onResume(Activity ac, String eventId) {
        onResume(ac, true, eventId);
    }

    public static void onResume(Activity ac, boolean isPage, String eventId) {
        if(isPage) {
            MobclickAgent.onPageStart(eventId);
        }

        MobclickAgent.onResume(ac);
    }

    public static void onPause(Activity ac, String eventId) {
        onPause(ac, true, eventId);
    }

    public static void onPause(Activity ac, boolean isPage) {
        String acName = ac.getClass().getSimpleName().toString();
        onPause(ac, isPage, acName);
    }

    public static void onPause(Activity ac) {
        String acName = ac.getClass().getSimpleName().toString();
        if(ac instanceof FragmentActivity){
            List<Fragment> fragments = ((FragmentActivity) ac).getSupportFragmentManager().getFragments();
            if(null != fragments && fragments.size() >0){
                onPause(ac, false, acName);
            }else {
                onPause(ac, true, acName);
            }
        }else {
            onPause(ac, true, acName);
        }
    }

    public static void onPause(Activity ac, boolean isPage, String eventId) {
        if(isPage) {
            MobclickAgent.onPageEnd(eventId);
        }

        MobclickAgent.onPause(ac);
    }

    public static void onPause(Fragment fg) {
        if(fg != null) {
            String fgClass = fg.getClass().getSimpleName().toString();
            MobclickAgent.onPageEnd(fgClass);
        }

    }

    public static void onResume(Fragment fg) {
        if(fg != null) {
            String fgClass = fg.getClass().getSimpleName().toString();
            MobclickAgent.onPageStart(fgClass);
        }

    }

    public static void onEvent(Context ctx, String eventID) {
        MobclickAgent.onEvent(ctx, eventID);
    }

    public static void onEvent(Context ctx, String eventID, HashMap<String, String> map) {
        MobclickAgent.onEvent(ctx, eventID, map);
    }

    public static void onEvent(Context ctx, String eventID, String item) {
        MobclickAgent.onEvent(ctx, eventID, item);
    }
}
