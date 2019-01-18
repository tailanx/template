package com.template.liuyong.common_base.ui;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;

import com.template.liuyong.common_base.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author 创建人 liuyong
 * @project 项目名称 TemplateProject
 * @package 包名 com.template.liuyong.common_base.ui
 * @describe 类描述
 * @time 创建时间 2019/1/4 15:54
 * @change 修改内容
 * @changetime 修改时间
 * @changeauthor 修改人
 */
public  abstract  class BaseFragment extends Fragment {
    protected Activity activity;
    private ViewStub viewStub;
    protected View view;
    private Unbinder unbinder;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity  = (Activity) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_base,container,false);
        ((FrameLayout)view.findViewById(R.id.fm_activity)).addView(inflater.inflate(resview(),null));
        unbinder = ButterKnife.bind(this,view);
        initView();
        return view  ;
    }

    public abstract  int resview();

    public abstract  void initView();

    /**
     *设置空的页面
     */
    public void showEmptyView(){
        if(null == viewStub){
            viewStub = view.findViewById(R.id.vs_empty);
            viewStub.inflate();
        }else{
            viewStub.setVisibility(View.VISIBLE);
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if(null != unbinder){
            unbinder.unbind();
            unbinder = null;
        }
    }
}
