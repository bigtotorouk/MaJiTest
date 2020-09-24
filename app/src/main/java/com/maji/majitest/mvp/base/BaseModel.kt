package com.maji.majitest.mvp.base

import java.lang.ref.WeakReference

abstract class BaseModle<P:BasePresenter>{
    var p: WeakReference<P>? = null
}