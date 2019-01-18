package evergrande.lightapp.jianq.com.module_center.ui;

import android.app.FragmentManager;
import android.app.FragmentTransaction;

import com.template.liuyong.common_base.ui.BaseActivity;
import com.template.liuyong.common_base.ui.BaseFragment;
import com.template.liuyong.common_base.util.ARouterConfiger;
import com.template.liuyong.common_base.util.ARouterUtil;

import evergrande.lightapp.jianq.com.module_center.R;

/**
 * @author 创建人 liuyong
 * @project 项目名称 TemplateProject
 * @package 包名 evergrande.lightapp.jianq.com.module_center.ui
 * @describe 类描述
 * @time 创建时间 2019/1/10 10:00
 * @change 修改内容
 * @changetime 修改时间
 * @changeauthor 修改人
 */
public class CenterActivity extends BaseActivity {
    BaseFragment baseFragment = ARouterUtil.getFragment(ARouterConfiger.CENTERMENU);

    @Override
    public int getView() {
        return R.layout.activity_center;
    }

    @Override
    public void initView() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.ft_content,baseFragment);
        ft.commit();
    }
}
