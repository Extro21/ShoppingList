package com.extro.vostr.shoppinglist.entities

import androidx.room.Entity
import androidx.room.ForeignKey


@Entity(
    tableName = "items_shoplist", primaryKeys = ["idItem", "idShoplist"],
    foreignKeys = [
        ForeignKey(
            entity = ShoppingListItem::class,
            parentColumns = ["idItem"],
            childColumns = ["idItem"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = ShoppingListNames::class,
            parentColumns = ["idShoplist"],
            childColumns = ["idShoplist"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)
data class ItemForShopList(
    val idShoplist: Int,
    val idItem : Int,
)
