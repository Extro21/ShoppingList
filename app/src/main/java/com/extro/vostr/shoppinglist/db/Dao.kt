package com.extro.vostr.shoppinglist.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.extro.vostr.shoppinglist.entities.NoteItem
import kotlinx.coroutines.flow.Flow

//класс с помощью которого осуществялется доступ к базе данных (для того чтобы запичывать либы считывать)
@Dao
interface Dao {
    @Query("SELECT * FROM note_list")
    fun getAllNotes(): Flow<List<NoteItem>>

    @Insert
    suspend fun insertNote(note : NoteItem)



}