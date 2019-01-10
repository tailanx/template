package com.template.liuyong.common_base.util;

import android.app.Activity;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 创建人 liuyong
 * @project 项目名称 TemplateProject
 * @package 包名 com.template.liuyong.common_base.ui.util
 * @describe 用来管理界面的
 * @time 创建时间 2019/1/4 11:07
 * @change 修改内容
 * @changetime 修改时间
 * @changeauthor 修改人
 */
public class ActivityManager {

    private List<Activity> activities;
    private static ActivityManager instance;

    private ActivityManager() {
    }
    public static ActivityManager getInstance(){
       if(null == instance){
           synchronized (ActivityManager.class){
               if(null == instance) {
                   instance = new ActivityManager();
               }
           }
        }
        return instance;
    }

    /**
     * 添加activity
     * @param activity
     */
    public void addActivity(Activity activity) {
        if (null != activities){
            if(!activities.contains(activity)){
                activities.add(activity);
            }
        }else{
            activities = new ArrayList<>();
            activities.add(activity);
        }
    }

    /**
     * 移除activity
     * @param activity
     */
    public void  removeActivity(Activity activity){
        if(null != activities){
            activities.remove(activity);
        }
    }

    /**
     * 获取当前的activity
     * @return
     */
    public Activity getCurrentActivity(){
        if(null != activities && activities.size() >0){
            return activities.get(activities.size() -1);
        }
        return null;
    }

    /**
     * 获取制定的activity
     * @param clsName
     * @return
     */
    public Activity getActivity(String clsName){
        Activity targetActivity = null;
        for (Activity activity :activities){
            if(TextUtils.equals(activity.getClass().getSimpleName(),clsName)){
                targetActivity = activity;
            }
        }
        return targetActivity;
    }

    /**
     * 退出程序
     */
    public void exitApp(){
        if(null != activities  ){
            for (Activity activity:activities){
                if(null != activity) {
                    activity.finish();
                }
            }
        }
    }

}
