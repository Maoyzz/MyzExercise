package com.myz.myzexercise.Practice

import com.myz.myzexercise.R
import com.myz.myzexercise.R.id.tv_text
import kotlinx.android.synthetic.main.activity_kotlin_test.*

class KotlinTestActivity : BaseActivity() {

    override fun getContentLayout(): Int {
        return R.layout.activity_kotlin_test
    }

    override fun initView() {
//        tv_text.text = getMax(1,2).toString()
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
