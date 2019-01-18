package com.template.liuyong.common_base.util;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * @author 创建人 liuyong
 * @project 项目名称 TemplateProject
 * @package 包名 com.template.liuyong.common_base.util
 * @describe 类描述
 * @time 创建时间 2019/1/11 15:11
 * @change 修改内容
 * @changetime 修改时间
 * @changeauthor 修改人
 */
public class StatubarUtil {
    /**
     * 设置全屏，并且将状态栏的颜色改为透明
     */
    public static void setStatuBarVisiblity(Activity activity){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            Window  window  =  activity.getWindow();
            if(Build.VERSION.SDK_INT  >= Build.VERSION_CODES.LOLLIPOP){
                 View view  = window.getDecorView();
                 int flag =View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
                 window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                 view.setSystemUiVisibility(flag);
                 window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                 window.setStatusBarColor(Color.TRANSPARENT);
            }else{
                WindowManager.LayoutParams layoutParams  = window.getAttributes();
                int flag = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
                layoutParams.flags |= flag;
                window.setAttributes(layoutParams);

            }
        }
    }

    /**
     * 设置statubar字体的颜色
     * @param activity
     * @param isBlack
     */
    public static void setStatuBarFont(Activity activity,boolean isBlack){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if(isBlack){
                activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }else{
                activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
            }
        }

    }
}
