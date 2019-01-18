package com.template.liuyong.templateproject;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.orhanobut.logger.Logger;
import com.template.liuyong.common_base.ui.BaseActivity;
import com.template.liuyong.common_base.ui.BaseFragment;
import com.template.liuyong.common_base.util.ARouterConfiger;
import com.template.liuyong.common_base.util.ARouterUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author 创建人 liuyong
 * @project 项目名称 TemplateProject
 * @package 包名 com.template.liuyong.templateproject
 * @describe 类描述
 * @time 创建时间 2018/12/24 14:33
 * @change 修改内容
 * @changetime 修改时间
 * @changeauthor 修改人
 */
@Route(path = ARouterConfiger.MAINACTIITY)
public class MainActivity extends BaseActivity {

    @BindView(R.id.rg_group)
    public RadioGroup radioGroup;
    @BindView(R.id.rb_main)
    public RadioButton rdMain;
    private FragmentManager fragmentManager;
    /**foodFragment*/
    private BaseFragment foodFragment = ARouterUtil.getFragment(ARouterConfiger.FOODMENU);
    /**centerFragment*/
    private BaseFragment centerFragment = ARouterUtil.getFragment(ARouterConfiger.CENTERMENU);
    /**mefragment*/
    private BaseFragment meFragment = ARouterUtil.getFragment(ARouterConfiger.MEMENU);
    @Override
    public int getView() {
        return R.layout.activity_main;
    }


    @Override
    public void initView() {
        fragmentManager = getFragmentManager();
        onRadioButtonClicked(rdMain);

    }

    @OnClick({R.id.rb_main, R.id.rb_friend, R.id.rb_me})
    public void onRadioButtonClicked(RadioButton radioButton) {
        if (null != radioGroup) {
            for (int i = 0; i < radioGroup.getChildCount(); i++) {
                radioGroup.getChildAt(i).setSelected(false);
            }
        }
        radioButton.setSelected(true);
        switch (radioButton.getId()) {
            case R.id.rb_main:
                if(null == foodFragment){
                    foodFragment = ARouterUtil.getFragment(ARouterConfiger.FOODMENU);
                }
                showFragment(foodFragment);
                break;
            case R.id.rb_friend:
                showFragment(centerFragment);
                break;
            case R.id.rb_me:
                showFragment(meFragment);
                break;
            default:
                break;
        }
    }

    private void showFragment(BaseFragment fragment){
        FragmentTransaction ft  =fragmentManager.beginTransaction();
        if(null != fragment){
            ft.replace(R.id.fl_main_content,fragment);
        }
        ft.commit();

    }

    public void onChecked(RadioGroup group, int checkedId) {
        int size = group.getChildCount();
        for (int i = 0; i < size; i++) {
            group.getChildAt(i).setSelected(false);
        }
        findViewById(checkedId).setSelected(true);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideView(transaction);
        switch (checkedId) {
            case R.id.rb_main:
                Toast.makeText(this, "haah", Toast.LENGTH_SHORT).show();
//                if (null != cookBookFragment) {
//                    transaction.show(cookBookFragment);
//                } else {
//                    cookBookFragment = CookBookFragment.getInstance();
//                    transaction.add(R.id.fl_main_content, cookBookFragment);
//                }
//                break;
//            case R.id.rb_friend:
//                if (null != friendFragment) {
//                    transaction.show(friendFragment);
//                } else {
//                    friendFragment = FriendFragment.getInstance();
//                    transaction.add(R.id.fl_main_content, friendFragment);
//                }
//                break;
//            case R.id.rb_me:
//                if (null != myPannelFragment) {
//                    transaction.show(myPannelFragment);
//                } else {
//                    myPannelFragment = MyPannelFragment.getInstance();
//                    transaction.add(R.id.fl_main_content, myPannelFragment);
//                }
//                break;
            default:
                break;

        }
    }

    private void hideView(FragmentTransaction transaction) {
//        if (null != cookBookFragment) {
//            transaction.hide(cookBookFragment);
//        }
//        if (null != friendFragment) {
//            transaction.hide(friendFragment);
//        }
//        if (null != myPannelFragment) {
//            transaction.hide(myPannelFragment);
//        }
    }
}
