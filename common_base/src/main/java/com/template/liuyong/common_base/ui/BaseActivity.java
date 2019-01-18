package com.template.liuyong.common_base.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.template.liuyong.common_base.R;
import com.template.liuyong.common_base.util.ActivityManager;
import com.template.liuyong.common_base.util.StatubarUtil;
import com.trello.rxlifecycle2.components.RxActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
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
public abstract class BaseActivity extends RxActivity  {

    private Toolbar toolbar ;
    private Unbinder unbinder;

//    /**
//     * 切换布局
//     */
     protected TextView tvChange;
//    @BindView(R.id.back_iv)
    protected  ImageView ivView;
    protected  TextView tvTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置状态栏
        StatubarUtil.setStatuBarVisiblity(this);
        //设置状态栏的字体
        StatubarUtil.setStatuBarFont(this,true);
        ActivityManager.getInstance().addActivity(this);
        View view  ;
//        if(!isNeedToolbar()){
//            view = LayoutInflater.from(this).inflate(getView(),null);
//        }else{
            view =  LayoutInflater.from(this).inflate(R.layout.activity_toolbar,null);
            setActions();
            FrameLayout frameLayout  = view.findViewById(R.id.fm_activity);
        tvChange  = view.findViewById(R.id.title_right_tv);
        ivView  = view.findViewById(R.id.back_iv);
        tvTitle  = view.findViewById(R.id.title_tv);
            View contentview  = LayoutInflater.from(this).inflate(getView(),null);
            frameLayout.addView(contentview);
//        }
        setContentView(view);
        unbinder = ButterKnife.bind(this,view);
        initView();
        ivView.setOnClickListener(v -> {
                BaseActivity.this.finish() ;});
    }

    /**
     * 设置是否能够看见
     * @param isVisi true 能看见，false 不能看见
     */
    public void setRightTextVis(boolean isVisi){
        if(null!= tvChange){
            tvChange.setVisibility(isVisi?View.VISIBLE:View.GONE);
        }

    }

    public TextView getTvChange() {
        return tvChange;
    }

    public ImageView getIvView() {
        return ivView;
    }

    public TextView getTvTitle() {
        return tvTitle;
    }

    public abstract int getView();

    public abstract void initView();


    public void setHeadline(int res){
        setHeadline(getResources().getString(res));
    }
    /**
     * 设置title
     */
    public void setHeadline(String title){
        if(null != tvTitle && !TextUtils.isEmpty(title)){
            tvTitle.setText(title);
        }
    }

    /**
     * 设置toolbar
     */
    private void setActions(){
//        setSupportActionBar(toolbar);
//        toolbar.setBackgroundResource(R.color.color_b3);
//        toolbar.setNavigationIcon(R.drawable.nav_back);
//        toolbar.setNavigationOnClickListener(view -> BaseActivity.this.finish());
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

//    /**
//     * 是否添加toolbar
//     * @return
//     */
//    protected  boolean isNeedToolbar(){
//        return false;
//    }

}
