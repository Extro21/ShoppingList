package com.extro.vostr.shoppinglist.activities

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.extro.vostr.shoppinglist.db.MainDataBase

class MainApp : Application(){

    val dataBase by lazy { MainDataBase.getDataBase(this) }

    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(
            AppCompatDelegate.MODE_NIGHT_NO)
    }
}