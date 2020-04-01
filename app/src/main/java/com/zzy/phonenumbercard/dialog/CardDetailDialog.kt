package com.zzy.phonenumbercard.dialog

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.wl.wanandroid.utils.StringUtils
import com.wl.wanandroid.utils.T
import com.zzy.phonenumbercard.R
import com.zzy.phonenumbercard.bean.MBInfo
import kotlinx.android.synthetic.main.layout_dialog_card_detail.*

class CardDetailDialog(context: Context, listMBInfo: MBInfo) : AlertDialog(context) {
    var listMBInfo: MBInfo
    init {
        this.listMBInfo = listMBInfo
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_dialog_card_detail)
        
        tv_name.text = listMBInfo.c_Name
        tv_card_type.text = listMBInfo.TelBrand
        tv_phone_number.text = listMBInfo.MemberMobile
        tv_location.text = listMBInfo.TelProvince+listMBInfo.TelCity
        tv_action_time.text = listMBInfo.ActionTime

        ll_cn_no.setOnClickListener{
            showHintAndCopyClidBoard(listMBInfo.c_NO,context)
        }

        ll_name.setOnClickListener{
            showHintAndCopyClidBoard(listMBInfo.c_Name,context)
        }
        ll_card_type.setOnClickListener{
            showHintAndCopyClidBoard(listMBInfo.TelBrand,context)
        }
        ll_phone_number.setOnClickListener{
            showHintAndCopyClidBoard(listMBInfo.MemberMobile,context)
        }
        ll_location.setOnClickListener{
            showHintAndCopyClidBoard(listMBInfo.TelProvince+listMBInfo.TelCity,context)
        }
        ll_action_time.setOnClickListener{
            showHintAndCopyClidBoard(listMBInfo.ActionTime,context)
        }
    }

    private fun showHintAndCopyClidBoard(content: String, context: Context) {

        StringUtils.setClipboard(context,content)
        T.showShort(context,content+StringUtils.getString(R.string.string_copy_toclip))
    }


}