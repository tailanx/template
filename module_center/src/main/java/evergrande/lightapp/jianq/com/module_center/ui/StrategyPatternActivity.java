package evergrande.lightapp.jianq.com.module_center.ui;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.template.liuyong.common_base.ui.BaseActivity;
import com.template.liuyong.common_base.util.ARouterConfiger;

import evergrande.lightapp.jianq.com.module_center.R;
import evergrande.lightapp.jianq.com.module_center.pattern.strategy.Duck;
import evergrande.lightapp.jianq.com.module_center.pattern.strategy.Fly;
import evergrande.lightapp.jianq.com.module_center.pattern.strategy.FlyAbleA;
import evergrande.lightapp.jianq.com.module_center.pattern.strategy.NothingVoice;
import evergrande.lightapp.jianq.com.module_center.pattern.strategy.RedDuck;
import evergrande.lightapp.jianq.com.module_center.pattern.strategy.Voice;

/**
 * @author 创建人 liuyong
 * @project 项目名称 TemplateProject
 * @package 包名 evergrande.lightapp.jianq.com.module_center.pattern
 * @describe 策略模式
 * @time 创建时间 2019/1/18 10:24
 * @change 修改内容
 * @changetime 修改时间
 * @changeauthor 修改人
 */
@Route(path = ARouterConfiger.STRAREGY_PATTERN)
public class StrategyPatternActivity extends BaseActivity {

    @Override
    public int getView() {
        return R.layout.activity_strategy;
    }

    @Override
    public void initView() {
        setHeadline(R.string.pattern_strategy);
        Voice voice  = new NothingVoice();
        Fly fly = new FlyAbleA();
        Duck duck = new RedDuck(fly,voice);
        duck.cry(this);
    }

}
