package com.zzy.phonenumbercard.bean

data class CityBean(
    val Errorinfo: Any,
    val Result: Boolean,
    val listC_City: List<CCity>
)

data class CCity(
    val Province: String,
    val listCity: List<String>
)