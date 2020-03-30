package com.wl.wanandroid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tudaritest.util.OnRvItemClickListener

import com.wl.wanandroid.utils.StringUtils
import com.zzy.phonenumbercard.R
import com.zzy.phonenumbercard.bean.CityBean
import kotlinx.android.synthetic.main.layout_item_rv_system_tree.view.*

class RvProvinceAdapter(cityBean: CityBean) :RecyclerView.Adapter<RvProvinceAdapter.ViewHolder>(){
    var cityBean: CityBean
    var rvItemClickListener:OnRvItemClickListener?=null
    var selectedPosition:Int = -1
    init {
        this.cityBean = cityBean
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

       var contentView = LayoutInflater.from(parent.context).inflate(R.layout.layout_item_rv_system_tree,parent,false)
        return ViewHolder(contentView)
    }

    override fun getItemCount(): Int {
        return cityBean.listC_City.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.tv_province.text = cityBean.listC_City.get(position).Province
        if(position==selectedPosition){
            holder.itemView.tv_province.paint.isFakeBoldText = true
            holder.itemView.setBackgroundColor(StringUtils.getColor(R.color.white))

        }else{
            holder.itemView.tv_province.paint.isFakeBoldText = false
            holder.itemView.setBackgroundColor(StringUtils.getColor(R.color.alpha_gray_white))
        }
        holder.itemView.setOnClickListener {
            selectedPosition = position
            notifyDataSetChanged()
            rvItemClickListener?.onItemClick(position)
        }
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}