package com.extro.vostr.shoppinglist.shopList.ui

import com.extro.vostr.shoppinglist.entities.ShoppingListItem
import com.extro.vostr.shoppinglist.shopList.domain.ListItem

class ShopListConvector {

    fun mup(shoppingListItem: ShoppingListItem) : ListItem {
        val isChecked : Boolean = shoppingListItem.itemChecked != 0
        return ListItem(
            text =  shoppingListItem.content,
            isChecked = isChecked
        )
    }

}