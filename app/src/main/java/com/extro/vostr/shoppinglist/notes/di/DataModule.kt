package com.extro.vostr.shoppinglist.notes.di

import androidx.room.Room
import com.extro.vostr.shoppinglist.notes.data.db.MainDataBase
import com.extro.vostr.shoppinglist.notes.data.repository.NoteRepositoryImpl
import com.extro.vostr.shoppinglist.notes.domain.repository.NoteRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val repositoryModule = module {
    single<NoteRepository> {
        NoteRepositoryImpl(get())
    }
}

val dataModule = module {
    single {
        Room.databaseBuilder(androidContext(), MainDataBase::class.java, "shopNoteList5.db").build()
    }
}