package com.extro.vostr.shoppinglist.shopList.domain.interactor

import com.extro.vostr.shoppinglist.entities.ShoppingListNames
import com.extro.vostr.shoppinglist.shopList.domain.ListItem
import com.extro.vostr.shoppinglist.shopList.domain.repository.ShopListRepository
import kotlinx.coroutines.flow.Flow

class ShopListInteractorImpl(private val repository: ShopListRepository) : ShopListInteractor {

    override suspend fun addShopList(title: String, items: List<ListItem>) {
        repository.addShopList(title, items)
    }

    override fun getShopList(): Flow<List<ShoppingListNames>> = repository.getShopList()
    override fun getItemForShopList(id: Int): Flow<List<ListItem>> = repository.getItemForShopList(id)


    override suspend fun addItemToShopList(isChecked: Int, text: String) {
        repository.addItemToShopList(isChecked, text)
    }

    override suspend fun addAll(items: List<ListItem>) {
        repository.addAll(items)
    }
}