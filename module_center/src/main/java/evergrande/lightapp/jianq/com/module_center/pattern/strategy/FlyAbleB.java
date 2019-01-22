package evergrande.lightapp.jianq.com.module_center.pattern.strategy;

import android.app.Activity;

import com.template.liuyong.common_base.util.ToastUtil;

/**
 * @author 创建人 liuyong
 * @project 项目名称 TemplateProject
 * @package 包名 evergrande.lightapp.jianq.com.module_center.pattern.strategy
 * @describe 类描述
 * @time 创建时间 2019/1/18 15:18
 * @change 修改内容
 * @changetime 修改时间
 * @changeauthor 修改人
 */
public class FlyAbleB implements Fly {
    @Override
    public void fly(Activity context) {
        ToastUtil.showToast(context,"FlyAbleB");
    }
}
