package com.myz.myzexercise.Study;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.util.Log;

import com.myz.myzexercise.Practice.BaseActivity;
import com.myz.myzexercise.R;

import butterknife.OnClick;

/**
 * Created by myz on 2018/12/6
 **/
public class ActivityTest extends BaseActivity {
    //1.dialog
    private AlertDialog alertDialog;
    //2.dialogText
    private String mDialogText;

    @Override
    protected int getContentLayout() {
        return R.layout.activity_activity_test;
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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Activity的练习");
        Log.e(TAG, "onCreate: ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: ");
    }


    @OnClick(R.id.btn_1)
    public void onViewClicked() {
        mDialogText = "正常Activity的生命周期：1.onCreate2.onStart3.onResume";
        mDialogText += "点击home键的时候：1.onPause2.onStop";
        mDialogText += "返回的时候调用的顺序为：1.onRestart2.onStart3.onResume";
        mDialogText += "关掉的时候调用的顺序为：1.onPause2.onStop3.onDestroy\n";
        mDialogText += "**记住当跳转的界面为透明的Activity，或者dialogActivity时，" +
                "原界面并不会调用onStop和onRestart,onStart";
        createDialog(mDialogText);
    }

    @OnClick(R.id.btn_2)
    public void onViewClicked1() {
        mDialogText = "Android Activity 启动模式主要分为4种：" +
                "普通：新建一个实例：                                         intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);  // 该Flag相当于Activity启动模式中的standard" +
                "栈内复用：如果目标Activity在栈内，复用不新建，但会调用onNewIntent intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // 该Flag相当于Activity启动模式中的singleTask" +
                "栈顶复用：如果目标Activity在栈顶，复用不新建，但会调用onNewIntent intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP); // Flag相当于Activity加载模式中的singleTop模式" +
                "单例：";
        createDialog(mDialogText);
    }

    private void createDialog(String mDialogText){
        if(alertDialog == null){
            alertDialog = new AlertDialog.Builder(this).setMessage(mDialogText).setPositiveButton("confirm", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    alertDialog.dismiss();
                }
            }).create();
            alertDialog.setCancelable(false);
        }
        if(alertDialog.isShowing()){
            return;
        }
        alertDialog.show();
    }
}
