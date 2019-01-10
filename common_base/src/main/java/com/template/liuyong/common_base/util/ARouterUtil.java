package com.template.liuyong.common_base.util;

import com.alibaba.android.arouter.launcher.ARouter;
import com.template.liuyong.common_base.ui.BaseActivity;
import com.template.liuyong.common_base.ui.BaseFragment;

/**
 * @author 创建人 liuyong
 * @project 项目名称 TemplateProject
 * @package 包名 com.template.liuyong.common_base.util
 * @describe 获取跳转页面
 * @time 创建时间 2019/1/4 15:53
 * @change 修改内容
 * @changetime 修改时间
 * @changeauthor 修改人
 */
public class ARouterUtil {

    public  static BaseFragment getFragment(String urlFragment) {
        return (BaseFragment) ARouter.getInstance().build(urlFragment).navigation();
    }

    public static  BaseActivity getActivity(String urlActivity) {
        return (BaseActivity) ARouter.getInstance().build(urlActivity).navigation();
    }
}
