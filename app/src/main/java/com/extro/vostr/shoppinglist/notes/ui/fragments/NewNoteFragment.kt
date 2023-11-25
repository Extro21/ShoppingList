package com.extro.vostr.shoppinglist.notes.ui.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.extro.vostr.shoppinglist.databinding.FragmentNewNoteBinding
import com.extro.vostr.shoppinglist.notes.ui.viewmodel.NewNoteViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


const val EXTRA_ID_NOTE = "id_note"
const val EXTRA_TITLE_NOTE = "title_note"
const val EXTRA_CONTENT_NOTE = "content_note"

class NewNoteFragment : Fragment() {


    private lateinit var binding : FragmentNewNoteBinding

    private val viewModel : NewNoteViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewNoteBinding.inflate(inflater, container , false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val title = requireArguments().getString(EXTRA_TITLE_NOTE)
        val id = requireArguments().getInt(EXTRA_ID_NOTE)
        val content = requireArguments().getString(EXTRA_CONTENT_NOTE)

        binding.apply {
            edTitle.setText(title)
            edContentNote.setText(content)
        }


        binding.apply {
            edContentNote.requestFocus()

            val imm = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(edContentNote, InputMethodManager.SHOW_IMPLICIT)

            btAddNote.setOnClickListener {
                Log.d("logItems", "${edTitle.text.toString()}  ${edContentNote.text.toString()}")
                viewModel.addNewNote(
                   title = edTitle.text.toString(),
                    content = edContentNote.text.toString()
                )
                findNavController().popBackStack()
            }

            btBack.setOnClickListener {
                findNavController().popBackStack()
            }
        }


    }

    companion object {
        fun createArgs(
            noteId : Int?,
            noteTitle : String?,
            noteContent : String?,
        ) : Bundle = bundleOf(
            EXTRA_ID_NOTE to noteId,
            EXTRA_TITLE_NOTE to noteTitle,
            EXTRA_CONTENT_NOTE to noteContent
        )
    }



}