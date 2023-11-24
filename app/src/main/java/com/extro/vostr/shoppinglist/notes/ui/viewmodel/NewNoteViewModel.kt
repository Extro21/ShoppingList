package com.extro.vostr.shoppinglist.notes.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.extro.vostr.shoppinglist.notes.domain.db.NoteInteractor
import kotlinx.coroutines.launch

class NewNoteViewModel(private val interactor: NoteInteractor)  : ViewModel() {

    fun addNewNote(title : String, content : String){
        Log.d("logItems", "$title  $content")
        viewModelScope.launch {
            interactor.addNote(title, content)
        }
    }
}