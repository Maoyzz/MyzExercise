package com.myz.myzexercise

import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_kotlin_test.*
import weight.MyDialog

class KotlinTestActivity : BaseActivity() {

    override fun getContentLayout(): Int {
        return R.layout.activity_kotlin_test
    }

    override fun initView() {
        tv_text.text = getMax(1,2).toString()
    }

    override fun initData() {
        var list = listOf<String>()
    }

    override fun initEvent() {

    }

    fun sum(a: Int,b: Int) :Int{
        return a + b
    }

    fun getMax(a: Int,b: Int)
            = if (a > b) a else b

}
