package com.template.liuyong.common_base;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * @author 创建人 liuyong
 * @project 项目名称 TemplateProject
 * @package 包名 com.template.liuyong.common_base
 * @describe 类描述
 * @time 创建时间 2019/1/4 10:18
 * @change 修改内容
 * @changetime 修改时间
 * @changeauthor 修改人
 */
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initRouter();
    }

    private  void initRouter(){
        if (BuildConfig.DEBUG) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this); // 尽可能早，推荐在Application中初始化
    }


}
