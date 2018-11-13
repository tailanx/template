package com.template.liuyong.templateproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.template.liuyong.templateproject.datanullfragment.AvoidOnResult;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tv_startActivityforResult).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AvoidOnResult(MainActivity.this).startForResult(SecondActivity.class, new AvoidOnResult.Callback() {
                    @Override
                    public void onActivityResult(int requestCode, int resultCode, Intent data) {
                        Toast.makeText(MainActivity.this,String.valueOf(resultCode),1).show();

                    }
                });
            }
        });
    }
}
