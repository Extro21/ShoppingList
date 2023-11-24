package com.extro.vostr.shoppinglist.notes.domain.db

import com.extro.vostr.shoppinglist.entities.NoteItem
import kotlinx.coroutines.flow.Flow

interface NoteInteractor {


    suspend fun addNote(title : String, content : String)


    fun getNotes() : Flow<List<NoteItem>>
}