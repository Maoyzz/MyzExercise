package com.myz.myzexercise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import java.util.zip.Inflater;

public class BaseLYTActivity extends AppCompatActivity {

    public RelativeLayout mLayoutOutView;
    public View mContentView;

    View pb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_base_lyt);
    }



    public void setContentViewBase(int layoutRes, int errorRes, int progressRes){
        LayoutInflater inflater = LayoutInflater.from(this);
        View layout = inflater.inflate(layoutRes, null);
        super.setContentView(layout);
        mLayoutOutView = layout.findViewById(R.id.layout_out_view);
        mContentView = layout.findViewById(R.id.layout_content);
        if (progressRes == 0){
            pb = new ProgressBar(this);
        }else{
            pb = inflater.inflate(progressRes, null);
        }
        mLayoutOutView.addView(pb);
    }

    public void startProgress(){
        pb.setVisibility(View.VISIBLE);
        mContentView.setVisibility(View.GONE);
    }

    public void stopProgress(){
        pb.setVisibility(View.GONE);
        mContentView.setVisibility(View.VISIBLE);
    }


}
