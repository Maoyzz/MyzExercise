package com.myz.myzexercise.Practice;

import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.myz.myzexercise.R;

import es.voghdev.pdfviewpager.library.RemotePDFViewPager;
import es.voghdev.pdfviewpager.library.adapter.PDFPagerAdapter;
import es.voghdev.pdfviewpager.library.remote.DownloadFile;
import es.voghdev.pdfviewpager.library.util.FileUtil;


@Route(path = "/com/PdfViewPagerActivity")
public class PdfViewPagerActivity extends BaseActivity implements DownloadFile.Listener {
    private RelativeLayout pdf_root;
    private RemotePDFViewPager remotePDFViewPager;
    private static final String mUrl = "http://www.gov.cn/zhengce/pdfFile/2018_PDF.pdf";
    private PDFPagerAdapter adapter;


    @Override
    protected int getContentLayout() {
        return R.layout.activity_pdfviewpager;
    }

    @Override
    protected void initView() {
        pdf_root = (RelativeLayout) findViewById(R.id.remote_pdf_root);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvent() {
        setDownloadListener();
    }

    /*设置监听*/
    protected void setDownloadListener() {
        final DownloadFile.Listener listener = this;
        remotePDFViewPager = new RemotePDFViewPager(this, mUrl, listener);
        remotePDFViewPager.setId(R.id.pdfViewPager);
    }

    /*加载成功调用*/
    @Override
    public void onSuccess(String url, String destinationPath) {
        adapter = new PDFPagerAdapter(this, FileUtil.extractFileNameFromURL(url));
        remotePDFViewPager.setAdapter(adapter);
        updateLayout();
    }

    /*更新视图*/
    private void updateLayout() {
        pdf_root.removeAllViewsInLayout();
        pdf_root.addView(remotePDFViewPager, LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
    }

    /*加载失败调用*/
    @Override
    public void onFailure(Exception e) {

    }

    @Override
    public void onProgressUpdate(int progress, int total) {
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        adapter.close();
    }
}
