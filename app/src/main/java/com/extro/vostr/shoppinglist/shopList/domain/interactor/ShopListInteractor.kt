package com.extro.vostr.shoppinglist.shopList.domain.interactor

import com.extro.vostr.shoppinglist.entities.ShoppingListNames
import com.extro.vostr.shoppinglist.shopList.domain.ListItem
import kotlinx.coroutines.flow.Flow

interface ShopListInteractor {

    suspend fun addShopList(title : String, items : List<ListItem>)

    fun getShopList() : Flow<List<ShoppingListNames>>

    fun getItemForShopList(id : Int) : Flow<List<ListItem>>



    suspend fun addItemToShopList(isChecked : Int, text : String)

    suspend fun addAll(items : List<ListItem>)
}