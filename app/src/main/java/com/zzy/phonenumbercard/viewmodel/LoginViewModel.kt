package com.zzy.phonenumbercard.viewmodel

import com.wl.wanandroid.viewmodel.BaseViewModel
import com.zzy.phonenumbercard.bean.LoginBean
import com.zzy.phonenumbercard.model.LoginModel

class LoginViewModel:BaseViewModel<LoginBean>() {
    var loginModel = LoginModel(this)
    init {
        baseModel = loginModel
    }

    fun startLogin(userID:String,pwd:String, imei:String,pwd_jiami:String){
        loginModel.startLogin(userID,pwd,imei,pwd_jiami)

    }
}