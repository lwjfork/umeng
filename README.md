# umeng
友盟统计库

##  统计事件
 调用 AnalysisUtil 类的 onEvent 系列的方法
 
## 页面统计
### 第一步
所有需要统计的activity 都继承  UMengBaseActivity

所有需要统计的fragment 都继承 UMengBaseFragment 

###  第二步 
> 在  application 里注入activity和fragment的统计生命周期类
>
> 有默认的实现  UmengActivityLife 和 UmengFragmentLife 

在**Application**加入代码(onCreate方法里初始化友盟)

```
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
        UMengBaseActivity.addSubscriber(new UmengActivityLife());
        UMengBaseFragment.addSubscriber(new UmengFragmentLife());

    }
```



##### UmengActivityLife  
>  activity 的默认生命周期类 实现了  AbsActivityLife 的 onResume 和  onPause 两个方法来进行页面的统计
> 
> 默认页面的名称都是 **类** 名
> 

#### UmengFragmentLife
>  fragment 的默认生命周期类 实现了  AbsFragmentLife 的 onResume 和  onPause 两个方法来进行页面的统计
> 
> 默认页面的名称都是 **类** 名
> 
> 

###Tips
1. 当我想自定义自己的activity的别名而不是默认以activity的类名为统计名
  你可以自己实现AbsActivityLife 然后在 **Application**的 **initActivitySubscriber** 方法里注入 UMengBaseActivity.addSubscriber(**你自己的统计类**);
 
 例如
 
    
  ```
    public class MyUmengActivityLife extends AbsActivityLife {
    public MyUmengActivityLife() {
    }

    public void onResume(Activity _activity) {
        super.onResume(_activity);
        AnalysisUtil.onResume(_activity,你自己设置的别名);
        Log.v("UmengFragmentLife >>%s", "onResume");
    }

    public void onPause(Activity _activity) {
        super.onPause(_activity);
        AnalysisUtil.onPause(_activity,你自己设置的别名);
        Log.v("UmengFragmentLife >>%s", "onPause");
    }
}
  ```  
  
2. 当你想自定义 fragment 的别名时 与 自定义 activity的别名同理

3. 自定义  activity 的别名－终极简化方法
   1. 在 AndroidManifest.xml 里需要统计的 activity的节点上加入 **label**属性 此属性的value值就是你要统计的别名
   2. 定义你的 AbsActivityLife 在 在 **Application**的 **initActivitySubscriber** 方法里注入 UMengBaseActivity.addSubscriber(**你自己的统计类**);
   
   ```
    public class MyUmengActivityLife extends UmengActivityLife {
    @Override
    public void onResume(Activity _activity) {
        super.onResume(_activity);
        try {
           String title  = _activity.getTitle().toString();
            if(title.length()==0){
                AnalysisUtil.onResume(_activity);
            }else {
                AnalysisUtil.onResume(_activity,title); 
            }

        } catch (Exception e) {
            e.printStackTrace();
            AnalysisUtil.onResume(_activity);
        }
    }

    @Override
    public void onPause(Activity _activity) {
        super.onPause(_activity);
        try {
            String title  = _activity.getTitle().toString();
            if(title.length()==0){
                AnalysisUtil.onPause(_activity);
            }else {
                AnalysisUtil.onPause(_activity,title);
            }

        } catch (Exception e) {
            e.printStackTrace();
            AnalysisUtil.onPause(_activity);
        }
    }
}
   ```
  