package com.maji.majitest.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.j256.ormlite.dao.Dao
import com.maji.majitest.ui.HistoryActivity
import com.maji.majitest.R

import com.maji.majitest.adapter.DataBeanAdapter
import com.maji.majitest.api.AppClientManager
import com.maji.majitest.api.GithubApi
import com.maji.majitest.db.TakeoutOpenHelper
import com.maji.majitest.bean.DataBean
import com.maji.majitest.mvp.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response


class MainActivity : BaseActivity<MainActivity, MainModel, MainPresenter>(), IMain.VP {


    val data = ArrayList<DataBean>()
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
                presenter?.reqIndex()
            }
        }
    }


    override fun getContentId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        rl.layoutManager = LinearLayoutManager(this)
        rl.adapter = DataBeanAdapter(data)
        reqLastIndex()
    }

    override fun initListener() {

    }

    override fun initPresenter(): MainPresenter {
        return MainPresenter(this)
    }

    override fun reqIndex() {
        presenter?.reqIndex()
    }

    override fun resIndex(bean:DataBean) {
        if(isRunning){
            updateList(bean)
            data.clear()
            data.add(bean!!)
            rl.adapter?.notifyDataSetChanged()
            mHandler.sendEmptyMessageDelayed(MSG_CODE, 5*1000)
        }

    }


    override fun reqLastIndex() {
        presenter?.reqLastIndex()
    }

    override fun resLastIndex(bean: DataBean) {
        if(isRunning){
            updateList(bean)
            data.clear()
            data.add(bean!!)
            rl.adapter?.notifyDataSetChanged()
            mHandler.sendEmptyMessageDelayed(MSG_CODE, 5*1000)

        }
    }


    fun updateList(bean:DataBean){


    }

    override fun resError(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu);
        return true;
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId== R.id.action_history){
            startActivity(Intent(this, HistoryActivity::class.java))
        }
        return true
    }


    override fun onDestroy() {
        isRunning = false
        super.onDestroy()
    }

}

