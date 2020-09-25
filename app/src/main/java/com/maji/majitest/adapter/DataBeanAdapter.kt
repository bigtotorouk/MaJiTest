package com.maji.majitest.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.maji.majitest.R
import com.maji.majitest.bean.DataBean

class DataBeanAdapter(private var data:List<DataBean>): RecyclerView.Adapter<DataBeanAdapter.ViewHolder>() {

    //用于缓存控件实例的内部类ViewHolder
    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val titleTxt: TextView = view.findViewById(R.id.title)
        val timeTxt:TextView = view.findViewById(R.id.time)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.data_bean_item, parent,false)
        return ViewHolder(view)
    }

    //当子项进入屏幕时调用,对子项进行赋值
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //获取当前项的元素
        val bean = data[position]
        holder.titleTxt.text = bean.current_user_url
        holder.timeTxt.text = "第ID:"+bean.id.toString()+"次请求"
    }

    override fun getItemCount(): Int {
        Log.v("test", data.size.toString())
        return data.size
    }
}