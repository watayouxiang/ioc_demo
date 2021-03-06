package com.watayouxiang.dagger2demo.dependencies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.watayouxiang.dagger2demo.R;

import javax.inject.Inject;

/**
 * 多个 Component 组合依赖（@Component - dependencies）
 */
public class MoreComponentActivity extends AppCompatActivity {

    @Inject
    ImClient imClient;

    @Inject
    HttpClient httpClient;

    @Inject
    DbClient dbClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_component);

        DaggerMainComponent.builder()
                .imModule(new ImModule())
                .httpModule(new HttpModule())
                .dbComponent(DaggerDbComponent.create())
                .build()
                .injectMoreComponentActivity(this);

        TextView viewById = findViewById(R.id.tv_text);
        viewById.append("多个 Component 组合依赖（@Component - dependencies）");
        viewById.append("\n\n");
        viewById.append(imClient.toString());
        viewById.append("\n\n");
        viewById.append(httpClient.toString());
        viewById.append("\n\n");
        viewById.append(dbClient.toString());

    }
}