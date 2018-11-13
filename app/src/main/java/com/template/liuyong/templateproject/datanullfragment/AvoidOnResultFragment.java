package com.template.liuyong.templateproject.datanullfragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;

/**
 * @author 创建人 liuyong
 * @project 项目名称 TemplateProject
 * @package 包名 com.template.liuyong.templateproject.datanullfragment
 * @describe 类描述
 * @time 创建时间 2018/11/13 16:47
 * @change 修改内容
 * @changetime 修改时间
 * @changeauthor 修改人
 */
public class AvoidOnResultFragment extends Fragment {
    private Map<Integer, PublishSubject<ActivityResultInfo>> mSubjects = new HashMap<>();
    private Map<Integer, AvoidOnResult.Callback> mCallbacks = new HashMap<>();

    public AvoidOnResultFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public Observable<ActivityResultInfo> startForResult(final Intent intent) {
        final PublishSubject<ActivityResultInfo> subject = PublishSubject.create();
        mSubjects.put(subject.hashCode(), subject);
        return subject.doOnSubscribe(new Consumer<Disposable>() {
            @Override
            public void accept(Disposable disposable) throws Exception {
                startActivityForResult(intent, subject.hashCode());
            }
        });
    }

    public void startForResult(Intent intent, AvoidOnResult.Callback callback) {
        mCallbacks.put(callback.hashCode(), callback);
        startActivityForResult(intent, callback.hashCode());
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //rxjava方式的处理
        PublishSubject<ActivityResultInfo> subject = mSubjects.remove(requestCode);
        if (subject != null) {
            subject.onNext(new ActivityResultInfo(requestCode, resultCode, data));
            subject.onComplete();
        }

        //callback方式的处理
        AvoidOnResult.Callback callback = mCallbacks.remove(requestCode);
        if (callback != null) {
            callback.onActivityResult(requestCode, resultCode, data);
        }
    }
}
