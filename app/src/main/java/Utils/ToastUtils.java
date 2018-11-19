package Utils;

import android.content.Context;

public class ToastUtils {
    private static final String TAG = "mao";


    public static class Toast{

        private Context context;
        private String text;
        private Boolean isLong = false;
        private android.widget.Toast mToast;

        public Toast context(Context context){
            this.context = context;
            mToast = android.widget.Toast.makeText(context,text,(isLong ? android.widget.Toast.LENGTH_LONG:android.widget.Toast.LENGTH_SHORT));
            return this;
        }

        public Toast text(String text){
            this.text = text;
            mToast = android.widget.Toast.makeText(context,text,(isLong ? android.widget.Toast.LENGTH_LONG:android.widget.Toast.LENGTH_SHORT));
            return this;
        }

        public Toast isLong(Boolean isLong){
            this.isLong = isLong;
            mToast = android.widget.Toast.makeText(context,text,(isLong ? android.widget.Toast.LENGTH_LONG:android.widget.Toast.LENGTH_SHORT));
            return this;
        }

        public void show(){
            mToast.show();
        }
    }
}
