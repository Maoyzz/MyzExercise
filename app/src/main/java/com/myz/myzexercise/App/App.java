package com.myz.myzexercise.App;

import android.app.Application;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.Utils;
import com.bumptech.glide.Glide;
import com.gw.swipeback.tools.WxSwipeBackActivityManager;
import com.myz.myzexercise.VirtualViewActivity;
import com.tmall.wireless.tangram.TangramBuilder;
import com.tmall.wireless.tangram.util.IInnerImageSetter;

import org.litepal.LitePal;
import org.litepal.LitePalApplication;

public class App extends Application {

    public static App INSTANCE;

    public static App getInstance(){
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ARouter.openLog();     // 打印日志
        ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        ARouter.init( this );
        LitePal.initialize(this);
        TangramBuilder.init(this, new IInnerImageSetter() {
            @Override
            public <IMAGE extends ImageView> void doLoadImageUrl(@NonNull IMAGE view, @Nullable String url) {
                Glide.with(App.this).load(url).into(view);
            }
        },ImageView.class);
        Utils.init(this);
        WxSwipeBackActivityManager.getInstance().init(this);
    }
}
