package com.myz.myzexercise.Practice;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;

import com.myz.myzexercise.R;

public class LoaderTestActivity extends BaseLoaderActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loader_test);
        CountDownTimer timer = new CountDownTimer(1000,2000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                LoaderTestActivity.super.stopLoading();
            }
        };
        timer.start();
    }


}
