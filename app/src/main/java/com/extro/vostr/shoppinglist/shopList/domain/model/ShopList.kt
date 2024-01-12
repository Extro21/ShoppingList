package com.extro.vostr.shoppinglist.shopList.domain.model

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class ShopList(
    val idShoplist: Int,
    val name: String,
    val time: String,
    val checkedItemsCounter: Int,
)
