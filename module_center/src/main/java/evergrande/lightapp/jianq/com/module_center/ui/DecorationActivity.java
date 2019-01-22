package evergrande.lightapp.jianq.com.module_center.ui;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.template.liuyong.common_base.ui.BaseActivity;
import com.template.liuyong.common_base.util.ARouterConfiger;

import evergrande.lightapp.jianq.com.module_center.R;

/**
 * @author 创建人 liuyong
 * @project 项目名称 TemplateProject
 * @package 包名 evergrande.lightapp.jianq.com.module_center.ui
 * @describe 类描述
 * @time 创建时间 2019/1/18 17:06
 * @change 修改内容
 * @changetime 修改时间
 * @changeauthor 修改人
 */
@Route(path = ARouterConfiger.DECORATION_PATTERN)
public class DecorationActivity extends BaseActivity {
    @Override
    public int getView() {
        return R.layout.activity_decoraion;
    }

    @Override
    public void initView() {
        setHeadline(getResources().getString(R.string.pattern_decoration));
    }
}
