package com.maji.majitest.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper
import com.j256.ormlite.support.ConnectionSource
import com.j256.ormlite.table.TableUtils
import com.maji.majitest.model.DataBean


//TODO 参数一 上下文，参数二 数据库名，参数三 工厂 null默认为系统工厂，参数四 版本号
class TakeoutOpenHelper(val context: Context) :
    OrmLiteSqliteOpenHelper(context, "my_db", null, 2) {
    override fun onCreate(database: SQLiteDatabase?, connectionSource: ConnectionSource?) {
        //创建user表
        TableUtils.createTable(connectionSource, DataBean::class.java)
    }

    //更新数据库的方法
    override fun onUpgrade(
        database: SQLiteDatabase?,
        connectionSource: ConnectionSource?,
        oldVersion: Int,
        newVersion: Int
    ) {
    }

}