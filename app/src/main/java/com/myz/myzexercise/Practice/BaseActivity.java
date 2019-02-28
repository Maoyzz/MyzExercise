package com.myz.myzexercise.Practice;

import android.app.ActionBar;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.launcher.ARouter;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {

    protected abstract int getContentLayout();
    protected abstract void initView();
    protected abstract void initData();
    protected abstract void initEvent();
    public static final String TAG = "mao";
    public Typeface iconfont;
    protected Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iconfont = Typeface.createFromAsset(getAssets(), "iconfont.ttf");
        //ali router
        ARouter.getInstance().inject(this);
        if(getContentLayout() != 0){
            setContentView(getContentLayout());
            unbinder = ButterKnife.bind(this);
        }
        initView();
        initData();
        initEvent();
        getSupportActionBar().setTitle(this.getClass().getSimpleName());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(unbinder != null){
            unbinder.unbind();
        }
    }
}
