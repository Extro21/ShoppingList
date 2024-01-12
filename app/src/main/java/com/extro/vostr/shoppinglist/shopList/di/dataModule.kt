package com.extro.vostr.shoppinglist.shopList.di

import com.extro.vostr.shoppinglist.shopList.data.repository.ShopListRepositoryImpl
import com.extro.vostr.shoppinglist.shopList.domain.repository.ShopListRepository
import org.koin.dsl.module

val repositoryShoplistModule = module {

    single<ShopListRepository> {
        ShopListRepositoryImpl(get())
    }

}