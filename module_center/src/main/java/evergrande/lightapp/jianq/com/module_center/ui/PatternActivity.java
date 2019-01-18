package evergrande.lightapp.jianq.com.module_center.ui;

import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.template.liuyong.common_base.ui.BaseActivity;
import com.template.liuyong.common_base.util.ARouterConfiger;
import com.template.liuyong.common_base.util.ARouterUtil;
import com.template.liuyong.common_base.view.CustomerRecyclerView;

import butterknife.BindView;
import evergrande.lightapp.jianq.com.module_center.R;
import evergrande.lightapp.jianq.com.module_center.adapter.StudyAdapter;
import evergrande.lightapp.jianq.com.module_center.bean.BaseBean;
import evergrande.lightapp.jianq.com.module_center.callback.RecyclerCallBack;
import evergrande.lightapp.jianq.com.module_center.util.DataManager;

/**
 * @author 创建人 liuyong
 * @project 项目名称 TemplateProject
 * @package 包名 evergrande.lightapp.jianq.com.module_center.ui
 * @describe 类描述
 * @time 创建时间 2019/1/17 15:58
 * @change 修改内容
 * @changetime 修改时间
 * @changeauthor 修改人
 */
@Route(path = ARouterConfiger.PATTERN_ACTIVITY)
public class PatternActivity extends BaseActivity implements RecyclerCallBack {
    @BindView(R.id.title_right_tv)
    TextView tvRight;
    @BindView(R.id.crc_view)
    CustomerRecyclerView customerRecyclerView;

    @Override
    public int getView() {
        return R.layout.activity_pattern;
    }

    @Override
    public void initView() {
        getTvTitle().setText(getResources().getString(R.string.design_pattern));
        tvRight.setVisibility(View.GONE);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        StudyAdapter studyAdapter = new StudyAdapter(this, DataManager.getPatternData());
        customerRecyclerView.setAdapter(studyAdapter);
        customerRecyclerView.setLayoutManager(gridLayoutManager);
        studyAdapter.setCallBack(this);
    }

    @Override
    public void callBack(Object object) {
        if (null == object) {
            return;
        }
        BaseBean baseBea = (BaseBean) object;
        switch (baseBea.getType()){
            case 1:
                ARouterUtil.getActivity(ARouterConfiger.STRAREGY_PATTERN);
                break;

            default:
                break;
        }

    }
}
