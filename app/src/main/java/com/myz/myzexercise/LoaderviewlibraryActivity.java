package com.myz.myzexercise;

import android.app.ProgressDialog;
import android.os.CountDownTimer;

import com.elyeproj.loaderviewlibrary.LoaderImageView;
import com.elyeproj.loaderviewlibrary.LoaderTextView;

import butterknife.BindView;


public class LoaderviewlibraryActivity extends BaseActivity {

    CountDownTimer timer;
    @BindView(R.id.img)
    LoaderImageView imageView;
    @BindView(R.id.text1)
    LoaderTextView textView1;
    @BindView(R.id.text2)
    LoaderTextView textView2;
    ProgressDialog mpd;
    @Override
    protected int getContentLayout() {
        return R.layout.activity_loaderviewlibrary;
    }

    @Override
    protected void initView() {
        mpd = new ProgressDialog(this);
        mpd.setMessage("loading...");
    }

    @Override
    protected void initData() {
        mpd.show();
        timer = new CountDownTimer(1000,2000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                mpd.dismiss();
                textView1.setText("textView1");
                textView2.setText("textView2");
                imageView.setImageResource(R.mipmap.ic_launcher);

            }
        }.start();
    }

    @Override
    protected void initEvent() {

    }
}
