package com.extro.vostr.shoppinglist.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.extro.vostr.shoppinglist.entities.LibraryItem
import com.extro.vostr.shoppinglist.entities.NoteItem
import com.extro.vostr.shoppinglist.entities.ShoppingListItem
import com.extro.vostr.shoppinglist.entities.ShoppingListNames

//База данных
@Database(entities = [LibraryItem::class, NoteItem::class,
    ShoppingListItem::class, ShoppingListNames::class], version = 1)
abstract class MainDataBase : RoomDatabase() {

    abstract fun getDao() : Dao

    companion object {
       @Volatile
       private var INSTANCE : MainDataBase? = null

        fun getDataBase(context: Context) : MainDataBase{
            //создаем базу данных если ее нет
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context = context.applicationContext, // передаем контекст всего приложения
                    klass = MainDataBase::class.java,   // передаем класс
                    name = "shopping_list.db" //название базы данных
                ).build()
                instance  //возвращяем истанцию в return
            }
        }
    }

}