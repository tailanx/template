package evergrande.lightapp.jianq.com.module_center.pattern.observer;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 创建人 liuyong
 * @project 项目名称 TemplateProject
 * @package 包名 evergrande.lightapp.jianq.com.module_center.pattern.observer
 * @describe 类描述
 * @time 创建时间 2019/1/18 16:26
 * @change 修改内容
 * @changetime 修改时间
 * @changeauthor 修改人
 */
public class ObservableImpl implements Observable<Observer> {

    List<Observer> list = new ArrayList<>();

    public ObservableImpl(){

    }
    @Override
    public void add(Observer object) {
        if(null != object){
            if(!list.contains(object)) {
                list.add(object);
            }
        }

    }

    @Override
    public boolean delete(Observer object) {
        if(null != object){
            list.remove(object);
        }
        return false;
    }

    @Override
    public void updata(Activity activity) {
        if(null != list   && !list.isEmpty()){
            for (Observer observer :list){
                observer.getnewspaper(activity);
            }
        }

    }
}
