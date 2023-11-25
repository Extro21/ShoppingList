package com.extro.vostr.shoppinglist.shopList.di

import com.extro.vostr.shoppinglist.shopList.ui.viewmodel.NewShopListViewModel
import com.extro.vostr.shoppinglist.shopList.ui.viewmodel.ShopListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val shopListViewModelModule = module {

    viewModel {
        NewShopListViewModel(get())
    }

    viewModel {
        ShopListViewModel(get())
    }

}