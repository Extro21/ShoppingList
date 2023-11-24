package com.extro.vostr.shoppinglist.notes.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.extro.vostr.shoppinglist.entities.NoteItem
import com.extro.vostr.shoppinglist.notes.domain.db.NoteInteractor
import kotlinx.coroutines.flow.Flow

class NoteViewModel(private val interactor : NoteInteractor) : ViewModel() {


    fun getNotesNow() : Flow<List<NoteItem>> = interactor.getNotes()


}