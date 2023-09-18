package com.extro.vostr.shoppinglist.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class MainDataBase : RoomDatabase() {

    companion object {
       @Volatile
       private var INSTANCE : MainDataBase? = null

        fun getDataBase(context: Context) : MainDataBase{
            //создаем базу данных если ее нет
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder()
            }
        }
    }

}