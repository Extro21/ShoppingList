package com.extro.vostr.shoppinglist.shopList.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.extro.vostr.shoppinglist.shopList.domain.ListItem
import com.extro.vostr.shoppinglist.shopList.domain.interactor.ShopListInteractor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewShopListViewModel(private val interactor: ShopListInteractor) : ViewModel() {


    fun addShopList(title: String, items: List<ListItem>) {
        viewModelScope.launch(Dispatchers.IO) {
            interactor.addShopList(title, items)
        }

//        for (item in items){
//            var isChecked = if(item.isChecked){
//                1
//            } else {
//                0
//            }
//            viewModelScope.launch {
//                interactor.addItemToShopList(text = item.text, isChecked = isChecked)
//            }
//        }
//
//
//        viewModelScope.launch{
//            delay(5000)
//            interactor.addAll(items)
//        }
    }


}

