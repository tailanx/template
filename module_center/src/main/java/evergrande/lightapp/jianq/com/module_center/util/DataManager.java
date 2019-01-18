package evergrande.lightapp.jianq.com.module_center.util;

import java.util.ArrayList;

import evergrande.lightapp.jianq.com.module_center.bean.BaseBean;
import evergrande.lightapp.jianq.com.module_center.bean.PatternBean;
import evergrande.lightapp.jianq.com.module_center.bean.StudyBean;

/**
 * @author 创建人 liuyong
 * @project 项目名称 TemplateProject
 * @package 包名 evergrande.lightapp.jianq.com.module_center
 * @describe 类描述
 * @time 创建时间 2019/1/17 09:44
 * @change 修改内容
 * @changetime 修改时间
 * @changeauthor 修改人
 */

public class DataManager {

    /**
     * 获取数据
     * @return
     */
    public static ArrayList<BaseBean> getStudyBean(){
        ArrayList arrayList = new ArrayList();
        StudyBean studyBean = new StudyBean();
        studyBean.setName("设计模式");
        studyBean.setType(1);
        arrayList.add(studyBean);

        StudyBean studyBean2 = new StudyBean();
        studyBean2.setName("设计模式2");
        studyBean2.setType(1);
        arrayList.add(studyBean2);

        StudyBean studyBean3 = new StudyBean();
        studyBean3.setName("设计模式3");
        studyBean3.setType(1);
        arrayList.add(studyBean3);

        StudyBean studyBean4 = new StudyBean();
        studyBean4.setName("设计模4");
        studyBean4.setType(1);
        arrayList.add(studyBean4);

        StudyBean studyBean5 = new StudyBean();
        studyBean5.setName("设计模式5");
        studyBean5.setType(1);
        arrayList.add(studyBean5);

        return  arrayList;
    }


    public static ArrayList<BaseBean> getPatternData(){
        ArrayList arrayList = new ArrayList();
        PatternBean studyBean = new PatternBean();
        studyBean.setName("策略模式");
        studyBean.setType(1);
        arrayList.add(studyBean);

        PatternBean studyBean2 = new PatternBean();
        studyBean2.setName("观察者模式");
        studyBean2.setType(2);
        arrayList.add(studyBean2);

        PatternBean studyBean3 = new PatternBean();
        studyBean3.setName("装饰模式");
        studyBean3.setType(3);
        arrayList.add(studyBean3);

        PatternBean studyBean4 = new PatternBean();
        studyBean4.setName("工厂模式");
        studyBean4.setType(4);
        arrayList.add(studyBean4);

        PatternBean studyBean5 = new PatternBean();
        studyBean5.setName("单例模式");
        studyBean5.setType(5);
        arrayList.add(studyBean5);

        return  arrayList;
    }

}
