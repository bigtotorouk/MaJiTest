package com.maji.majitest.mvp.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity<V, M, P:BasePresenter<V, M>>: AppCompatActivity() {
    var presenter: P? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getContentId())
        presenter = initPresenter()
        presenter!!.bindView(this as V)
        initView()
        initListener()
    }


    abstract fun getContentId(): Int
    abstract fun initView()
    abstract fun initListener()
    abstract fun initPresenter(): P

//    /**可触摸时执行的操作**/
//    abstract fun doOnResume()
//
//    override fun onResume() {
//        super.onResume()
//        doOnResume()
//    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.unBindView()
    }
}