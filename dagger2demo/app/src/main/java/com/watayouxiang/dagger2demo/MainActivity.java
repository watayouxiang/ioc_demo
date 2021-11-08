package com.watayouxiang.dagger2demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.watayouxiang.dagger2demo.component.DaggerMainComponent;
import com.watayouxiang.dagger2demo.module.HttpModule;
import com.watayouxiang.dagger2demo.module.ImModule;
import com.watayouxiang.dagger2demo.object.HttpClient;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    HttpClient httpClient;

    @Inject
    HttpClient httpClient2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tv_text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MainActivity2.class));
            }
        });

        // 注解第一种方式
        DaggerMainComponent.create().injectMainActivity(this);

        // 注解第二种方式
        if (false) {
            DaggerMainComponent.builder()
                    .httpModule(new HttpModule())
                    .imModule(new ImModule())
                    .build()
                    .injectMainActivity(this);
        }

        TextView tv_text = findViewById(R.id.tv_text);
        tv_text.setText(httpClient.toString());
        tv_text.append("\n\n");
        tv_text.append(httpClient2.toString());
    }
}