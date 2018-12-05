package com.myz.myzexercise.Practice;

import android.app.Application;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.myz.myzexercise.R;

public class BaseLoaderActivity extends AppCompatActivity{
    ProgressBar pb;
    RelativeLayout mLayoutBase;
    View mLayout;
    View targetView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    private void init(){
        pb = findViewById(R.id.pb);
        mLayoutBase = findViewById(R.id.layout_base);
    }

    protected void startLoading(View view,ProgressBar pb){
        pb.setVisibility(View.VISIBLE);
        view.setVisibility(View.GONE);
    }

    protected void stopLoading(){
        pb.setVisibility(View.GONE);
        mLayout.setVisibility(View.VISIBLE);
    }

    protected void error(){

    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(R.layout.activity_base_loader);
        init();
        mLayout = LayoutInflater.from(this).inflate(layoutResID,null);
        //mLayout.findViewById();
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        if(mLayout != null && mLayoutBase != null){
            mLayoutBase.addView(mLayout,lp);
            startLoading(mLayout,pb);
        }
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(R.layout.activity_base_loader);
    }

    public void setContentView(int layoutResID, int targetID) {
        mLayout = LayoutInflater.from(this).inflate(layoutResID,null);
        View targetView = mLayout.findViewById(targetID);
        setContentView(mLayout);
    }
}
