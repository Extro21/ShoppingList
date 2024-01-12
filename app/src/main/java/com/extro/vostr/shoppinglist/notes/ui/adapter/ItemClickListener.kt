package com.extro.vostr.shoppinglist.notes.ui.adapter

import com.extro.vostr.shoppinglist.entities.NoteItem

 interface ItemClickListener {
    fun onItemListener(item : NoteItem)

    fun onItemLongListener(itemId : Int)
}