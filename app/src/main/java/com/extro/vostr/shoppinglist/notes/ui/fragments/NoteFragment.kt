package com.extro.vostr.shoppinglist.notes.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.coroutineScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.extro.vostr.shoppinglist.R
import com.extro.vostr.shoppinglist.databinding.FragmentNoteAppBinding
import com.extro.vostr.shoppinglist.notes.ui.adapter.NoteAdapter

import com.extro.vostr.shoppinglist.notes.ui.viewmodel.NoteViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class NoteFragment : Fragment() {

    private lateinit var binding: FragmentNoteAppBinding
    private val viewModel: NoteViewModel by viewModel()

    private var adapter = NoteAdapter {
        Log.d("checkClick", "checkClick")
        findNavController().navigate(
            R.id.action_noteFragment2_to_newNoteFragment,
            NewNoteFragment.createArgs(it.id, it.title, it.content)
        )

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoteAppBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            rvNotes.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            rvNotes.adapter = adapter
        }

        lifecycle.coroutineScope.launch {
            viewModel.getNotesNow().collect() {
                Log.d("adapterLog", "$it")
               adapter.submitList(it)
            }
        }

        binding.newNote.setOnClickListener {
            findNavController().navigate(
                R.id.action_noteFragment2_to_newNoteFragment,
                NewNoteFragment.createArgs(null, null, null)
            )
        }



    }

}