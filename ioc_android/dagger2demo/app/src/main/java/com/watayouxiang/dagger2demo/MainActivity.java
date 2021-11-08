package com.watayouxiang.dagger2demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.watayouxiang.dagger2demo.component.DaggerMainComponent;
import com.watayouxiang.dagger2demo.module.HttpModule;
import com.watayouxiang.dagger2demo.module.ImModule;
import com.watayouxiang.dagger2demo.object.HttpClient;
import com.watayouxiang.dagger2demo.object.ImClient;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    HttpClient httpClient;

    @Inject
    ImClient imClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 语法1
        DaggerMainComponent.create().injectMainActivity(this);

        // 语法2
//        DaggerMainComponent.builder()
//                .httpModule(new HttpModule())
//                .imModule(new ImModule())
//                .build()
//                .injectMainActivity(this);
    }
}