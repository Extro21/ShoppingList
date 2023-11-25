package com.extro.vostr.shoppinglist.notes.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.extro.vostr.shoppinglist.entities.NoteItem
import com.extro.vostr.shoppinglist.notes.data.db.MainDataBase
import com.extro.vostr.shoppinglist.notes.domain.module.Note
import com.extro.vostr.shoppinglist.notes.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class NoteRepositoryImpl(private val dataBase: MainDataBase) : NoteRepository {

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun addNote(title : String, content : String) {
       // val note = Note(id = 0 ,time = name, content = description, )
        val dateTime = LocalDateTime.now()
            .format(DateTimeFormatter.ofPattern("MMM dd yyyy, hh:mm:ss a"))
        dataBase.getDao().insertNote(
            NoteItem(id = 0 ,title = title, content = content, dateTime, ""))
    }

     override fun getNotes() : Flow<List<NoteItem>> = dataBase.getDao().getAllNotes()

    override suspend fun getNote(idNote : Int) : NoteItem {
       return dataBase.getDao().getNote(idNote)
    }



}