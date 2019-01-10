package com.template.liuyong.common_base.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.template.liuyong.common_base.R;
import com.template.liuyong.common_base.util.ActivityManager;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author 创建人 liuyong
 * @project 项目名称 TemplateProject
 * @package 包名 com.template.liuyong.common_base
 * @describe 类描述
 * @time 创建时间 2019/1/4 10:11
 * @change 修改内容
 * @changetime 修改时间
 * @changeauthor 修改人
 */
public abstract class BaseActivity extends AppCompatActivity {
    private Toolbar toolbar ;
    private Unbinder unbinder;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        View view  ;
        if(!isNeedToolbar()){
            view = LayoutInflater.from(this).inflate(getView(),null);
        }else{
            view =  LayoutInflater.from(this).inflate(R.layout.activity_toolbar,null);
            toolbar = view.findViewById(R.id.tb_activity);
            setActions();
            FrameLayout frameLayout  = findViewById(R.id.fm_activity);
            View contentview  = LayoutInflater.from(this).inflate(getView(),null);
            frameLayout.addView(contentview);
        }
        setContentView(view);
        unbinder = ButterKnife.bind(this);
        initView();
    }

    public abstract int getView();

    public abstract void initView();


    /**
     * 设置toolbar
     */
    private void setActions(){
        setSupportActionBar(toolbar);
        toolbar.setBackgroundResource(R.color.color_b3);
        toolbar.setNavigationIcon(R.drawable.nav_back);
        toolbar.setNavigationOnClickListener(view -> BaseActivity.this.finish());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityManager.getInstance().removeActivity(this);
        if(null != unbinder) {
            unbinder.unbind();
            unbinder= null;
        }

    }

    /**
     * 是否添加toolbar
     * @return
     */
    protected  boolean isNeedToolbar(){
        return false;
    }

}
