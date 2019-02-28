package com.myz.myzexercise.Study;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.myz.myzexercise.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StudyMainActivity extends AppCompatActivity {
    @BindView(R.id.tv_java_tip)
    TextView mTvJavaTip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_mian);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        final String JavaTip1 = "JAVA类的步骤为先连接阶段，所有变量赋默认值，再就是构造方法阶段，最后初始化赋值" +
                "简书地址：https://www.jianshu.com/p/853701433b3a";
        mTvJavaTip.setText(JavaTip1);
    }

    @OnClick({R.id.layout_activity, R.id.layout_service, R.id.layout_contentProvider, R.id.layout_broadcast})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.layout_activity:
                startActivity(new Intent(this,ActivityTest.class));
                break;
            case R.id.layout_service:
                startActivity(new Intent(this,TestServiceActivity.class));
                break;
            case R.id.layout_contentProvider:
                break;
            case R.id.layout_broadcast:
                Intent intent = new Intent("receiverTest");
                this.sendBroadcast(intent);
                break;
        }
    }
}
