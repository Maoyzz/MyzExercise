package com.myz.myzexercise.Practice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.myz.myzexercise.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        //照相机练习
        findViewById(R.id.btn_camera).setOnClickListener(this);
        //switch button
        findViewById(R.id.btn_switch).setOnClickListener(this);
        //my dialog
        findViewById(R.id.btn_mydialog).setOnClickListener(this);
        //my dialog
        findViewById(R.id.btn_router).setOnClickListener(this);
        //pdf
        findViewById(R.id.btn_pdf).setOnClickListener(this);
        //btn_pdf_viewer
        findViewById(R.id.btn_pdf_viewer).setOnClickListener(this);
        //btn_pdf_viewer
        findViewById(R.id.btn_agent).setOnClickListener(this);
        //btn_touch
        findViewById(R.id.btn_touch).setOnClickListener(this);
        //高德聚合
        findViewById(R.id.btn_gaode_cluster).setOnClickListener(this);
        //kotlin test
        findViewById(R.id.btn_kotlin).setOnClickListener(this);
        //other
        findViewById(R.id.btn_other).setOnClickListener(this);
        //btn_fragment_test
        findViewById(R.id.btn_fragment_test).setOnClickListener(this);
//        btn_litepal
        findViewById(R.id.btn_litepal).setOnClickListener(this);

        findViewById(R.id.btn_three_slide).setOnClickListener(this);

        findViewById(R.id.btn_loaderview).setOnClickListener(this);

        findViewById(R.id.btn_baseloader).setOnClickListener(this);

        findViewById(R.id.btn_AndroidUtilCode).setOnClickListener(this);

        findViewById(R.id.btn_hupu).setOnClickListener(this);

        findViewById(R.id.btn_fragment).setOnClickListener(this);

        findViewById(R.id.btn_NavigationDrawer).setOnClickListener(this);

        findViewById(R.id.btn_animation).setOnClickListener(this);

        findViewById(R.id.btn_dialog_fragment).setOnClickListener(this);

        findViewById(R.id.jiaoziVideo).setOnClickListener(this);

        findViewById(R.id.btn_litepal2).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_camera:
                startActivity(new Intent(MainActivity.this,CameraExerciseActivity.class));
                break;
            case R.id.btn_switch:
                startActivity(new Intent(MainActivity.this,SwitchActivity.class));
                break;
            case R.id.btn_mydialog:
//                startActivity(new Intent(MainActivity.this,MyDialogActivity.class));
                Intent intent = new Intent(MainActivity.this,MyDialogActivity.class);
                intent.putExtra("text","1");
                startActivity(intent);
                break;
            case R.id.btn_router:
                List<TestModel1> list = new ArrayList<>();
                list.add(new TestModel1(1));
                ARouter.getInstance()
                        .build("/com/ARouterActivity")
                        .withSerializable("list",(Serializable)list)
                        .navigation(this,100);
                break;
            case R.id.btn_pdf:
                ARouter.getInstance().build("/com/PdfViewPagerActivity").navigation();
                break;
            case R.id.btn_pdf_viewer:
                ARouter.getInstance().build("/com/PDFviewerActivity").navigation();
                break;
            case R.id.btn_agent:
                startActivity(new Intent(MainActivity.this,WebViewActivity.class));
                break;
            case R.id.btn_touch:
                startActivity(new Intent(MainActivity.this,TouchActivity.class));
                break;
            case R.id.btn_gaode_cluster:
                startActivity(new Intent(MainActivity.this,GaodeClusterActivity.class));
                break;
            case R.id.btn_kotlin:
                startActivity(new Intent(MainActivity.this,KotlinTestActivity.class));
                break;
            case R.id.btn_fragment_test:
                startActivity(new Intent(MainActivity.this,FragmentTestActivity.class));
                break;
            case R.id.btn_litepal:
                startActivity(new Intent(MainActivity.this,LitePalTest.class));
                break;
            case R.id.btn_other:
                startActivity(new Intent(MainActivity.this,OtherActivity.class));
                break;
            case R.id.btn_three_slide:
                startActivity(new Intent(MainActivity.this,ThreeSlideActivity.class));
                break;
            case R.id.btn_loaderview:
                startActivity(new Intent(MainActivity.this,LoaderviewlibraryActivity.class));
                break;
            case R.id.btn_baseloader:
                startActivity(new Intent(MainActivity.this,ProgressLYTActivity.class));
                break;
            case R.id.btn_AndroidUtilCode:
                startActivity(new Intent(MainActivity.this,AndroidUtilCodeActivity.class));
                break;
            case R.id.btn_hupu:
                startActivity(new Intent(MainActivity.this,VerticalViewPagerActivity.class));
                break;

            case R.id.btn_fragment:
                startActivity(new Intent(MainActivity.this,FragmentTestActivity.class));
                break;

            case R.id.btn_NavigationDrawer:
                startActivity(new Intent(MainActivity.this,NavigationDrawerActivity.class));
                break;
            case R.id.btn_animation:
                startActivity(new Intent(MainActivity.this,AnimationActivity.class));
                break;
            case R.id.btn_dialog_fragment:
                startActivity(new Intent(MainActivity.this,DialogFragmentTest.class));
                break;
            case R.id.jiaoziVideo:
                startActivity(new Intent(MainActivity.this,JiaoziVideoPlayerActivity.class));
                break;
            case R.id.btn_litepal2:
                startActivity(new Intent(MainActivity.this,LitepalTestActivity.class));
                break;

            default:
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100){
            Log.e("mao", "100");
        }
    }
}
