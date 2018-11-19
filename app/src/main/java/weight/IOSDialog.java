package weight;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.myz.myzexercise.App.App;
import com.myz.myzexercise.R;

import static com.myz.myzexercise.DensityUtils.dp2px;

public class IOSDialog extends Dialog {

    public static final int DIALOG_STATUS_DOUBLE = 0;
    public static final int DIALOG_STATUS_SINGLE = 1;
    private int mDialogStatus = DIALOG_STATUS_DOUBLE;

    private TextView mTvTitle;
    private TextView mTvPositive;
    private TextView mTvNegative;
    private TextView mTvSingle;
    private LinearLayout mLayoutButton;

    private IOSDialog(Builder builder) {
        super(builder.mContext,R.style.MyDialog);
        initWindows(builder);
        initView(builder);
    }

    private void initWindows(Builder builder) {
        Window window = this.getWindow();
        window.setContentView(R.layout.dialog_logout);
        window.setGravity(Gravity.CENTER);
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = window.getWindowManager().getDefaultDisplay().getWidth();
        window.setAttributes(lp);
        int DialogPadding = (int)dp2px(this.getContext(),50);
        window.getDecorView().setPadding(DialogPadding, 0, DialogPadding, 0);

        mTvTitle = (TextView)window.findViewById(R.id.tv_title);
        mTvPositive = (TextView)window.findViewById(R.id.tv_positive);
        mTvNegative = (TextView)window.findViewById(R.id.tv_negative);
        mTvSingle = (TextView)window.findViewById(R.id.tv_btn_single);
        mLayoutButton = (LinearLayout) window.findViewById(R.id.layout_dialog_judge);
        if(builder.mDialogStatus == DIALOG_STATUS_SINGLE){
            mTvSingle.setVisibility(View.VISIBLE);
            mLayoutButton.setVisibility(View.GONE);
        }else {
            mTvSingle.setVisibility(View.GONE);
            mLayoutButton.setVisibility(View.VISIBLE);
        }
    }
    
    private void initView(final Builder builder){
        if(builder.mTitleResId != 0){
            mTvTitle.setText(builder.mTitleResId);
        }else if(builder.mTitle != null && !builder.mTitle.equals("")){
            mTvTitle.setText(builder.mTitle);
        }else {
            mTvTitle.setText("");
        }

        if((builder.SingleBtn != null && builder.SingleBtn.textTextColorResId != 0)){
            mTvSingle.setTextColor(builder.SingleBtn.textTextColorResId);
        }
        if(builder.mDialogStatus == DIALOG_STATUS_SINGLE){
            if(builder.SingleBtn != null && builder.SingleBtn.textResId != 0){
                mTvSingle.setText(builder.SingleBtn.textResId);
            }else if(builder.SingleBtn != null && builder.SingleBtn.text != null && !builder.SingleBtn.text.equals("")){
                mTvSingle.setText(builder.SingleBtn.text);
            }else {
                mTvSingle.setText("");
            }
            
            if((builder.SingleBtn != null && builder.SingleBtn.textTextColorResId != 0)){
                mTvSingle.setTextColor(builder.SingleBtn.textTextColorResId);
            }
            
            mTvSingle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(builder.SingleBtn != null && builder.SingleBtn.mBtnClick != null){
                        builder.SingleBtn.mBtnClick.click();
                    } 
                    IOSDialog.this.dismiss();
                }
            });
            
        }else {
            if(builder.PositiveBtn != null && builder.PositiveBtn.textResId != 0){
                mTvPositive.setText(builder.PositiveBtn.textResId);
            }else if(builder.PositiveBtn != null && builder.PositiveBtn.text != null && !builder.PositiveBtn.text.equals("")){
                mTvPositive.setText(builder.PositiveBtn.text);
            }else {
                mTvPositive.setText("");
            }

            if((builder.PositiveBtn != null && builder.PositiveBtn.textTextColorResId != 0)){
                mTvPositive.setTextColor(builder.PositiveBtn.textTextColorResId);
            }

            mTvPositive.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(builder.PositiveBtn != null && builder.PositiveBtn.mBtnClick != null){
                        builder.PositiveBtn.mBtnClick.click();
                    }
                }
            });

            if(builder.NegitiveBtn != null && builder.NegitiveBtn.textResId != 0){
                mTvNegative.setText(builder.NegitiveBtn.textResId);
            }else if(builder.NegitiveBtn != null && builder.NegitiveBtn.text != null && !builder.NegitiveBtn.text.equals("")){
                mTvNegative.setText(builder.NegitiveBtn.text);
            }else {
                mTvNegative.setText("");
            }

            if((builder.NegitiveBtn != null && builder.NegitiveBtn.textTextColorResId != 0)){
                mTvNegative.setTextColor(builder.NegitiveBtn.textTextColorResId);
            }

            mTvNegative.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(builder.NegitiveBtn != null && builder.NegitiveBtn.mBtnClick != null){
                        builder.NegitiveBtn.mBtnClick.click();
                    }
                }
            });
        }
    }

    public static class Builder{

        private Context mContext;
        private int mDialogStatus;
        private String mTitle;
        private int mTitleResId;
        private int mTitleColorResId;
        private Button PositiveBtn;
        private Button NegitiveBtn;
        private Button SingleBtn;

        public Builder(Context mContext){
            this.mContext = mContext;
        }

        public Builder status(int mDialogStatus){
            this.mDialogStatus = mDialogStatus;
            return this;
        }

        public Builder title(String title){
            this.mTitle = title;
            return this;
        }

        public Builder title(int mTitleResId){
            this.mTitleResId = mTitleResId;
            return this;
        }

        public Builder titleTextColor(int mColorResId){
            this.mTitleColorResId = mTitleColorResId;
            return this;
        }

        public Builder addPositiveBtn(Button btn){
            this.PositiveBtn = btn;
            return this;
        }

        public Builder addNegitiveBtn(Button btn){
            this.NegitiveBtn = btn;
            return this;
        }

        public Builder addSingleBtn(Button btn){
            this.SingleBtn = btn;
            return this;
        }

        public IOSDialog create(){
            return new IOSDialog(this);
        }

    }

    public interface btnClick{
        void click();
    }

    public static class Button{

        public String text;
        public int textResId;
        public int textTextColorResId;
        public btnClick mBtnClick;

        public Button(String text,btnClick mBtnClick){
            this.text = text;
            this.mBtnClick = mBtnClick;
        }

        public Button(String text,int textTextColorResId,btnClick mBtnClick){
            this.text = text;
            this.textTextColorResId = textTextColorResId;
            this.mBtnClick = mBtnClick;
        }

        public Button(int textResId,btnClick mBtnClick){
            this.textResId = textResId;
            this.mBtnClick = mBtnClick;
        }

        public Button(int textResId,int textTextColorResId,btnClick mBtnClick){
            this.textResId = textResId;
            this.textTextColorResId = textTextColorResId;
            this.mBtnClick = mBtnClick;
        }

    }



}
