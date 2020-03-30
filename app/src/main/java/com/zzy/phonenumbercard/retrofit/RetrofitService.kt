package com.wl.wanandroid.retrofit


import com.zzy.phonenumbercard.bean.CardDetailBean
import com.zzy.phonenumbercard.bean.CityBean
import com.zzy.phonenumbercard.bean.LoginBean
import com.zzy.phonenumbercard.utils.AppConstants
import retrofit2.http.*
import rx.Observable


interface  RetrofitService{
//    @GET(AppConstants.BANNER_URL)
//    fun getBannerData():Observable<BannerBean>//获取banner

    //登录
    @GET("webservice/WebService1.asmx/CheckUser")
    fun startLogin(@Query("userID")userID:String,@Query("pwd")pwd:String,@Query("imei") imei:String,@Query("pwd_jiami")pwd_jiami:String):Observable<LoginBean>


    //获取城市列表
    @GET("webservice/WebService1.asmx/GetProCity")
    fun getCityList(@Query("pwd_jiami")pwd_jiami:String):Observable<CityBean>

    //获取卡详情
    @GET("webservice/WebService1.asmx/Getdata")
    fun getCardDetail(@Query("userID")userID:String,@Query("pwd")pwd:String,@Query("imei") imei:String,@Query("strcity")strcity:String,@Query("pwd_jiami")pwd_jiami:String):Observable<CardDetailBean>




}