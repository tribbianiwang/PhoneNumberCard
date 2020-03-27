package com.zzy.phonenumbercard.utils

import android.app.Activity

open class ActivityUtils{

    companion object{
        object  list{
            var list:ArrayList<Activity>?=null
        }


        fun addActivity(activity: Activity){
            list.list?.add(activity)
        }


        fun removeActivity(activity: Activity){
            list.list?.remove(activity)
        }

        fun exitActivity(){
            list.list?.clear();
            System.exit(0);

        }
    }

}