package com.extro.vostr.shoppinglist.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "note_list")
data class NoteItem(
    @PrimaryKey(autoGenerate = true)
    val id : Int,

    @ColumnInfo(name = "title")
    val title : String,

    @ColumnInfo(name = "content")
    val content : String,

    @ColumnInfo(name = "time")
    val time : String,

    @ColumnInfo(name = "category")
    val category : String,
)
