package com.extro.vostr.shoppinglist.shopList.data.repository

import android.util.Log
import com.extro.vostr.shoppinglist.entities.ItemForShopList
import com.extro.vostr.shoppinglist.entities.ShoppingListItem
import com.extro.vostr.shoppinglist.entities.ShoppingListNames
import com.extro.vostr.shoppinglist.notes.data.db.MainDataBase
import com.extro.vostr.shoppinglist.shopList.domain.ListItem
import com.extro.vostr.shoppinglist.shopList.domain.repository.ShopListRepository
import kotlinx.coroutines.flow.Flow

class ShopListRepositoryImpl(private val dataBase: MainDataBase) : ShopListRepository {

     override suspend fun addShopList(title : String, items : List<ListItem>){
        dataBase.shopListDao().addShoplist(ShoppingListNames(idShoplist = 0, name = title, time = "", checkedItemsCounter = 0))


         for(item in items){
             var isChecked = if(item.isChecked){
                 1
             } else {
                 0
             }
             dataBase.shopListDao().addItem(
                 ShoppingListItem(idItem = 0, itemChecked = isChecked, content = item.text)
             )
         }

        val listCountIdItem = dataBase.shopListDao().getSelectIdItem(items.size)
        val listCountIdShopList = dataBase.shopListDao().getSelectIdShopList()

         for (item in listCountIdItem){
             dataBase.shopListDao().addItemForShoplist(ItemForShopList(idShoplist = listCountIdShopList, idItem = item))
         }

    }

     override fun getShopList() : Flow<List<ShoppingListNames>> = dataBase.shopListDao().getShopList()





}