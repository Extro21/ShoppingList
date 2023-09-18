package com.extro.vostr.shoppinglist.activities

import android.app.Application
import com.extro.vostr.shoppinglist.db.MainDataBase

class MainApp : Application(){

    val dataBase by lazy { MainDataBase.getDataBase(this) }
}