package com.zzy.phonenumbercard.utils

import com.tencent.mmkv.MMKV
import com.zzy.phonenumbercard.bean.LoginDataBean
import com.zzy.phonenumbercard.utils.AppConstants.ISLOGIN


class CookieUtils {

     companion object{

         /*登录标记*/
         fun setIsLogin(isLogin:Boolean){
             MMKV.defaultMMKV().encode(ISLOGIN,isLogin)
         }

         fun getIsLogin():Boolean{

          return    MMKV.defaultMMKV().decodeBool(ISLOGIN,false)
         }

         fun setLoginData(loginDataBean: LoginDataBean){
             MMKV.defaultMMKV().encode("loginDataBean",loginDataBean)
         }

         fun getLoginData():LoginDataBean?{
             return    MMKV.defaultMMKV().decodeParcelable("loginDataBean",LoginDataBean::class.java)
         }




         fun clearData(){
//             setTouristPhoneNumber("")

         }

     }

}