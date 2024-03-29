package com.extro.vostr.shoppinglist.notes.domain.impl

import com.extro.vostr.shoppinglist.entities.NoteItem
import com.extro.vostr.shoppinglist.notes.domain.db.NoteInteractor
import com.extro.vostr.shoppinglist.notes.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteInteractorImpl(private val repository: NoteRepository) : NoteInteractor {

    override suspend fun addNote(title: String, content: String) {
        repository.addNote(title, content)
    }

     override fun getNotes() : Flow<List<NoteItem>> {
         return repository.getNotes()
     }

    override suspend fun getNote(idNote: Int): NoteItem  = repository.getNote(idNote)

    override suspend fun updateNote(id : Int, title: String, content: String) {
        repository.updateNote(id, title, content)
    }

    override suspend fun deleteNote(id: Int) {
        repository.deleteNote(id)
    }
}