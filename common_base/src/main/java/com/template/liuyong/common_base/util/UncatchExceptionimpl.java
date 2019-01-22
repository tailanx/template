package com.template.liuyong.common_base.util;

import android.content.Context;
import android.content.Intent;

import com.template.liuyong.common_base.bean.CrashBean;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author 创建人 liuyong
 * @project 项目名称 TemplateProject
 * @package 包名 com.template.liuyong.common_base.util
 * @describe 类描述
 * @time 创建时间 2019/1/22 14:25
 * @change 修改内容
 * @changetime 修改时间
 * @changeauthor 修改人
 */
public class UncatchExceptionimpl implements UnCatchException<CrashBean>, Thread.UncaughtExceptionHandler {

    private static UncatchExceptionimpl unCatchException;

    private Context context;

    private UncatchExceptionimpl() {

    }

    public static UncatchExceptionimpl getInstance() {
        if (null == unCatchException) {
            synchronized (UncatchExceptionimpl.class) {
                if (null == unCatchException) {
                    unCatchException = new UncatchExceptionimpl();
                }
            }
        }
        return unCatchException;
    }

    /**
     * 初始化
     * @param context
     */

    public void init(Context context){
        this.context = context;
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override
    public void showMsg(CrashBean crashBean) {
//        ARouterUtil.getActivity(ARouterConfiger.ACTIVITY_CRASH);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        CrashBean bean = parse(e);
        showMsg(bean);
    }

    private CrashBean parse(Throwable ex){
        CrashBean crashBean  = new CrashBean();

        try {
            crashBean.setEx(ex);
            crashBean.setTime(System.currentTimeMillis());
            if (ex.getCause() != null) {
                ex = ex.getCause();
            }
            crashBean.setExceptionMsg(ex.getMessage());
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            pw.flush();
            String exceptionType = ex.getClass().getName();

            if (ex.getStackTrace() != null && ex.getStackTrace().length > 0) {
                StackTraceElement element = ex.getStackTrace()[0];

                crashBean.setLineNumber(element.getLineNumber());
                crashBean.setClassName(element.getClassName());
                crashBean.setFileName(element.getFileName());
                crashBean.setMethodName(element.getMethodName());
                crashBean.setExceptionType(exceptionType);
            }

            crashBean.setFullException(sw.toString());
        } catch (Exception e) {
            return crashBean;
        }

        return crashBean;
    }
}
