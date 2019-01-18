package com.template.liuyong.common_base.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author 创建人 liuyong
 * @project 项目名称 TemplateProject
 * @package 包名 com.template.liuyong.common_base.view
 * @describe 设置空白的Customer
 * @time 创建时间 2019/1/16 14:25
 * @change 修改内容
 * @changetime 修改时间
 * @changeauthor 修改人
 */
public class CustomerRecyclerView extends RecyclerView {
    private View emptyView;

    public CustomerRecyclerView(@NonNull Context context) {
        super(context);
    }

    public CustomerRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomerRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    AdapterDataObserver adapterDataObserver = new AdapterDataObserver() {
        @Override
        public void onChanged() {
            super.onChanged();
            Adapter adapter = getAdapter();
            if (null != adapter && null != emptyView) {
                if (0 == adapter.getItemCount()) {
                    emptyView.setVisibility(View.VISIBLE);
                    CustomerRecyclerView.this.setVisibility(View.GONE);
                } else {
                    emptyView.setVisibility(View.GONE);
                    CustomerRecyclerView.this.setVisibility(View.VISIBLE);
                }
            }
        }
    };

    public void setEmptyView(View view) {
        this.emptyView = view;
    }

    @Override
    public void setAdapter(Adapter adapter) {
        super.setAdapter(adapter);
        if (null != adapter) {
            adapter.registerAdapterDataObserver(adapterDataObserver);
        }
        adapterDataObserver.onChanged();
    }


}
