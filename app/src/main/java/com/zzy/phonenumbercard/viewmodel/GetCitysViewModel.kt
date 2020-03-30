package com.zzy.phonenumbercard.viewmodel

import com.wl.wanandroid.viewmodel.BaseViewModel
import com.zzy.phonenumbercard.bean.CityBean
import com.zzy.phonenumbercard.model.GetCitysModel
import com.zzy.phonenumbercard.utils.LogUtils

class GetCitysViewModel:BaseViewModel<CityBean>() {
    var getCityModel = GetCitysModel(this)

    init {
        baseModel = getCityModel
    }

    fun getCityList(pwd_jiami:String){

        getCityModel.getCityList(pwd_jiami)

    }
}