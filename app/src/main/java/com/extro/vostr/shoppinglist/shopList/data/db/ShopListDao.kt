package com.extro.vostr.shoppinglist.shopList.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.extro.vostr.shoppinglist.entities.ItemForShopList
import com.extro.vostr.shoppinglist.entities.ShoppingListItem
import com.extro.vostr.shoppinglist.entities.ShoppingListNames
import kotlinx.coroutines.flow.Flow

@Dao
interface ShopListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addShoplist(shoppingListNames: ShoppingListNames)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addItemForShoplist(item: ItemForShopList)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addItem(shoppingListItem: ShoppingListItem)

    @Transaction
     suspend fun addItemShopList(shoppingListNames: ShoppingListNames, shoppingListItem: ShoppingListItem) {
        addShoplist(shoppingListNames)
        addItem(shoppingListItem)
    }

    @Query("SELECT idItem FROM (SELECT idItem FROM shop_list_item ORDER BY idItem DESC LIMIT :countItem) t ORDER BY idItem")
    suspend fun getSelectIdItem(countItem : Int) : List<Int>

    @Query("SELECT idShoplist FROM shopping_list_names ORDER BY idShoplist DESC LIMIT 1")
    suspend fun getSelectIdShopList() : Int

    @Query("SELECT * FROM shopping_list_names")
    fun getShopList() : Flow<List<ShoppingListNames>>

    @Query("SELECT * FROM shop_list_item INNER JOIN items_shoplist ON shop_list_item.idItem == items_shoplist.idItem WHERE items_shoplist.idShoplist == :shopListId")
    fun getItemsByShopList(shopListId : Int): Flow<List<ShoppingListItem>>

//    @Query("SELECT name FROM shopping_list_names")
//    suspend fun getNameShopListForID(shopListId : Int) : String




}