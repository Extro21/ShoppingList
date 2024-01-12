package com.extro.vostr.shoppinglist.shopList.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ListItem (
    var text : String,
    var isChecked : Boolean,
) : Parcelable