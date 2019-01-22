package evergrande.lightapp.jianq.com.module_center.ui;

import android.annotation.SuppressLint;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.template.liuyong.common_base.bean.CrashBean;
import com.template.liuyong.common_base.ui.BaseActivity;
import com.template.liuyong.common_base.util.ARouterConfiger;

import java.text.SimpleDateFormat;

import butterknife.BindView;
import evergrande.lightapp.jianq.com.module_center.R;

import static com.template.liuyong.common_base.util.ConstantUtil.CRASH_BEAN;

/**
 * @author 创建人 liuyong
 * @project 项目名称 TemplateProject
 * @package 包名 com.template.liuyong.common_base.ui
 * @describe 类描述
 * @time 创建时间 2019/1/22 16:11
 * @change 修改内容
 * @changetime 修改时间
 * @changeauthor 修改人
 */
@Route(path = ARouterConfiger.ACTIVITY_CRASH)
public class CrashActivity extends BaseActivity {

    private CrashBean model;
    @BindView(R.id.tv_packageName)
    TextView tv_packageName;
    @BindView(R.id.textMessage)
    TextView textMessage;
    @BindView(R.id.tv_className)
    TextView tv_className;
    @BindView(R.id.tv_methodName)
    TextView tv_methodName;
    @BindView(R.id.tv_lineNumber)
    TextView tv_lineNumber;
    @BindView(R.id.tv_exceptionType)
    TextView tv_exceptionType;
    @BindView(R.id.tv_fullException)
    TextView tv_fullException;
    @BindView(R.id.tv_time)
    TextView tv_time;
    @BindView(R.id.tv_model)
    TextView tv_model;
    @BindView(R.id.tv_brand)
    TextView tv_brand;
    @BindView(R.id.tv_version)
    TextView tv_version;

    @SuppressLint("SimpleDateFormat")
    private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");


    @Override
    public int getView() {
        return R.layout.activity_crash;
    }


    @Override
    public void initView() {
        model = (CrashBean) getIntent().getCharSequenceExtra(CRASH_BEAN);
        tv_packageName= findViewById(R.id.tv_packageName);
        tv_packageName.setText(model.getClassName());
        textMessage.setText(model.getExceptionMsg());
        tv_className.setText(model.getFileName());
        tv_methodName.setText(model.getMethodName());
        tv_lineNumber.setText(String.valueOf(model.getLineNumber()));
        tv_exceptionType.setText(model.getExceptionType());
        tv_fullException.setText(model.getFullException());
        tv_time.setText(df.format(model.getTime()));

        tv_model.setText(model.getDevice().getModel());
        tv_brand.setText(model.getDevice().getBrand());
        tv_version.setText(model.getDevice().getVersion());
    }
}
