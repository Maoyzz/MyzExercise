package com.myz.myzexercise;

import android.widget.LinearLayout;

import com.just.agentweb.AgentWeb;
import com.just.agentweb.AgentWebView;

import butterknife.BindView;

public class WebViewActivity extends BaseActivity {
    AgentWeb mAgentWeb;
    @BindView(R.id.ll_web)
    LinearLayout mLLWeb;

    @Override
    protected int getContentLayout() {
        return R.layout.activity_web;
    }

    @Override
    protected void initView() {
        mAgentWeb = AgentWeb.with(this)
                .setAgentWebParent(mLLWeb, new LinearLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()// 使用默认进度条
                .createAgentWeb()//
                .ready()
                .go("http//www.baidu.com");
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvent() {

    }
}
