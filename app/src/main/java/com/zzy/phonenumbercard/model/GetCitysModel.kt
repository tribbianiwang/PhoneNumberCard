package com.zzy.phonenumbercard.model

import com.wl.wanandroid.model.BaseModel
import com.wl.wanandroid.utils.BaseDataResultListener
import com.zzy.phonenumbercard.bean.CityBean
import com.zzy.phonenumbercard.utils.AppConstants
import com.zzy.phonenumbercard.utils.LogUtils

class GetCitysModel(dataResultListener: BaseDataResultListener<CityBean>) :
    BaseModel<CityBean>(dataResultListener) {

    fun getCityList(pwd_jiami:String){

        getServerData(pwd_jiami,methodName = "getCityList",callBack = object :OnSuccessCallback<CityBean>{
            override fun invoke(t: CityBean) {
//                if(vertifyResultError(t.Result,t.Errorinfo)){
                    dataResultListener.setQueryStatus(AppConstants.QUERYSTATUSSUCCESS)
                    dataResultListener.setResultData(t)
//                }

            }

        })
    }
}