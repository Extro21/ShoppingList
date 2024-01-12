package com.extro.vostr.shoppinglist.notes.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.extro.vostr.shoppinglist.entities.ItemForShopList
import com.extro.vostr.shoppinglist.entities.LibraryItem
import com.extro.vostr.shoppinglist.entities.NoteItem
import com.extro.vostr.shoppinglist.entities.ShoppingListItem
import com.extro.vostr.shoppinglist.entities.ShoppingListNames
import com.extro.vostr.shoppinglist.shopList.data.db.ShopListDao

//База данных
@Database(entities = [LibraryItem::class, NoteItem::class,
    ShoppingListItem::class, ShoppingListNames::class,
    ItemForShopList::class,
    //NoteItemTest::class
                     ], version = 1,
//    autoMigrations = [
//        AutoMigration (from = 1, to = 2)
//    ], exportSchema = true
)
abstract class MainDataBase : RoomDatabase() {

    abstract fun getDao() : Dao
    abstract fun shopListDao() : ShopListDao

//    companion object {
//       @Volatile
//       private var INSTANCE : MainDataBase? = null
//
//        fun getDataBase(context: Context) : MainDataBase {
//            //создаем базу данных если ее нет
//            return INSTANCE ?: synchronized(this){
//                val instance = Room.databaseBuilder(
//                    context = context.applicationContext, // передаем контекст всего приложения
//                    klass = MainDataBase::class.java,   // передаем класс
//                    name = "shopping_list.db" //название базы данных
//                ).build()
//                instance  //возвращяем истанцию в return
//            }
//        }
//    }

}