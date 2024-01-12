package com.extro.vostr.shoppinglist.notes.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.extro.vostr.shoppinglist.entities.NoteItem
import com.extro.vostr.shoppinglist.notes.domain.db.NoteInteractor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class NoteViewModel(private val interactor : NoteInteractor) : ViewModel() {


    fun getNotesNow() : Flow<List<NoteItem>> = interactor.getNotes()

    // suspend fun getNote(id : Int) : NoteItem = interactor.getNote(id)

    fun deleteNote(id : Int) {
        viewModelScope.launch {
            interactor.deleteNote(id)
        }
    }



}