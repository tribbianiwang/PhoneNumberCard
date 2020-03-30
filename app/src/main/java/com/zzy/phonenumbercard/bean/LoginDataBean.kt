package com.zzy.phonenumbercard.bean

import android.os.Parcel
import android.os.Parcelable

class LoginDataBean() :Parcelable{

    var loginId:String = ""
    var password:String = ""

    constructor(parcel: Parcel) : this() {
        loginId = parcel.readString().toString()
        password = parcel.readString().toString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(loginId)
        parcel.writeString(password)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<LoginDataBean> {
        override fun createFromParcel(parcel: Parcel): LoginDataBean {
            return LoginDataBean(parcel)
        }

        override fun newArray(size: Int): Array<LoginDataBean?> {
            return arrayOfNulls(size)
        }
    }
}