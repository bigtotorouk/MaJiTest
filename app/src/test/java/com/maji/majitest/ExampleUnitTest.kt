package com.maji.majitest

import android.util.Log
import com.j256.ormlite.dao.Dao
import com.maji.majitest.api.AppClientManager
import com.maji.majitest.api.GithubApi
import com.maji.majitest.bean.DataBean
import com.maji.majitest.db.TakeoutOpenHelper
import com.maji.majitest.ui.main.MainActivity
import org.junit.Test

import org.junit.Assert.*
import retrofit2.Call
import retrofit2.Response

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }


    @Test
    fun api_index() {//接口测试
        var api = AppClientManager.client.create(GithubApi::class.java)
        api.index()
            .enqueue(object:retrofit2.Callback<DataBean> {
                override fun onFailure(call: Call<DataBean>, t: Throwable) {
                    print(t.toString())
                    assertTrue(false)
                }
                override fun onResponse(call: Call<DataBean>, response: Response<DataBean>) {
                    var bean = response.body()
                    Log.v("model", bean.toString())
                    assertNotNull(bean)
                }
            })
    }


}
