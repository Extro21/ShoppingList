package com.extro.vostr.shoppinglist.notes.ui.adapter

import com.extro.vostr.shoppinglist.entities.NoteItem

 fun interface ItemClickListener {
    fun onItemListener(item : NoteItem)
}