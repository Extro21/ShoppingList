package com.extro.vostr.shoppinglist.notes.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.extro.vostr.shoppinglist.databinding.FragmentNewNoteBinding
import com.extro.vostr.shoppinglist.notes.ui.viewmodel.NewNoteViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

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


        binding.apply {
            btAddNote.setOnClickListener {
                Log.d("logItems", "${edTitle.text.toString()}  ${edContentNote.text.toString()}")
                viewModel.addNewNote(
                   title = edTitle.text.toString(),
                    content = edContentNote.text.toString()
                )
                findNavController().popBackStack()
            }
        }

    }



}