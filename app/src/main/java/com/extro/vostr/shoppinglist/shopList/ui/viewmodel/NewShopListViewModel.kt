package com.extro.vostr.shoppinglist.shopList.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.extro.vostr.shoppinglist.shopList.domain.ListItem
import com.extro.vostr.shoppinglist.shopList.domain.interactor.ShopListInteractor
import kotlinx.coroutines.launch

class NewShopListViewModel(private val interactor : ShopListInteractor) : ViewModel() {


    fun addShopList(title : String, items : List<ListItem>) {
        viewModelScope.launch {
            interactor.addShopList(title, items)
        }
    }

    fun add(){

    }


}