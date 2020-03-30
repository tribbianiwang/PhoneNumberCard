package com.zzy.phonenumbercard.model

import com.wl.wanandroid.model.BaseModel
import com.wl.wanandroid.utils.BaseDataResultListener
import com.zzy.phonenumbercard.bean.CardDetailBean
import com.zzy.phonenumbercard.utils.AppConstants

class CardDetailModel(dataResultListener: BaseDataResultListener<CardDetailBean>) :
    BaseModel<CardDetailBean>(dataResultListener) {


    fun getCardDetail(userID:String,pwd:String, imei:String,city:String,pwd_jiami:String){
        getServerData(userID,pwd,imei,city,pwd_jiami,methodName = "getCardDetail",callBack = object:OnSuccessCallback<CardDetailBean>{
            override fun invoke(t: CardDetailBean) {
                if(vertifyResultError(t.Result,t.Errorinfo)){
                    dataResultListener.setQueryStatus(AppConstants.QUERYSTATUSSUCCESS)
                    dataResultListener.setResultData(t)
                }

            }

        })
    }
}