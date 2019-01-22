package com.template.liuyong.common_base.util;

/**
 * @author 创建人 liuyong
 * @project 项目名称 TemplateProject
 * @package 包名 com.template.liuyong.common_base.util
 * @describe 类描述
 * @time 创建时间 2019/1/9 16:52
 * @change 修改内容
 * @changetime 修改时间
 * @changeauthor 修改人
 */
public interface ARouterConfiger {
    /**
     * 菜单
     */
      String FOODMENU = "/home/HomeFragment";

    /**
     * me 菜单
     */
    String MEMENU = "/me/MeFragment";

    /**
     * center 菜单
     */
    String CENTERMENU = "/center/CenterFragment";

    /**
     * 设计模式页面
     */
    String PATTERN_ACTIVITY = "/center/PatternActivity";

    /**
     * 策略模式
     */
    String STRAREGY_PATTERN = "/center/StrategyPatternActivity";

    /**
     * 测试
     */
    String ACTIVITY_TEST= "/test/Activity";

    /**
     * 主页面
     */
    String MAINACTIITY = "/app/MainActivity";



}
