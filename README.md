1.添加无界面Fragment绑定数据
---------------------------
正常来说调用startActivityForResult(),会回调onActivityResult(),执行返回结果.这样业务逻辑会分开来.创建一个空的AvoidOnResultFragment，执行时通过AvoidOnResultFragment来接收onActivityResult(int requestCode, int resultCode, Intent data)，这样将逻辑链式执行。
Exapmle：
```
findViewById(R.id.tv_startActivityforResult).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AvoidOnResult(MainActivity.this).startForResult(SecondActivity.class, new AvoidOnResult.Callback() {
                    @Override
                    public void onActivityResult(int requestCode, int resultCode, Intent data) {
                        Log.e("info","------"+resultCode);
                    }
                });
            }
        });
```
2.使用EasyPermission来申请6.0(SDK>=23)的权限问题.
3.使用rxlifecycle来防止使用rxjava导致的内存泄露问题.
```
Observable.timer(DEALAYTIME, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).
                compose(this.<Long>bindToLifecycle()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(aLong -> getToMain());
```

