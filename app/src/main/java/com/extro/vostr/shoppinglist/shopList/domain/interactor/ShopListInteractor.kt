package com.extro.vostr.shoppinglist.shopList.domain.interactor

import com.extro.vostr.shoppinglist.entities.ShoppingListNames
import com.extro.vostr.shoppinglist.shopList.domain.ListItem
import kotlinx.coroutines.flow.Flow

interface ShopListInteractor {

    suspend fun addShopList(title : String, items : List<ListItem>)

    fun getShopList() : Flow<List<ShoppingListNames>>

}