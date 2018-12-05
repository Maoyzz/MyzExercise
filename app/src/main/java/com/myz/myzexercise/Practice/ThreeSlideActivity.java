package com.myz.myzexercise.Practice;

import android.animation.ValueAnimator;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.myz.myzexercise.R;

import Utils.DensityUtils;
import butterknife.BindView;

public class ThreeSlideActivity extends BaseActivity implements View.OnTouchListener {


    @BindView(R.id.ll_slide)
    LinearLayout mLlSlide;
    @BindView(R.id.view_touch)
    View mViewTouch;
    @BindView(R.id.rv_test)
    RecyclerView mRvTest;


    @Override
    protected int getContentLayout() {
        return R.layout.activity_three_level_slide;
    }

    @Override
    protected void initView() {
        mLlSlide.post(new Runnable() {
            @Override
            public void run() {
//                mLlSlide.setTranslationY(DensityUtils.dp2px(getApplicationContext(),50));
                thirdY = mLlSlide.getBottom() - DensityUtils.dp2px(getApplicationContext(),50);
                secondY = mLlSlide.getBottom() - DensityUtils.dp2px(getApplicationContext(),200);
            }
        });

    }

    @Override
    protected void initData() {
        mViewTouch.setOnTouchListener(this);
        mLlSlide.setOnTouchListener(this);
    }

    @Override
    protected void initEvent() {

    }
    int y1 = 0;
    int y2 = 0;
    int firstY = 0;
    int secondY;
    int thirdY;
    int tempY = 0;
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (view.getId()){
            case R.id.view_touch:
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        y1 = (int)motionEvent.getRawY();
                        y2 = y1;
                        break;
                    case MotionEvent.ACTION_MOVE:
                        y2 = (int)motionEvent.getRawY();
                        if(tempY + y2 - y1 >= 0){
                            mLlSlide.setTranslationY(tempY + y2 - y1);
                        }else {
                            y2 = 0;
                        }

                        break;
                    case MotionEvent.ACTION_UP:
                        tempY = tempY + y2 - y1;
                        if(tempY <= (secondY + firstY) / 2 && tempY < secondY){
                            startAnimals(mLlSlide,tempY,0);
                            tempY = 0;
                        }else if(tempY > (secondY + firstY) / 2 && tempY < secondY){
                            startAnimals(mLlSlide,tempY,secondY);
                            tempY = secondY;
                        }else if(tempY <= (thirdY + secondY) / 2 && tempY >= secondY && tempY <= thirdY){
                            startAnimals(mLlSlide,tempY,secondY);
                            tempY = secondY;
                        }else if(tempY > (thirdY + secondY) / 2 && tempY >= secondY && tempY <= thirdY){
                            startAnimals(mLlSlide,tempY,thirdY);
                            tempY = thirdY;
                        }
                        break;
                }
                break;
        }


        return true;
    }
    private ValueAnimator animator;
    public void startAnimals(final LinearLayout layout, float startY, float endY){
        animator = ValueAnimator.ofFloat(startY, endY);
        animator.setDuration(200);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                layout.setTranslationY((Float) animation.getAnimatedValue());
            }
        });
        animator.start();
    }
}
