package evergrande.lightapp.jianq.com.module_center.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import evergrande.lightapp.jianq.com.module_center.R;
import evergrande.lightapp.jianq.com.module_center.bean.BaseBean;
import evergrande.lightapp.jianq.com.module_center.bean.StudyBean;
import evergrande.lightapp.jianq.com.module_center.callback.RecyclerCallBack;

/**
 * @author 创建人 liuyong
 * @project 项目名称 TemplateProject
 * @package 包名 evergrande.lightapp.jianq.com.module_center.adapter
 * @describe 类描述
 * @time 创建时间 2019/1/17 11:20
 * @change 修改内容
 * @changetime 修改时间
 * @changeauthor 修改人
 */
public class StudyAdapter extends RecyclerView.Adapter<StudyAdapter.ViewHolder> {
    private Activity activity;
    private ArrayList<BaseBean> list;
    private RecyclerCallBack callBack;

    public void setCallBack(RecyclerCallBack callBack) {
        this.callBack = callBack;
    }

    public StudyAdapter(Activity activity, ArrayList<BaseBean> list) {
        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(activity).inflate(R.layout.adapter_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        BaseBean s = list.get(i);
        if (null != s) {
            viewHolder.tvTitle.setText(s.getName());
        }

        /**
         * 点击事件
         */
        viewHolder.itemView.setOnClickListener(v ->{
            if(null != callBack){
                callBack.callBack(s);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_title)
        TextView tvTitle;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
