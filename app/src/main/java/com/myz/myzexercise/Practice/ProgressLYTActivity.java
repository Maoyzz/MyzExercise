package com.myz.myzexercise.Practice;

import android.os.Bundle;
import android.view.View;

import com.myz.myzexercise.R;

public class ProgressLYTActivity extends BaseLYTActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentViewBase(R.layout.activity_progress_lyt,0,0);

        findViewById(R.id.btn_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startProgress();
            }
        });

        findViewById(R.id.btn_stop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopProgress();
            }
        });
    }
}
