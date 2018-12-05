package com.myz.myzexercise.Practice;

import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.myz.myzexercise.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import bean.Book;
import weight.IOSDialog;

public class NavigationDrawerActivity extends AppCompatActivity {

    private RecyclerView mRvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        init();
    }

    private void init(){
        mRvTest = findViewById(R.id.rv_test);
        mRvTest.setLayoutManager(new LinearLayoutManager(this));
        List<Book> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Book book = new Book();
            book.setName("button"+i);
            list.add(book);
        }
        mRvTest.setAdapter(new myAdapter(list));
        IOSDialog dialog = new IOSDialog.Builder(this)
                .status(IOSDialog.DIALOG_STATUS_SINGLE)
                .title("dialog_test")
                .titleTextColor(R.color.colorPrimary)
                .addSingleBtn(new IOSDialog.Button("确定", new IOSDialog.btnClick() {
                    @Override
                    public void click() {
                        ToastUtils.showShort("confirm!!!");
                    }
                })).create();
        dialog.show();
        AlertDialog dialog1 = new AlertDialog.Builder(this).setTitle("1111").create();
//        dialog1.show();
    }

    public class myAdapter extends BaseQuickAdapter<Book,BaseViewHolder>{

        public myAdapter( @Nullable List<Book> data) {
            super(R.layout.item_layout_test,data);
        }

        @Override
        protected void convert(BaseViewHolder helper, Book item) {
            helper.setText(R.id.tv_test,item.getName());
        }
    }
}
