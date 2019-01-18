package evergrande.lightapp.jianq.com.module_center.ui;

import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.template.liuyong.common_base.ui.BaseActivity;
import com.template.liuyong.common_base.ui.BaseFragment;
import com.template.liuyong.common_base.util.ARouterConfiger;
import com.template.liuyong.common_base.util.ARouterUtil;
import com.template.liuyong.common_base.view.CustomerRecyclerView;

import butterknife.BindView;
import butterknife.OnClick;
import evergrande.lightapp.jianq.com.module_center.R;
import evergrande.lightapp.jianq.com.module_center.adapter.StudyAdapter;
import evergrande.lightapp.jianq.com.module_center.bean.StudyBean;
import evergrande.lightapp.jianq.com.module_center.callback.RecyclerCallBack;
import evergrande.lightapp.jianq.com.module_center.util.DataManager;

/**
 * @author 创建人 liuyong
 * @project 项目名称 TemplateProject
 * @package 包名 evergrande.lightapp.jianq.com.module_center
 * @describe 看的见的 都不是命运，说的出的 都不是爱情，忘的了的 都不是遗憾，听的到的 都不是伤心，躲得掉的 都不是缘分，猜的透的 都不是人生。
 * @time 创建时间 2019/1/10 09:54
 * @change 修改内容
 * @changetime 修改时间
 * @changeauthor 修改人
 */
@Route(path = ARouterConfiger.CENTERMENU)
public class CenterFragment extends BaseFragment implements View.OnClickListener,RecyclerCallBack {
    @BindView(R.id.crc_view)
    public CustomerRecyclerView customerRecyclerView;
    private int column = 1;
    private GridLayoutManager gridLayoutManager;

    private StudyAdapter studyAdapter;

    @Override
    public int resview() {
        return R.layout.fragment_center;
    }

    @Override
    public void initView() {
        studyAdapter = new StudyAdapter(activity, DataManager.getStudyBean());
        setLayoutManager();
        customerRecyclerView.setHasFixedSize(true);
        customerRecyclerView.setAdapter(studyAdapter);
        studyAdapter.setCallBack(this);
        ((BaseActivity)activity).getIvView().setVisibility(View.GONE);
        ((BaseActivity)activity).getTvChange().setOnClickListener(this);
        ((BaseActivity)activity).setRightTextVis(true);
    }

//    @OnClick({R.id.title_right_tv})
//    @Override
//    public void onClick(View v) {
//
//    }

    /**
     * 设置布局
     */
    private void setLayoutManager() {
        if (null == gridLayoutManager) {
            gridLayoutManager = new GridLayoutManager(activity, column);
        } else {
            gridLayoutManager.setSpanCount(column);
        }
        customerRecyclerView.setLayoutManager(gridLayoutManager);
    }

    @Override
    public void callBack(Object o) {
        if(null != o){
            StudyBean studyBean = (StudyBean) o;
            switch (studyBean.getType()){
                case 1:
                    ARouterUtil.getActivity(ARouterConfiger.PATTERN_ACTIVITY);
                    break;
                  default:
                      break;
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.title_right_tv:
                column = column == 1 ? 2 : 1;
                setLayoutManager();
                break;
            default:
                break;
        }
    }
}
