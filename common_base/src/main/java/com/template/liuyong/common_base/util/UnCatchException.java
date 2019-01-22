package com.template.liuyong.common_base.util;

/**
 * @author 创建人 liuyong
 * @project 项目名称 TemplateProject
 * @package 包名 com.template.liuyong.common_base.util
 * @describe 类描述
 * @time 创建时间 2019/1/22 14:24
 * @change 修改内容
 * @changetime 修改时间
 * @changeauthor 修改人
 */
public interface UnCatchException<T> {
    void showMsg(T t);
}
