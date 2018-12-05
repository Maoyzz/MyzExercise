package com.myz.myzexercise.Practice;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.myz.myzexercise.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;

public class JiaoziVideoPlayerActivity extends AppCompatActivity {

    @BindView(R.id.videoplayer)
    JzvdStd videoplayer;

    private String ImageUri1 = "http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640";
    private String VideoUri1 = "http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4";
    private String VideoUri2 = "https://f.us.sinaimg.cn/0039jjtllx07iopXTrhu01040200P2Zn0k010.mp4?label=mp4_720p&template=28&Expires=1543301298&ssig=OV7pfD2t8l&KID=unistore,video";
    private String VideoUri3 = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jiaozi_video_player);
        ButterKnife.bind(this);
        videoplayer.setUp(VideoUri2
                , "饺子闭眼睛", Jzvd.SCREEN_WINDOW_NORMAL);
        videoplayer.thumbImageView.setImageURI(Uri.parse(ImageUri1));
    }
}
