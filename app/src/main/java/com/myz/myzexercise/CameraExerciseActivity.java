package com.myz.myzexercise;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class CameraExerciseActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        initView();
    }

    private void initView() {
        findViewById(R.id.btn_camera_1).setOnClickListener(this);
        findViewById(R.id.btn_camera_2).setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_camera_1:
                startActivity(new Intent(CameraExerciseActivity.this,CameraExercise1Activity.class));
                break;
            case R.id.btn_camera_2:
                startActivity(new Intent(CameraExerciseActivity.this,CameraExercise2Activity.class));
                break;
            default:
        }
    }
}
