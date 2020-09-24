package com.maji.majitest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.j256.ormlite.dao.Dao

import com.maji.majitest.adapter.DataBeanAdapter
import com.maji.majitest.api.AppClientManager
import com.maji.majitest.api.GithubApi
import com.maji.majitest.db.TakeoutOpenHelper
import com.maji.majitest.bean.DataBean
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    companion object {
        const val MSG_CODE = 1001
        const val TAG = "main"
    }
    var isRunning:Boolean = true // flag task
    private val mHandler = object : Handler() {
        override fun handleMessage(msg: Message?) {
            // Your logic code here.
            if(msg?.what== MSG_CODE){
                //update
                println("handleMessage "+msg?.what)
                loadData()
            }
        }
    }

    val data = ArrayList<DataBean>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rl.layoutManager = LinearLayoutManager(this)
        //设置适配器
        rl.adapter = DataBeanAdapter(data)


        val takeoutOpenHelper = TakeoutOpenHelper(applicationContext)
        val dao : Dao<DataBean, Int> = takeoutOpenHelper.getDao(DataBean::class.java)
        if(dao.count()>0){
            //show last data
            var bean: DataBean = dao.queryBuilder().orderBy("id", true).queryForFirst()
            data.clear()
            data.add(bean)
            rl.adapter?.notifyDataSetChanged()
            mHandler.sendEmptyMessageDelayed(MSG_CODE, 5*1000)
        }else{
            mHandler.sendEmptyMessageDelayed(MSG_CODE, 0)
        }

    }

//    private fun startTask() {
//        Thread(Runnable {
//            while(flag){
//                try {
//                    Thread.sleep(5*1000)
//                    mHandler.sendEmptyMessage(MSG_CODE)
//                }catch (e:InterruptedException){
//                    println(e.toString())
//                }
//            }
//        }).start()
//    }

    private fun loadData(){
        Log.v(TAG, "loadData")
        var api = AppClientManager.client.create(GithubApi::class.java)
        api.index()
            .enqueue(object:retrofit2.Callback<DataBean> {
                override fun onFailure(call: Call<DataBean>, t: Throwable) {
                    print(t.toString())
                }

                override fun onResponse(call: Call<DataBean>, response: Response<DataBean>) {
                    if(isRunning){
                        var bean = response.body()
//                        Log.v(TAG, bean.toString())
                        data.clear()
                        data.add(bean!!)
                        rl.adapter?.notifyDataSetChanged()

                        val takeoutOpenHelper = TakeoutOpenHelper(applicationContext)
                        val dao : Dao<DataBean, Int> = takeoutOpenHelper.getDao(
                            DataBean::class.java)
                        dao.create(bean)
                        Log.v(TAG, "insert success")

                        mHandler.sendEmptyMessageDelayed(MSG_CODE, 5*1000)
                    }
                }

            })
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu);
        return true;
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.action_history){
            startActivity(Intent(this, HistoryActivity::class.java))
        }
        return true
    }


    override fun onDestroy() {
        isRunning = false
        super.onDestroy()
    }

}

