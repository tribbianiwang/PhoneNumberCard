package com.zzy.phonenumbercard.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tudaritest.util.OnRvItemClickListener
import com.wl.wanandroid.utils.StringUtils
import com.wl.wanandroid.utils.T
import com.zzy.phonenumbercard.R
import com.zzy.phonenumbercard.bean.MBInfo
import kotlinx.android.synthetic.main.layout_rv_item_card.view.*

class RvCardListAdapter(listMBInfo: List<MBInfo>) :RecyclerView.Adapter<RvCardListAdapter.ViewHolder>()
     {
    var listMBInfo: List<MBInfo>
         var onItemClickListener:OnRvItemClickListener?=null
    init {
        this.listMBInfo = listMBInfo
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        var contentview = LayoutInflater.from(parent.context).inflate(R.layout.layout_rv_item_card,parent,false)
        return ViewHolder(contentview)
    }

    override fun getItemCount(): Int {

        return listMBInfo.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

//        holder.itemView.tv_cn_no.text = listMBInfo.get(position).c_NO
        holder.itemView.tv_name.text = listMBInfo.get(position).c_Name
        holder.itemView.tv_card_type.text = listMBInfo.get(position).TelBrand
        holder.itemView.tv_phone_number.text = listMBInfo.get(position).MemberMobile
        holder.itemView.setOnClickListener {
            onItemClickListener?.onItemClick(position)
        }

//        holder.itemView.tv_location.text = listMBInfo.get(position).TelProvince+listMBInfo.get(position).TelCity
//        holder.itemView.tv_action_time.text = listMBInfo.get(position).ActionTime

//        holder.itemView.ll_cn_no.setOnClickListener{
//            showHintAndCopyClidBoard(listMBInfo.get(position).c_NO,holder.itemView.context)
//        }
//
//        holder.itemView.ll_name.setOnClickListener{
//            showHintAndCopyClidBoard(listMBInfo.get(position).c_Name,holder.itemView.context)
//        }
//        holder.itemView.ll_card_type.setOnClickListener{
//            showHintAndCopyClidBoard(listMBInfo.get(position).TelBrand,holder.itemView.context)
//        }
//        holder.itemView.ll_phone_number.setOnClickListener{
//            showHintAndCopyClidBoard(listMBInfo.get(position).MemberMobile,holder.itemView.context)
//        }
//        holder.itemView.ll_location.setOnClickListener{
//            showHintAndCopyClidBoard(listMBInfo.get(position).TelProvince+listMBInfo.get(position).TelCity,holder.itemView.context)
//        }
//        holder.itemView.ll_action_time.setOnClickListener{
//            showHintAndCopyClidBoard(listMBInfo.get(position).ActionTime,holder.itemView.context)
//        }
    }

//         private fun showHintAndCopyClidBoard(content: String, context: Context) {
//
//             StringUtils.setClipboard(context,content)
//             T.showShort(context,content+StringUtils.getString(R.string.string_copy_toclip))
//         }


     }