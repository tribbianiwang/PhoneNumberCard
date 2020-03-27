package com.zzy.phonenumbercard.dialog

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.zzy.phonenumbercard.R

class CityPickerDialog(context: Context) : AlertDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_pick_city)
    }
}