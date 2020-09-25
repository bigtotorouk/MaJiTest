package com.maji.majitest.mvp.base

import java.lang.ref.WeakReference

abstract class BaseModel<P>(mPresenter:P){
    var presenter:P

    init {
        this.presenter = mPresenter
    }
}