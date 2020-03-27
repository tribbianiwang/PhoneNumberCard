package com.zzy.phonenumbercard

import android.app.Application
import com.tencent.mmkv.MMKV
import com.wl.wanandroid.retrofit.GetRetrofitService
import com.zzy.phonenumbercard.utils.LogUtils

class MyApplication :Application(){

    override fun onCreate() {
        super.onCreate()
        instance = this
        GetRetrofitService.init(applicationContext)

        val rootDir = MMKV.initialize(this)
        LogUtils.d("myapplications","oncreate")
    }

    companion object{
        var instance: MyApplication? = null
    }

}