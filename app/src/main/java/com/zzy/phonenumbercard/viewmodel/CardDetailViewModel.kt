package com.zzy.phonenumbercard.viewmodel

import com.wl.wanandroid.viewmodel.BaseViewModel
import com.zzy.phonenumbercard.bean.CardDetailBean
import com.zzy.phonenumbercard.model.CardDetailModel

class CardDetailViewModel:BaseViewModel<CardDetailBean>() {
    var cardDetailModel = CardDetailModel(this)
    init {
        baseModel = cardDetailModel
    }

    fun getCardDetail(userID:String,pwd:String, imei:String,city:String,pwd_jiami:String){
        cardDetailModel.getCardDetail(userID,pwd,imei,city,pwd_jiami)
    }

}