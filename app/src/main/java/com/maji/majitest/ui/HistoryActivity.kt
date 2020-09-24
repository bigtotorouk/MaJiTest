package com.maji.majitest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.j256.ormlite.dao.Dao
import com.maji.majitest.adapter.DataBeanAdapter
import com.maji.majitest.db.TakeoutOpenHelper
import com.maji.majitest.bean.DataBean
import kotlinx.android.synthetic.main.activity_main.*

class HistoryActivity : AppCompatActivity() {

    lateinit var data:List<DataBean>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        fetchLocalData();
    }

    private fun fetchLocalData(){
        val takeoutOpenHelper = TakeoutOpenHelper(this)
        val dao : Dao<DataBean, Int> = takeoutOpenHelper.getDao(DataBean::class.java)
        var data:List<DataBean> = dao.queryForAll()

        Log.v(tag, "data size is "+data.size.toString())
        rl.layoutManager = LinearLayoutManager(this)
        rl.adapter = DataBeanAdapter(data)
    }

    companion object {
        const val tag = "history"
    }
}
