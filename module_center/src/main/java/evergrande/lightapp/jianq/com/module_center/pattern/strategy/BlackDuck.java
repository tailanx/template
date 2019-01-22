package evergrande.lightapp.jianq.com.module_center.pattern.strategy;

import android.app.Activity;

/**
 * @author 创建人 liuyong
 * @project 项目名称 TemplateProject
 * @package 包名 evergrande.lightapp.jianq.com.module_center.pattern.strategy
 * @describe 类描述
 * @time 创建时间 2019/1/18 15:30
 * @change 修改内容
 * @changetime 修改时间
 * @changeauthor 修改人
 */
public class BlackDuck extends Duck {


    public BlackDuck(Fly fly,Voice voice){
        this.fly = fly;
        this.voice = voice;
    }

    @Override
    public  void play() {

    }

    @Override
    public void fei(Activity activity) {
        this.fly.fly(activity);
    }

    @Override
    public void cry(Activity activity) {
        this.voice.makeVoice(activity);
    }
}
