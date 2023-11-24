package com.extro.vostr.shoppinglist.notes.di

import com.extro.vostr.shoppinglist.notes.ui.viewmodel.NewNoteViewModel
import com.extro.vostr.shoppinglist.notes.ui.viewmodel.NoteViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelNote = module {
    viewModel {
        NoteViewModel(get())
    }

    viewModel{
        NewNoteViewModel(get())
    }
}