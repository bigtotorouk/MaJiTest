package com.maji.majitest.ui.main

import com.maji.majitest.bean.DataBean

interface IMain{
    interface VP{
        fun reqIndex()
        fun resIndex(bean:DataBean)

        fun reqLastIndex()
        fun resLastIndex(bean:DataBean)

        fun resError(msg:String)
    }

    interface M{
        fun reqIndex()
        fun reqLastIndex()
    }
}