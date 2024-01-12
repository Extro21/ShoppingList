package com.extro.vostr.shoppinglist.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

//делаем sql таблицу
@Entity(tableName = "shopping_list_names")
data class ShoppingListNames(
    @PrimaryKey(autoGenerate = true)  //автогенерация ключа
    val idShoplist: Int,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "time")
    val time: String,

//    @ColumnInfo(name = "allItemCount") //общее количество элементов в списке
//    val allItemCounter: Int,

    @ColumnInfo(name = "checkedItemsCounter") //количество отмеченных элементов
    val checkedItemsCounter: Int,

    /*
   все элементы добавленные в этот список, чтобы мы могли их получить
     */
//    @ColumnInfo(name = "itemsIds")
//    val itemsIds: String,


    ) : Serializable //чтобы передавать весь класс а не по элементам
