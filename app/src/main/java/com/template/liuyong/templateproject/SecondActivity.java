package com.template.liuyong.templateproject;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.template.liuyong.templateproject.R;

/**
 * @author 创建人 liuyong
 * @project 项目名称 TemplateProject
 * @package 包名 com.template.liuyong.templateproject.datanullfragment
 * @describe 类描述
 * @time 创建时间 2018/11/13 17:29
 * @change 修改内容
 * @changetime 修改时间
 * @changeauthor 修改人
 */
public class SecondActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        findViewById(R.id.tv_content).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SecondActivity.this.finish();
            }
        });
    }

    @Override
    public void finish() {
        setResult(100000);
        super.finish();
    }
}
