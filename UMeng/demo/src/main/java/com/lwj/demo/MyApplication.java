package com.lwj.demo;

import android.app.Application;

import com.lwj.umeng.iml.UmengActivityLife;
import com.lwj.umeng.iml.UmengFragmentLife;
import com.lwj.umeng.ui.UMengBaseActivity;
import com.lwj.umeng.ui.UMengBaseFragment;
import com.umeng.analytics.MobclickAgent;

/**
 * Created by lwj on 16/10/11.
 * liuwenjie@goumin.com
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        MobclickAgent.setDebugMode(true);
        // 初始化友盟参数
        initUmeng();
    }


    /**
     * 初始化Umeng的参数
     */
    private void initUmeng() {

        //搞这个是为了更好的统计ativity 与 framgent
        MobclickAgent.openActivityDurationTrack(false);
        initActivitySubscriber();
    }

    /**
     * 对生命周期进行 友盟 注入
     */
    private void initActivitySubscriber() {
        /**
         *  此处的 UmengActivityLife和UmengFragmentLife  是一个默认的实现
         *  你也可以使用实现AbsActivityLife或者AbsFragmentLife 来自定义自己的统计页面
         */
        /**
         *  默认实现
         */
//        UMengBaseActivity.addSubscriber(new UmengActivityLife());
//        UMengBaseFragment.addSubscriber(new UmengFragmentLife());



        /**
         *    以 activity 的label 为别名
         */
//        UMengBaseActivity.addSubscriber(new ByLabelActivityLife());
//        UMengBaseFragment.addSubscriber(new UmengFragmentLife());

        /**
         *  以 string 资源为别名
         */
        UMengBaseActivity.addSubscriber(new ByStrActivityLife());
        UMengBaseFragment.addSubscriber(new ByStrFragmentLife());


    }

}
