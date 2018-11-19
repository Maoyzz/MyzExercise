package weight;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.myz.myzexercise.R;

public class MyDialog extends Dialog implements View.OnClickListener{

    private Builder builder;
    private Context context;

    private TextView mTvTitle;
    private TextView mTvPositive;
    private TextView mTvNegative;
    private TextView mTvSingle;
    private LinearLayout mLayoutButton;

    private doubleButtonClickListener mDoubleButtonClickListener;
    private singleButtonClickListener mSingleButtonClickListener;



    private MyDialog(Builder builder) {
        super(builder.context,R.style.MyDialog);
        this.builder = builder;
        this.context = builder.context;
        initWindows();
        initView();
    }

    private void initWindows() {
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
        mTvPositive.setOnClickListener(this);
        mTvNegative.setOnClickListener(this);
        mTvSingle.setOnClickListener(this);
        if(builder.isSingle){
            mTvSingle.setVisibility(View.VISIBLE);
            mLayoutButton.setVisibility(View.GONE);
        }else {
            mTvSingle.setVisibility(View.GONE);
            mLayoutButton.setVisibility(View.VISIBLE);
        }
    }

    private void initView(){
        mTvTitle.setText(builder.title);
        if(builder.titleColor != 0){
            mTvTitle.setTextColor(context.getResources().getColor(builder.titleColor));
        }
        if(!builder.isSingle){
            mTvPositive.setText(builder.PositiveText);
            mTvNegative.setText(builder.NegativeText);
            if(builder.PositiveTextColor != 0){
                mTvPositive.setTextColor(context.getResources().getColor(builder.PositiveTextColor));
            }
            if(builder.NegativeTextColor != 0){
                mTvNegative.setTextColor(context.getResources().getColor(builder.NegativeTextColor));
            }
        }else {
            mTvSingle.setText(builder.SingleButtonText);
            if(builder.SingleButtonTextColor != 0){
                mTvSingle.setTextColor(context.getResources().getColor(builder.SingleButtonTextColor));
            }
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_positive:
                if(mDoubleButtonClickListener != null){
                    mDoubleButtonClickListener.positiveClick();
                }
                break;
            case R.id.tv_negative:
                if(mDoubleButtonClickListener != null){
                    mDoubleButtonClickListener.negativeClick();
                }
                break;
            case R.id.tv_btn_single:
                if(mSingleButtonClickListener != null){
                    mSingleButtonClickListener.click();
                }
                break;
        }
    }

    public interface doubleButtonClickListener{
        void positiveClick();
        void negativeClick();
    }

    public interface singleButtonClickListener{
        void click();
    }

    public MyDialog setDoubleButtonClickListenr(doubleButtonClickListener doubleButtonClickListenr){
        this.mDoubleButtonClickListener = doubleButtonClickListenr;
        return this;
    }

    public MyDialog setSingleButtonClickListener(singleButtonClickListener singleButtonClickListener){
        this.mSingleButtonClickListener = singleButtonClickListener;
        return this;
    }

    public MyDialog setTitles(String title){
        mTvTitle.setText(title);
        return this;
    }

    public MyDialog setTitles(int StringId){
        mTvTitle.setText(builder.context.getResources().getString(StringId));
        return this;
    }

    public MyDialog setTitleColor(int Color){
        mTvTitle.setTextColor(Color);
        return this;
    }

    public MyDialog setPositiveText(String text){
        mTvPositive.setText(text);
        return this;
    }

    public MyDialog setPositiveText(int StringId){
        mTvPositive.setText(context.getResources().getString(StringId));
        return this;
    }

    public MyDialog setPositiveTextColor(int Color){
        mTvPositive.setTextColor(Color);
        return this;
    }

    public MyDialog setNegativeText(String text){
        mTvNegative.setText(text);
        return this;
    }

    public MyDialog setNegativeText(int StringId){
        mTvNegative.setText(context.getResources().getString(StringId));
        return this;
    }

    public MyDialog setNegativeTextColor(int Color){
        mTvNegative.setTextColor(Color);
        return this;
    }

    public MyDialog setSingleButtonText(int StringId){
        mTvSingle.setText(context.getResources().getString(StringId));
        return this;
    }

    public MyDialog setSingleButtonText(String text){
        mTvSingle.setText(text);
        return this;
    }

    public MyDialog setSingleButtonTextColor(int Color){
        mTvSingle.setText(Color);
        return this;
    }



    public static class Builder{

        private Context context;
        //判读是不是点选
        private Boolean isSingle = false;
        //文字
        private String title = "";
        //文字颜色
        private int titleColor = 0;
        //确认按钮文字
        private String PositiveText = "";
        //取消按钮文字
        private String NegativeText = "";
        //单选按钮文字
        private String SingleButtonText = "";
        //确认按钮文字颜色
        private int PositiveTextColor = 0;
        //取消按钮文字颜色
        private int NegativeTextColor = 0;
        //单选按钮文字颜色
        private int SingleButtonTextColor = 0;

        public Builder(Context context){
            this.context = context;
        }

        public Builder isSingle(Boolean isSingle){
            this.isSingle = isSingle;
            return this;
        }

        public Builder title(String title){
            this.title = title;
            return this;
        }

        public Builder titleColor(int Color){
            this.titleColor = Color;
            return this;
        }

        public Builder positiveText(String text){
            this.PositiveText = text;
            return this;
        }

        public Builder positiveText(int StringId){
            this.PositiveText = context.getResources().getString(StringId);
            return this;
        }

        public Builder positiveTextColor(int Color){
            this.PositiveTextColor = Color;
            return this;
        }

        public Builder negativeText(String text){
            this.NegativeText = text;
            return this;
        }

        public Builder negativeTextColor(int Color){
            this.NegativeTextColor = Color;
            return this;
        }

        public Builder singleButtonText(String text){
            this.SingleButtonText = text;
            return this;
        }

        public Builder singleButtonText(int StringId){
            this.SingleButtonText = context.getResources().getString(StringId);
            return this;
        }

        public Builder singleButtonTextColor(int Color){
            this.SingleButtonTextColor = Color;
            return this;
        }

        public MyDialog create(){
            return new MyDialog(this);
        }

    }

    private static int dp2px(Context context, float dpVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dpVal, context.getResources().getDisplayMetrics());
    }

}
