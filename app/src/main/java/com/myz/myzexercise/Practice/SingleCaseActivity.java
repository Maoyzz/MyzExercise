package com.myz.myzexercise.Practice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.myz.myzexercise.R;

public class SingleCaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_case);
    }



    //饿汉式
//    private static final SingleCaseActivity instance = new SingleCaseActivity();
//
//    private SingleCaseActivity(){
//
//    }
//    //这里提供了一个供外部访问本class的静态方法，可以直接访问
//    public static SingleCaseActivity getInstance(){
//        return instance;
//    }

    //懒汉式
//    private static SingleCaseActivity instance = null;

//    public static synchronized SingleCaseActivity getInstance() {
//        // 这个方法比上面有所改进，不用每次都进行生成对象，只是第一次
//        // 使用时生成实例，提高了效率！
//        if (instance == null)
//            instance = new SingleCaseActivity();
//        return instance;
//    }

    //双重锁式
    private static volatile SingleCaseActivity instance = null;

    private SingleCaseActivity (){

    }
    public static  SingleCaseActivity getInstance(){
        if(instance == null){
            synchronized(SingleCaseActivity.class){
                if(instance == null){
                    instance = new SingleCaseActivity ();
                }
            }
        }
        return instance;
    }
}
