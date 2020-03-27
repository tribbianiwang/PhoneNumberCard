package com.zzy.phonenumbercard.model

import com.wl.wanandroid.model.BaseModel
import com.wl.wanandroid.utils.BaseDataResultListener
import com.zzy.phonenumbercard.bean.LoginBean
import com.zzy.phonenumbercard.utils.AppConstants
import retrofit2.http.Query

class LoginModel(dataResultListener: BaseDataResultListener<LoginBean>) :
    BaseModel<LoginBean>(dataResultListener) {

    fun startLogin(userID:String,pwd:String, imei:String,pwd_jiami:String){
        getServerData(userID,pwd,imei,pwd_jiami,methodName = "startLogin",callBack = object :OnSuccessCallback<LoginBean>{
            override fun invoke(t: LoginBean) {
                if(vertifyResultError(t.Result,t.Errorinfo)){
                    dataResultListener.setQueryStatus(AppConstants.QUERYSTATUSSUCCESS)
                    dataResultListener.setResultData(t)
                }

            }

        })

    }
}