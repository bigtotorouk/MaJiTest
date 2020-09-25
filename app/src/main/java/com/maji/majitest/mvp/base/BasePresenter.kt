package com.maji.majitest.mvp.base

import android.content.Context

abstract class BasePresenter<V, M>(context:Context) {
    var view: V? = null

    var model: M? = null

    var context:Context

    init {
        this.context = context
        this.model = this.initModel()
    }

    fun bindView(view: V) {
        this.view = view
    }

    fun isBind(): Boolean {
        return view != null
    }

    fun unBindView() {
        if (isBind()) {
            view = null
        }
    }

    fun obtainView(): V? {
        return if (isBind()) view else null
    }

    abstract fun initModel(): M
}