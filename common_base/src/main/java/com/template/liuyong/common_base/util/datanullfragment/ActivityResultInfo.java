package com.template.liuyong.common_base.util.datanullfragment;

import android.content.Intent;

/**
 * @author 创建人 liuyong
 * @project 项目名称 TemplateProject
 * @package 包名 com.template.liuyong.templateproject.datanullfragment
 * @describe 类描述
 * @time 创建时间 2018/11/13 16:49
 * @change 修改内容
 * @changetime 修改时间
 * @changeauthor 修改人
 */
public class ActivityResultInfo {

    private Intent intent;
    private int requestCode;
    private int resultCode;

    public ActivityResultInfo(int requestCode,int resultCode,Intent intent){
        this.intent = intent;
        this.requestCode = requestCode;
        this.resultCode = resultCode;
    }

    public Intent getIntent() {
        return intent;
    }

    public void setIntent(Intent intent) {
        this.intent = intent;
    }

    public int getRequestCode() {
        return requestCode;
    }

    public void setRequestCode(int requestCode) {
        this.requestCode = requestCode;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }
}
