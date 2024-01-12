package com.extro.vostr.shoppinglist.root

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.extro.vostr.shoppinglist.notes.data.db.MainDataBase
import com.extro.vostr.shoppinglist.notes.di.dataModule
import com.extro.vostr.shoppinglist.notes.di.interactorModule
import com.extro.vostr.shoppinglist.notes.di.repositoryModule
import com.extro.vostr.shoppinglist.notes.di.viewModelNote
import com.extro.vostr.shoppinglist.shopList.di.repositoryShoplistModule
import com.extro.vostr.shoppinglist.shopList.di.shopListInteractorViewModule
import com.extro.vostr.shoppinglist.shopList.di.shopListViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApp : Application(){

    //val dataBase by lazy { MainDataBase.getDataBase(this) }

    override fun onCreate() {
        super.onCreate()


        startKoin {
            androidContext(this@MainApp)

            modules(
                listOf(
                    repositoryModule, dataModule, interactorModule, viewModelNote,
                    repositoryShoplistModule, shopListInteractorViewModule, shopListViewModelModule
                )
            )
        }

        AppCompatDelegate.setDefaultNightMode(
            AppCompatDelegate.MODE_NIGHT_NO)
    }
}