package com.extro.vostr.shoppinglist.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "shop_list_item")
data class ShoppingListItem(
    @PrimaryKey(autoGenerate = true)
    val idItem: Int,

    @ColumnInfo(name = "itemChecked")
    val itemChecked : Int = 0,

    @ColumnInfo(name = "content")
    val content: String,

//    @ColumnInfo(name = "itemInfo")
//    val itemInfo: String?,

//    @ColumnInfo(name = "listId") //индефикатор списка
//    val listId : Int,

//    @ColumnInfo(name = "itemType")  //для res view посказки
//    val itemType: String = "item"


)
