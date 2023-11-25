package com.extro.vostr.shoppinglist.shopList.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.extro.vostr.shoppinglist.entities.ShoppingListNames
import com.extro.vostr.shoppinglist.shopList.domain.interactor.ShopListInteractor
import kotlinx.coroutines.flow.Flow

class ShopListViewModel(private val interactor : ShopListInteractor) : ViewModel() {


    fun getShopList() : Flow<List<ShoppingListNames>> = interactor.getShopList()


}