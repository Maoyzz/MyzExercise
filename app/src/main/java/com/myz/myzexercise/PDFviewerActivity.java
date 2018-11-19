package com.myz.myzexercise;

import android.Manifest;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnErrorListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;

import java.io.File;
import java.net.URI;

import Utils.DownloadUtil;
import butterknife.BindView;
import butterknife.OnClick;


@Route(path = "/com/PDFviewerActivity")
public class PDFviewerActivity extends BaseActivity {

    private static final int REQUEST_EXTERNAL_STORAGE = 1;

    //https://github.com/barteksc/AndroidPdfViewer
    @BindView(R.id.pdfView)
    PDFView mPdfView;
    @BindView(R.id.tv_pages)
    TextView mTvPages;
    //https://github.com/voghDev/PdfViewPager

    @Override
    protected int getContentLayout() {
        return R.layout.activity_pdf;
    }

    @Override
    protected void initView() {
        getPermission();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvent() {

    }

    @OnClick(R.id.btn_pdfviewer)
    void btn_pdfviewer(){
        Uri uri = Uri.parse("http://www.gov.cn/zhengce/pdfFile/2018_PDF.pdf");
//        mPdfView.fromUri(uri)
//                .pages(0, 2, 1, 3, 3, 3) // all pages are displayed by default
//                .enableSwipe(true) // allows to block changing pages using swipe
//                .swipeHorizontal(false)
//                .enableDoubletap(true)
//                .defaultPage(0)
//                // allows to draw something on the current page, usually visible in the middle of the screen
////                .onDraw(onDrawListener)
////                // allows to draw something on all pages, separately for every page. Called only for visible pages
////                .onDrawAll(onDrawListener)
//                .onLoad(new OnLoadCompleteListener() {
//                    @Override
//                    public void loadComplete(int nbPages) {
//                        Log.e(TAG, "loadComplete: "+nbPages );
//                    }
//                }) // called after document is loaded and starts to be rendered
////                .onPageChange(onPageChangeListener)
////                .onPageScroll(onPageScrollListener)
//                .onError(new OnErrorListener() {
//                    @Override
//                    public void onError(Throwable t) {
//                        Log.e(TAG, "onError: "+t );
//                    }
//                })
////                .onRender(onRenderListener) // called after document is rendered for the first time
//                .enableAnnotationRendering(false) // render annotations (such as comments, colors or forms)
//                .password(null)
//                .scrollHandle(null)
//                .enableAntialiasing(true) // improve rendering a little bit on low-res screens
//                // spacing between pages in dp. To define spacing color, set view background
//                .spacing(0);
        loadFromUrl(mPdfView);

    }

    private void loadFromUrl(final PDFView mPdfView){
        final String SDPath = Environment.getExternalStorageDirectory().getAbsolutePath()+"/PDFViewCache/";
        DownloadUtil.getInstance().download("http://www.gov.cn/zhengce/pdfFile/2018_PDF.pdf", SDPath, new DownloadUtil.OnDownloadListener() {
            @Override
            public void onDownloadSuccess(File file) {
//                File file = new File(SDPath, path);
                mPdfView.fromFile(file).defaultPage(0).swipeHorizontal(false).onPageChange(new OnPageChangeListener() {
                    @Override
                    public void onPageChanged(int page, int pageCount) {
                        mTvPages.setVisibility(View.VISIBLE);
                        mTvPages.setText((page + 1) + "/" + pageCount );
                        Log.e(TAG, "alive:"+DownloadUtil.getInstance().getIsAlive() );
                    }
                }).onError(new OnErrorListener() {
                    @Override
                    public void onError(Throwable t) {
                        Log.e(TAG, "onError: "+ t);
                    }
                }).load();
                Log.e(TAG, "onDownloadSuccess: " );
            }

            @Override
            public void onDownloading(int progress) {
                Log.e(TAG, "onDownloading: " );
            }

            @Override
            public void onDownloadFailed() {
                Log.e(TAG, "onDownloadFailed: " );
            }
        });
    }



    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    /**
     * 获取动态权限
     */
    public void getPermission() {
        int hasWriteContactsPermission = ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE);
        if (hasWriteContactsPermission != PackageManager.PERMISSION_GRANTED) {
            if (!ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)) {
                Log.d("mao", "get permission");
                ActivityCompat.requestPermissions(this,
                        PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
            }
            Log.d("mao", "get permission2");
            ActivityCompat.requestPermissions(this,
                    PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
        }
        Log.d("mao", "wait for PERMISSION_GRANTED");
        while ((ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)) != PackageManager.PERMISSION_GRANTED) {
        }
        Log.d("mao", "wait for PERMISSION_GRANTED finish");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
