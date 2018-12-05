package com.myz.myzexercise;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.myz.myzexercise.Practice.BaseActivity;
import com.myz.myzexercise.Practice.MainActivity;
import com.myz.myzexercise.Study.StudyMainActivity;

import butterknife.OnClick;

public class HomePagerActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getContentLayout() {
        return R.layout.layout_home_page;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvent() {

    }

    @OnClick({R.id.tv_study, R.id.tv_practice})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_study:
//                Intent intent = new Intent(this,HomePagerActivity.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
//                startActivity(intent);
                startActivity(new Intent(this, StudyMainActivity.class));
                break;
            case R.id.tv_practice:
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart: " );
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart: " );
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: " );
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.e(TAG, "onNewIntent: ");
    }
}
