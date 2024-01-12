package com.extro.vostr.shoppinglist.notes.di

import com.extro.vostr.shoppinglist.notes.domain.db.NoteInteractor
import com.extro.vostr.shoppinglist.notes.domain.impl.NoteInteractorImpl
import org.koin.dsl.module

val interactorModule = module {
    single<NoteInteractor> {
        NoteInteractorImpl(get())
    }
}