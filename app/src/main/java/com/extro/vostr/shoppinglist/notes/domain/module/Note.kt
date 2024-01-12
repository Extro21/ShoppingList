package com.extro.vostr.shoppinglist.notes.domain.module

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class Note(
    val id : Int,
    val title : String,
    val content : String,
    val time : String,
    val category : String?,
)
