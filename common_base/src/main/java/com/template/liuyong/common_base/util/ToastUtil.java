package com.template.liuyong.common_base.util;

import android.app.Activity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.template.liuyong.common_base.R;

/**
 * @author 创建人 liuyong
 * @project 项目名称 TemplateProject
 * @package 包名 com.template.liuyong.common_base.util
 * @describe ‍统一提示语
 * @time 创建时间 2019/1/16 10:35
 * @change 修改内容
 * @changetime 修改时间
 * @changeauthor 修改人
 */
public class ToastUtil {

    /**
     * 设置长提示
     * @param activity
     * @param args
     */
    public static void showToast(Activity activity,String args){
        if(null == args){
            args = activity.getResources().getString(R.string.default_tip);
        }
        Toast toast = new Toast(activity);
        View view = LayoutInflater.from(activity).inflate(R.layout.toast_view,null);
        toast.setView(view);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.setDuration(Toast.LENGTH_LONG);
        TextView textView = view.findViewById(R.id.tv_content);
        textView.setText(args);
        toast.show();
    }

}
