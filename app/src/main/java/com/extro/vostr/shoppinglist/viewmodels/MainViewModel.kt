package com.extro.vostr.shoppinglist.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.extro.vostr.shoppinglist.notes.data.db.MainDataBase
import com.extro.vostr.shoppinglist.entities.NoteItem
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class MainViewModel(dataBase: MainDataBase) : ViewModel() {

    private val dao = dataBase.getDao()

    val allNotes: LiveData<List<NoteItem>> = dao.getAllNotes().asLiveData()

    fun insertNote(note: NoteItem) = viewModelScope.launch {
        dao.insertNote(note)
    }


    class MainViewModelFactory(private val dataBase: MainDataBase) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
           if(modelClass.isAssignableFrom(MainViewModel::class.java)){
               @Suppress("UNCHECKED_CAST")
               return MainViewModel(dataBase) as T
           }
            throw IllegalArgumentException("Unknown ViewModelClass")
        }
    }
}