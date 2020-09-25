package com.maji.majitest.ui.main

import android.content.Context
import com.maji.majitest.bean.DataBean
import com.maji.majitest.mvp.base.BaseActivity
import com.maji.majitest.mvp.base.BasePresenter

class MainPresenter(context: Context) : BasePresenter<MainActivity, MainModel>(context), IMain.VP {


    override fun reqLastIndex() {
        (model as MainModel).reqLastIndex()
    }

    override fun resLastIndex(bean: DataBean) {
        if(!isBind())
            return;
        (view as MainActivity)?.resLastIndex(bean)
    }

    override fun resIndex(bean: DataBean) {
        if(!isBind())
            return;
        (view as MainActivity)?.resIndex(bean)
    }

    override fun reqIndex() {
        (model as MainModel).reqIndex()
    }


    override fun initModel(): MainModel {
        return MainModel(this)
    }

    override fun resError(msg: String) {
        (view as MainActivity)?.resError(msg)
    }

}