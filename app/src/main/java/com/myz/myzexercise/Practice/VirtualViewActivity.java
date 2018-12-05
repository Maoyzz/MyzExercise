package com.myz.myzexercise.Practice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.myz.myzexercise.R;
import com.tmall.wireless.tangram.TangramBuilder;
import com.tmall.wireless.tangram.TangramEngine;

public class VirtualViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_virtual_view);
        initView();
    }

    private void initView(){
        TangramBuilder.InnerBuilder builder = TangramBuilder.newInnerBuilder(VirtualViewActivity.this);
        builder.registerCell("text1", TextView.class);
        builder.registerCell("text2", TextView.class);
        TangramEngine engine = builder.build();
//        engine.setData();
    }

//    public static class Model{
//        public String
//    }


}
