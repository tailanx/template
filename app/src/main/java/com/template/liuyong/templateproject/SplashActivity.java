package com.template.liuyong.templateproject;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.support.annotation.NonNull;

import com.orhanobut.logger.Logger;
import com.template.liuyong.common_base.ui.BaseActivity;
import com.template.liuyong.common_base.util.ARouterConfiger;
import com.template.liuyong.common_base.util.ARouterUtil;
import com.template.liuyong.common_base.util.ToastUtil;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

import static com.template.liuyong.common_base.util.ConstantUtil.DEALAYTIME;
import static com.template.liuyong.common_base.util.ConstantUtil.PERMISSION_REQUEST;

/**
 * @author 创建人 liuyong
 * @project 项目名称 TemplateProject
 * @package 包名 com.template.liuyong.templateproject
 * @describe 类描述
 * @time 创建时间 2019/1/15 11:59
 * @change 修改内容
 * @changetime 修改时间
 * @changeauthor 修改人
 */
public class SplashActivity extends BaseActivity implements EasyPermissions.PermissionCallbacks {

    /**
     * 需要申请的权限
     */
    private String permissions[] = {Manifest.permission.READ_PHONE_STATE,Manifest.permission.READ_EXTERNAL_STORAGE};


    @Override
    public int getView() {
        return R.layout.activity_splash;
    }

    @Override
    public void initView() {
        setPermissions();

    }
    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * 设置权限
     */
    private void setPermissions(){
        if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.M) {
            if (EasyPermissions.hasPermissions(this, permissions)) {
                setjumpToMain();
            } else {
                EasyPermissions.requestPermissions(this, getResources().getString(R.string.grant_permission), PERMISSION_REQUEST, permissions);
            }
        }else{
            setjumpToMain();
        }
    }

    /**
     * 设置跳转到首页
     */
    private void setjumpToMain(){
        Observable.timer(DEALAYTIME, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).
                compose(this.<Long>bindToLifecycle()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(aLong -> getToMain());
    }
    /**
     * 跳转
     */
    private void getToMain(){
        ARouterUtil.getActivity(ARouterConfiger.MAINACTIITY);
        this.finish();
    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {
        if(permissions.length> perms.size()){
            ToastUtil.showToast(this,"请同意所有的权限");
            this.finish();
        }else{
            setjumpToMain();
        }
    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        Logger.e("<<--->"+perms.size());
        if(EasyPermissions.somePermissionPermanentlyDenied(this,perms)){
            new AppSettingsDialog.Builder(this).setTitle(getResources().getString(R.string.denited_permission)).setRationale(getResources().getString(R.string.denited_content))
                    .setRequestCode(PERMISSION_REQUEST).build().show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode,permissions,grantResults,this);
    }

}
