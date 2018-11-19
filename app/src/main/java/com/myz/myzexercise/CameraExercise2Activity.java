package com.myz.myzexercise;

import android.widget.Button;

import butterknife.BindView;

public class CameraExercise2Activity extends BaseActivity {

    @BindView(R.id.btn_take_photo)
    Button mBtnPhoto;

    @Override
    protected int getContentLayout() {
        return R.layout.activity_camera_2;
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
}
