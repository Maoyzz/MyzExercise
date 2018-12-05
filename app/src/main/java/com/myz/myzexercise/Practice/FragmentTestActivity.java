package com.myz.myzexercise.Practice;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.FragmentUtils;
import com.myz.myzexercise.R;

import butterknife.BindView;
import butterknife.OnClick;

public class FragmentTestActivity  extends BaseActivity{

    @BindView(R.id.tv_1)
    TextView mTv1;
    @BindView(R.id.tv_2)
    TextView mTv2;
    @BindView(R.id.tv_3)
    TextView mTv3;
    @BindView(R.id.rl_content)
    RelativeLayout mLayoutContent;
    @BindView(R.id.view_top)
    View mViewTop;


    private Fragment[]           mFragments = new Fragment[3];
    private int curIndex = 0;

    @Override
    protected int getContentLayout() {
        return R.layout.activity_fragment_test;
    }

    @Override
    protected void initView() {
        getSupportActionBar().hide();
    }

    @Override
    protected void initData() {
        mFragments[0] = Fragment1.newInstance();
        mFragments[1] = Fragment2.newInstance();
        mFragments[2] = Fragment3.newInstance();
        mLayoutContent.removeAllViews();
        FragmentUtils.add(getSupportFragmentManager(), mFragments, R.id.rl_content, curIndex);

        //base add fragment
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction  transaction = fragmentManager.beginTransaction();
//        transaction.add();
//        transaction.commit();
    }

    @Override
    protected void initEvent() {

    }

    @OnClick({R.id.tv_1,R.id.tv_2,R.id.tv_3})
    void click(TextView view){
        switch (view.getId()){
            case R.id.tv_1:
                FragmentUtils.showHide(curIndex = 0, mFragments);
                break;
            case R.id.tv_2:
                FragmentUtils.showHide(curIndex = 1, mFragments);
                break;
            case R.id.tv_3:
                FragmentUtils.showHide(curIndex = 2, mFragments);
                break;
        }
    }

    public static class Fragment1 extends Fragment{

        public Fragment1(){

        }

        public static Fragment1 newInstance(){
            Fragment1 fm = new Fragment1();
            return fm;
        }

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.layout_fragment1,container,false);
        }
    }

    public static class Fragment2 extends Fragment{

        public Fragment2(){

        }

        public static Fragment2 newInstance(){
            Fragment2 fm = new Fragment2();
            return fm;
        }

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.layout_fragment2,container,false);
        }
    }

    public static class Fragment3 extends Fragment{

        public Fragment3(){

        }

        public static Fragment3 newInstance(){
            Fragment3 fm = new Fragment3();
            return fm;
        }

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.layout_fragment3,container,false);

        }
    }
    public static class myService extends Service{

        public myService(){

        }


        @Override
        public void onCreate() {
            super.onCreate();
            CountDownTimer timer = new CountDownTimer(60000,1000) {
                @Override
                public void onTick(long l) {
                    Log.e(TAG, "onTick: "+ l );
                }

                @Override
                public void onFinish() {

                }
            };
            timer.start();
        }

        @Nullable
        @Override
        public IBinder onBind(Intent intent) {
            return null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
