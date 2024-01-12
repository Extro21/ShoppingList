package com.extro.vostr.shoppinglist.shopList.ui.adapter

import com.extro.vostr.shoppinglist.entities.ShoppingListNames

fun interface ShopItemClickListener {

    fun itemClickListener( shopItem : ShoppingListNames)

}