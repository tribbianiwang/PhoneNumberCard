package com.wl.wanandroid.retrofit


import com.zzy.phonenumbercard.bean.LoginBean
import com.zzy.phonenumbercard.utils.AppConstants
import retrofit2.http.*
import rx.Observable


interface  RetrofitService{
//    @GET(AppConstants.BANNER_URL)
//    fun getBannerData():Observable<BannerBean>//获取banner

    @GET("webservice/WebService1.asmx/CheckUser")
    fun startLogin(@Query("userID")userID:String,@Query("pwd")pwd:String,@Query("imei") imei:String,@Query("pwd_jiami")pwd_jiami:String):Observable<LoginBean>





}