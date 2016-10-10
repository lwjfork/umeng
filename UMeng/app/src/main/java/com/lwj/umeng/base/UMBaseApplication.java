package com.lwj.umeng.base;

import android.app.Application;

import com.lwj.umeng.iml.UmengActivityLife;
import com.lwj.umeng.iml.UmengFragmentLife;
import com.lwj.umeng.ui.UMengBaseActivity;
import com.lwj.umeng.ui.UMengBaseFragment;
import com.lwj.umeng.utils.ChannelUtil;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.MobclickAgent;

/**
 * Created by lwj on 2015/8/6.
 */
public class UMBaseApplication extends Application {

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
        //动态获取渠道
        AnalyticsConfig.setChannel(ChannelUtil.getChannel(this));

        //搞这个是为了更好的统计ativity 与 framgent
        MobclickAgent.openActivityDurationTrack(false);
        initActivitySubscriber();
    }

    /**
     * 对生命周期进行 友盟 注入
     */
    private void initActivitySubscriber() {
        UMengBaseActivity.addSubscriber(new UmengActivityLife());
        UMengBaseFragment.addSubscriber(new UmengFragmentLife());

    }

}
