package com.maji.majitest.ui.main

import android.util.Log
import com.j256.ormlite.dao.Dao
import com.maji.majitest.api.AppClientManager
import com.maji.majitest.api.GithubApi
import com.maji.majitest.bean.DataBean
import com.maji.majitest.db.TakeoutOpenHelper
import com.maji.majitest.mvp.base.BaseModel
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class MainModel(mPresenter: MainPresenter) : BaseModel<MainPresenter>(mPresenter), IMain.M {

    init {
        this.presenter = presenter
    }

    override fun reqIndex() {
        var api = AppClientManager.client.create(GithubApi::class.java)
        api.index()
            .enqueue(object:retrofit2.Callback<DataBean> {
                override fun onFailure(call: Call<DataBean>, t: Throwable) {
                    print(t.toString())
                }

                override fun onResponse(call: Call<DataBean>, response: Response<DataBean>) {
//                    if(isRunning){
//                        var bean = response.body()
////                        Log.v(TAG, bean.toString())
//                        data.clear()
//                        data.add(bean!!)
//                        rl.adapter?.notifyDataSetChanged()
//
//                        val takeoutOpenHelper = TakeoutOpenHelper(applicationContext)
//                        val dao : Dao<DataBean, Int> = takeoutOpenHelper.getDao(
//                            DataBean::class.java)
//                        dao.create(bean)
//                        Log.v(MainActivity.TAG, "insert success")
//
//                        mHandler.sendEmptyMessageDelayed(MainActivity.MSG_CODE, 5*1000)
//                    }
                }

            })
    }
}