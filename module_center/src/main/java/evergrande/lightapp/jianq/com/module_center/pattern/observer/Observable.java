package evergrande.lightapp.jianq.com.module_center.pattern.observer;

import android.app.Activity;

/**
 * @author 创建人 liuyong
 * @project 项目名称 TemplateProject
 * @package 包名 evergrande.lightapp.jianq.com.module_center.pattern.observer
 * @describe 被观察者
 * @time 创建时间 2019/1/18 16:25
 * @change 修改内容
 * @changetime 修改时间
 * @changeauthor 修改人
 */
public interface Observable<T> {

      void  add(T object);
      boolean  delete(T object);
      void updata(Activity activity);
}
