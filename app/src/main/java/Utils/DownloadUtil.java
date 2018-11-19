package Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DownloadUtil {
    private static DownloadUtil downloadUtil;
    private final OkHttpClient okHttpClient;
    private myThread mMyThread;
    private Boolean isContinue = true;
    public static DownloadUtil getInstance() {
        if (downloadUtil == null) {
            downloadUtil = new DownloadUtil();
        }
        return downloadUtil;
    }

    private DownloadUtil() {
        okHttpClient = new OkHttpClient();
    }

    public void download(final String url,final String saveDir,final OnDownloadListener listener){
        mMyThread = new myThread(url,saveDir,listener);
        isContinue = true;
        mMyThread.start();
    }

    private class myThread extends Thread{
        private String url;
        private String saveDir;
        private OnDownloadListener listener;

        private myThread(String url,String saveDir,OnDownloadListener listener){
            super();
            this.url = url;
            this.saveDir = saveDir;
            this.listener = listener;
        }

        @Override
        public void run() {
            super.run();
            DownloadUtil.this.listener=listener;
            Request request=new Request.Builder().url(url).build();
            okHttpClient.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    listener.onDownloadFailed();
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    InputStream is=null;
                    byte[] buf=new byte[2048];
                    int len=0;
                    FileOutputStream fos=null;
                    //储存下载文件的目录
                    String savePath=isExistDir(saveDir);
                    try{
                        is=response.body().byteStream();
                        long total=response.body().contentLength();
                        File file=new File(savePath,getNameFromUrl(url));
                        fos=new FileOutputStream(file);
                        long sum=0;
                        while((len = is.read(buf))!=-1){
                            fos.write(buf,0,len);
                            sum+=len;
                            int progress=(int)(sum*1.0f/total*100);
                            //下载中
                            listener.onDownloading(progress);
                        }
                        fos.flush();
                        //下载完成
                        listener.onDownloadSuccess(file);
                    }catch (Exception e){
                        listener.onDownloadFailed();
                    }finally{
                        try{
                            if(is!=null)
                                is.close();
                        }catch (IOException e){

                        }
                        try {
                            if(fos!=null){
                                fos.close();
                            }
                        }catch (IOException e){

                        }
                    }
                }
            });
        }
    }

    private String getNameFromUrl(String url) {
        return url.substring(url.lastIndexOf("/")+1);
    }


    private String isExistDir(String saveDir) throws IOException {
        File downloadFile=new File(saveDir);
        if(!downloadFile.mkdirs()){
            downloadFile.createNewFile();
        }
        String savePath=downloadFile.getAbsolutePath();
        return savePath;
    }

    public Boolean getIsAlive(){
        return mMyThread.isAlive();
    }


    OnDownloadListener listener;
    public interface OnDownloadListener{
        /**
         * 下载成功
         */
        void onDownloadSuccess(File file);
        /**
         * 下载进度
         * @param progress
         */
        void onDownloading(int progress);
        /**
         * 下载失败
         */
        void onDownloadFailed();
    }

}
