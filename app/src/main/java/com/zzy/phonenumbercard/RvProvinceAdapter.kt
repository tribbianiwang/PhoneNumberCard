package com.zzy.phonenumbercard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RvProvinceAdapter:RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var provinceArray = arrayOf("河南省","河北省","广东省","湖北省","湖南省")

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
       return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_dialog_rv_province_item,parent,false))

    }

    override fun getItemCount(): Int {
        return provinceArray.size

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {


    }
}