package com.extro.vostr.shoppinglist.shopList.di

import com.extro.vostr.shoppinglist.shopList.domain.interactor.ShopListInteractor
import com.extro.vostr.shoppinglist.shopList.domain.interactor.ShopListInteractorImpl
import org.koin.dsl.module

val shopListInteractorViewModule = module {

    single<ShopListInteractor> {
        ShopListInteractorImpl(get())
    }

}