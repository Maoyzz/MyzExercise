package com.myz.myzexercise;

import android.util.Log;
import android.widget.Button;


import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.OnClick;

@Route(path = "/com/ARouterActivity")
public class ARouterActivity extends BaseActivity {

    @Autowired()
    Serializable list;
    private List<TestModel1> list1;

    @Override
    protected int getContentLayout() {
        return R.layout.activity_async;
    }

    @Override
    protected void initView() {
        list1 = (List<TestModel1>)list;
        Log.e(TAG, "initView: "+list1.size() );
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvent() {

    }

    @OnClick({R.id.btn_asyncTask,R.id.btn_handle})
    void click(Button btn){
        switch (btn.getId()){
            case R.id.btn_asyncTask:
                break;
            case R.id.btn_handle:
                break;
        }
    }
}
