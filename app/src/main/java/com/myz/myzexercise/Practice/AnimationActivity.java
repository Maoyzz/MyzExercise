package com.myz.myzexercise.Practice;

import android.animation.ObjectAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.myz.myzexercise.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.view.animation.Animation.ABSOLUTE;
import static android.view.animation.Animation.RELATIVE_TO_PARENT;

public class AnimationActivity extends AppCompatActivity {
    @BindView(R.id.img)
    ImageView mImg;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        ButterKnife.bind(this);
        getSupportActionBar().setTitle("三种动画的练习");
        initView();
    }

    private void initView() {

    }

    @OnClick({R.id.btn_frame,R.id.btn_tweened,R.id.btn_value})
    void click(View view){
        switch (view.getId()){
            case R.id.btn_frame:
                mImg.setVisibility(View.VISIBLE);
                mImg.setImageResource(R.drawable.frame_anim);
                AnimationDrawable animationDrawable = (AnimationDrawable) mImg.getDrawable();
                animationDrawable.start();
                break;
            case R.id.btn_tweened:
                mImg.setImageResource(R.mipmap.ic_launcher);
                mImg.setVisibility(View.VISIBLE);
                //draw xml 实现
                Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale);
                animation.setDuration(200);
                mImg.startAnimation(animation);
                //代码实现
                //1.AlphaAnimation透明度动画
                AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
                //2.TranslateAnimation平移动画
                TranslateAnimation translateAnimation = new TranslateAnimation(0, 300, 0, 300);
                //3.RotateAnimation旋转动画
                RotateAnimation rotateAnimation = new RotateAnimation(0, 360, RELATIVE_TO_PARENT, 0.2F, RELATIVE_TO_PARENT, 0.2F);
                //4.ScaleAnimation缩放动画
                ScaleAnimation scaleAnimation = new ScaleAnimation(0f, 1f, 0f, 1f, ABSOLUTE, 0.5f, ABSOLUTE, 0.5f);
                break;
            case R.id.btn_value:
                mImg.setImageResource(R.mipmap.ic_launcher);
                mImg.setVisibility(View.VISIBLE);
                ObjectAnimator alphaAnim = ObjectAnimator.ofFloat(mImg, "alpha", 1.0f, 0.5f, 0.8f, 1.0f);
                ObjectAnimator scaleXAnim = ObjectAnimator.ofFloat(mImg, "scaleX", 0.0f, 1.0f);
                ObjectAnimator scaleYAnim = ObjectAnimator.ofFloat(mImg, "scaleY", 0.0f, 2.0f);
                ObjectAnimator rotateAnim = ObjectAnimator.ofFloat(mImg, "rotation", 0, 360);
                ObjectAnimator transXAnim = ObjectAnimator.ofFloat(mImg, "translationX", 100, 400);
                ObjectAnimator transYAnim = ObjectAnimator.ofFloat(mImg, "translationY", 100, 750);
                scaleXAnim.setDuration(2000);
                scaleXAnim.start();
                break;
        }
    }
}
