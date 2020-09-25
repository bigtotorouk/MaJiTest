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
    override fun reqLastIndex() {
        val takeoutOpenHelper = TakeoutOpenHelper(this.presenter.context)
        val dao : Dao<DataBean, Int> = takeoutOpenHelper.getDao(DataBean::class.java)
        if(dao.count()>0){
            //show last data
            var bean: DataBean = dao.queryBuilder().orderBy("id", false).queryForFirst()
            this.presenter.resLastIndex(bean)
        }else{
            reqIndex()
        }
    }

    init {
        this.presenter = presenter
    }

    override fun reqIndex() {
        var api = AppClientManager.client.create(GithubApi::class.java)
        api.index()
            .enqueue(object:retrofit2.Callback<DataBean> {
                override fun onFailure(call: Call<DataBean>, t: Throwable) {
                    print(t.toString())
                    presenter.resError("获取服务器数据失败")
                }

                override fun onResponse(call: Call<DataBean>, response: Response<DataBean>) {
                    var bean = response.body()
                    Log.v("model", bean.toString())
                    if(bean!=null){
                        val takeoutOpenHelper = TakeoutOpenHelper(presenter.context)
                        val dao : Dao<DataBean, Int> = takeoutOpenHelper.getDao(
                            DataBean::class.java)
                        dao.create(bean)
                        Log.v(MainActivity.TAG, "insert success")
                        presenter.resIndex(bean)
                    }else{
                        presenter.resError("获取服务器数据失败")
                    }
                }
            })
    }
}