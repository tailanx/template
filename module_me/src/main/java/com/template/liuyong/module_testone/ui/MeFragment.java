package com.template.liuyong.module_testone.ui;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.template.liuyong.common_base.ui.BaseFragment;
import com.template.liuyong.common_base.util.ARouterConfiger;
import com.template.liuyong.module_testone.R;

/**
 * @author 创建人 liuyong
 * @project 项目名称 TemplateProject
 * @package 包名 com.template.liuyong.module_testone
 * @describe 类描述
 * @time 创建时间 2019/1/10 09:06
 * @change 修改内容
 * @changetime 修改时间
 * @changeauthor 修改人
 */
@Route(path = ARouterConfiger.MEMENU)
public class MeFragment  extends BaseFragment {
    @Override
    public int resview() {
        return R.layout.fragment_me;
    }

    @Override
    public void initView() {

    }
}
