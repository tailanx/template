package evergrande.lightapp.jianq.com.module_center.ui;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.template.liuyong.common_base.ui.BaseActivity;
import com.template.liuyong.common_base.util.ARouterConfiger;

import evergrande.lightapp.jianq.com.module_center.R;
import evergrande.lightapp.jianq.com.module_center.pattern.observer.ObservableImpl;
import evergrande.lightapp.jianq.com.module_center.pattern.observer.ObserverOne;
import evergrande.lightapp.jianq.com.module_center.pattern.observer.ObserverTwo;

/**
 * @author 创建人 liuyong
 * @project 项目名称 TemplateProject
 * @package 包名 evergrande.lightapp.jianq.com.module_center.ui
 * @describe 观察者
 * @time 创建时间 2019/1/18 16:13
 * @change 修改内容
 * @changetime 修改时间
 * @changeauthor 修改人
 */
@Route(path = ARouterConfiger.OBSERVER_PATTERN)
public class ObservableActivity extends BaseActivity {


    @Override
    public int getView() {
        return R.layout.activity_observer;
    }

    @Override
    public void initView() {
        setTitle(R.string.pattern_observer);
        ObservableImpl observableimpl = new ObservableImpl();
        ObserverOne observerOne = new ObserverOne();
        ObserverTwo observerTwo = new ObserverTwo();
        observableimpl.add(observerTwo);
        observableimpl.updata(this);
    }
}
