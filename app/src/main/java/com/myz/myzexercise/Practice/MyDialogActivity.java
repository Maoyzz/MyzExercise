package com.myz.myzexercise.Practice;

import android.util.Log;
import android.widget.Toast;

import com.myz.myzexercise.R;

import butterknife.OnClick;
import weight.MyDialog;

public class MyDialogActivity extends BaseActivity {

    private MyDialog dialogDouble;
    private MyDialog dialogSingle;

    @Override
    protected int getContentLayout() {
        return R.layout.activity_mydialog;
    }

    @Override
    protected void initView() {
        Log.e("mao", "initView: "+ getIntent().getStringExtra("text"));
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvent() {

    }

    @OnClick(R.id.btn_dialog_double)
    void showDouble(){
        if(dialogDouble == null){
            dialogDouble = new MyDialog.Builder(this)
                    .title("this is double dialog")
                    .positiveText("confirm")
                    .negativeText("cancel")
                    .create();
        }
        dialogDouble.setDoubleButtonClickListenr(new MyDialog.doubleButtonClickListener() {
            @Override
            public void positiveClick() {
                Toast.makeText(MyDialogActivity.this,"confirm!!",Toast.LENGTH_SHORT).show();
                dialogDouble.dismiss();
            }

            @Override
            public void negativeClick() {
                Toast.makeText(MyDialogActivity.this,"cancel!!",Toast.LENGTH_SHORT).show();
                dialogDouble.dismiss();
            }
        }).show();
    }

    @OnClick(R.id.btn_dialog_single)
    void showSingle(){
        if(dialogSingle == null){
            dialogSingle = new MyDialog.Builder(this)
                    .isSingle(true)
                    .title("this is single dialog")
                    .singleButtonText("confirm")
                    .singleButtonTextColor(R.color.color_black)
                    .create();
        }
        dialogSingle.setSingleButtonClickListener(new MyDialog.singleButtonClickListener() {
            @Override
            public void click() {
                Toast.makeText(MyDialogActivity.this,"confirm!!",Toast.LENGTH_SHORT).show();
                dialogSingle.dismiss();
            }
        }).show();
    }
}
