package com.myz.myzexercise.Practice;

import com.myz.myzexercise.R;

import org.litepal.LitePal;

import java.util.List;

import bean.Book;
import butterknife.OnClick;

public class LitePalTest extends BaseActivity {
    int id = 0;


    @Override
    protected int getContentLayout() {
        return R.layout.litepal_test;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        LitePal.getDatabase();
    }

    @Override
    protected void initEvent() {

    }

    @OnClick(R.id.btn_add)
    void add(){
        Book book = new Book();
        book.setAuthor("11");
        book.setId(id);
        book.setPages(11);
        book.setName("222");
        book.setPrice(11d);
        book.save();
        id++;
    }

    @OnClick(R.id.btn_get)
    void get(){
        List<Book> bookList = LitePal.findAll(Book.class);
        for (Book book : bookList) {

        }
    }
    @OnClick(R.id.btn_del)
    void del(){
        LitePal.deleteAll(Book.class);

    }


}
