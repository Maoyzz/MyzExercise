package com.myz.myzexercise;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import butterknife.BindView;

public class TouchActivity extends BaseActivity implements View.OnTouchListener{
    @BindView(R.id.tv_bottom)
    TextView mTvBottom;
    private int sx;
    private int sy;
    private int top = 1400;

    @Override
    protected int getContentLayout() {
        return R.layout.activity_touch;
    }

    @Override
    protected void initView() {
        mTvBottom.post(new Runnable() {
            @Override
            public void run() {
                mTvBottom.layout(mTvBottom.getLeft(),top,mTvBottom.getRight(),mTvBottom.getBottom());
            }
        });
        mTvBottom.setOnTouchListener(this);

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvent() {

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (view.getId()){
            case R.id.tv_bottom:
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        sx = (int) motionEvent.getRawX();
                        sy = (int) motionEvent.getRawY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        int x = (int) motionEvent.getRawX();
                        int y = (int) motionEvent.getRawY();
                        Log.e("mao", "y:"+y+"sy:"+sy );
                        mTvBottom.layout(mTvBottom.getLeft(),top +(y-sy),mTvBottom.getRight(),mTvBottom.getBottom());
                        break;
                    case MotionEvent.ACTION_UP:
                        if(mTvBottom.getTop() > 700){
                            top = 1400;
                            TranslateAnimation transAnim = new TranslateAnimation(0, 0, 0, 100);
//                            mTvBottom.layout(mTvBottom.getLeft(),1400,mTvBottom.getRight(),mTvBottom.getBottom());
                            transAnim.setDuration(2000);
                            mTvBottom.startAnimation(transAnim);
                        }else {
                            top = 150;
                            mTvBottom.layout(mTvBottom.getLeft(),150,mTvBottom.getRight(),mTvBottom.getBottom());
                        }
                        break;
                }
        }
        return true;
    }
}
