package evergrande.lightapp.jianq.com.module_center.pattern.strategy;

import android.app.Activity;

/**
 * @author 创建人 liuyong
 * @project 项目名称 TemplateProject
 * @package 包名 evergrande.lightapp.jianq.com.module_center.pattern.strategy
 * @describe 类描述
 * @time 创建时间 2019/1/18 15:09
 * @change 修改内容
 * @changetime 修改时间
 * @changeauthor 修改人
 */
public abstract class Duck {

    Fly fly ;
    Voice voice;

    public Fly getFly() {
        return fly;
    }

    public void setFly(Fly fly) {
        this.fly = fly;
    }

    public Voice getVoice() {
        return voice;
    }

    public void setVoice(Voice voice) {
        this.voice = voice;
    }

    public abstract  void play();

    public abstract  void fei(Activity activity);
    public abstract  void cry(Activity activity);


}
