package com.template.liuyong.module_home.ui;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.template.liuyong.common_base.ui.BaseFragment;
import com.template.liuyong.common_base.util.ARouterConfiger;
import com.template.liuyong.module_home.R;

/**
 * @author 创建人 liuyong
 * @project 项目名称 TemplateProject
 * @package 包名 com.template.liuyong.module_home.ui
 * @describe 类描述
 * @time 创建时间 2019/1/4 16:48
 * @change 修改内容
 * @changetime 修改时间
 * @changeauthor 修改人
 */
@Route(path = ARouterConfiger.FOODMENU)
public class HomeFragment extends BaseFragment {

    @Override
    public int resview() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView() {

    }
}
