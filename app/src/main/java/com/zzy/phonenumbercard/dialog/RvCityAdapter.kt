package com.wl.wanandroid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tudaritest.util.OnRvItemClickListener

import com.zzy.phonenumbercard.R
import kotlinx.android.synthetic.main.layout_item_rv_city.view.*


class RvCityAdapter(cityDatas:ArrayList<String>) :RecyclerView.Adapter<RvCityAdapter.ViewHolder>(){

    var cityDatas:ArrayList<String>
    init {
        this.cityDatas = cityDatas
    }
    
    var onRvItemClickListener:OnRvItemClickListener?=null
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        var contentView = LayoutInflater.from(parent.context).inflate(R.layout.layout_item_rv_city,parent,false)
        return ViewHolder(contentView)

    }

    override fun getItemCount(): Int {

       return cityDatas.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.tv_city.text = cityDatas.get(position)
        holder.itemView.setOnClickListener {
            onRvItemClickListener?.onItemClick(position)
        }

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}