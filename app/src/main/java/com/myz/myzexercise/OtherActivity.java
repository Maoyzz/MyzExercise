package com.myz.myzexercise;

import android.content.Context;
import android.os.CountDownTimer;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;

public class OtherActivity extends BaseActivity {

    @BindView(R.id.tv_display)
    TextView mTvDisplay;
    @BindView(R.id.rv_bottom)
    RelativeLayout mViewBottom;
    @BindView(R.id.btn_bottom)
    Button mBtnBottom;
    boolean isMax = true;

    private CountDownTimer timer;

    @Override
    protected int getContentLayout() {
        return R.layout.activity_other;

    }

    @Override
    protected void initView() {
        setAnimation();
    }

    @Override
    protected void initData() {
        timer = new CountDownTimer(600000,1000) {
            @Override
            public void onTick(long l) {
//                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
//                Date date = new Date();
//                mTvDisplay.setText(simpleDateFormat.format(date));
                mTvDisplay.setText(getTime());
                mTvDisplay.setTypeface(iconfont);
            }

            @Override
            public void onFinish() {

            }
        }.start();
    }

    @Override
    protected void initEvent() {
        getNowDate();
    }

    private String getTime(){
        String time = "";
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.get(Calendar.HOUR_OF_DAY);
        return time;
    }


    private void getNowDate(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date date = new Date();
        mTvDisplay.setText(simpleDateFormat.format(date));
        Calendar calendar = Calendar.getInstance();
        Date date1 = new Date();
        calendar.setTime(date1);
        //获取屏幕宽高
        Log.e(TAG, "width: "+getWindowManager().getDefaultDisplay().getWidth()+"height"+getWindowManager().getDefaultDisplay().getHeight() );
        Log.e(TAG, "width: "+getResources().getDisplayMetrics().widthPixels+"height"+getResources().getDisplayMetrics().heightPixels );
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        Log.e(TAG, "getNowDate: "+width+height );
    }
    /*****************/
    Animation expandAnimation = null;
    Animation lessenAnimation = null;
    AnimationSet animationSet = null;
    private void setAnimation(){
        int mScreenWidth = getWindowManager().getDefaultDisplay().getWidth();
        float toX = dp2px(this,100)/mScreenWidth;
        float toY = 0.25f;
        expandAnimation = new ScaleAnimation(0.28f,1f,toY,1f,mScreenWidth/2,dp2px(this,148));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0f,1f);
        animationSet = new AnimationSet(true);
        animationSet.addAnimation(expandAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setDuration(500);
        animationSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                mViewBottom.setVisibility(View.VISIBLE);
                mBtnBottom.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                isMax = true;

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        lessenAnimation = new ScaleAnimation(1f,0.28f,1f,toY,mScreenWidth/2,dp2px(this,148));
        lessenAnimation.setDuration(500);
        lessenAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mViewBottom.setVisibility(View.GONE);
                mBtnBottom.setVisibility(View.VISIBLE);
                isMax = false;
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    @OnClick(R.id.btn_start)
    void startAnimation(){
        if(!isMax){
            return;
        }
        mViewBottom.startAnimation(lessenAnimation);
    }
    @OnClick(R.id.btn_bottom)
    void endAnimation(){
        if(isMax){
            return;
        }
        mViewBottom.startAnimation(animationSet);
        EditText editText = new EditText(this);
        editText.addTextChangedListener(new myTextWatcher(new myTextWatcher.TextWatcherListener() {
            @Override
            public void onTextChanged(CharSequence charSequence) {

            }
        }));
    }

    public int dp2px(Context context, float dpVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dpVal, context.getResources().getDisplayMetrics());
    }

    public static class myTextWatcher implements TextWatcher {
        TextWatcherListener listener;

        public interface TextWatcherListener{
            void onTextChanged(CharSequence charSequence);
        }

        public myTextWatcher(TextWatcherListener listener){
            this.listener = listener;
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            listener.onTextChanged(charSequence);
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timer.cancel();
        timer = null;
    }
}
