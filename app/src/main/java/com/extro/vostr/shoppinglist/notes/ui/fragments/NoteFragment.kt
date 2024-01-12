package com.extro.vostr.shoppinglist.notes.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.coroutineScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.extro.vostr.shoppinglist.R
import com.extro.vostr.shoppinglist.databinding.FragmentNoteAppBinding
import com.extro.vostr.shoppinglist.entities.NoteItem
import com.extro.vostr.shoppinglist.notes.ui.adapter.ItemClickListener
import com.extro.vostr.shoppinglist.notes.ui.adapter.NoteAdapter
import com.extro.vostr.shoppinglist.notes.ui.adapter.NoteAdapterNew

import com.extro.vostr.shoppinglist.notes.ui.viewmodel.NoteViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class NoteFragment : Fragment(), ItemClickListener {

    private lateinit var binding: FragmentNoteAppBinding
    private val viewModel: NoteViewModel by viewModel()

    //private var adapter = NoteAdapterNew(this)
    private var adapter = NoteAdapter(this)

    private lateinit var deleteItem : MaterialAlertDialogBuilder

    override fun onItemListener(item: NoteItem) {
        findNavController().navigate(
            R.id.action_noteFragment2_to_newNoteFragment,
            NewNoteFragment.createArgs(item.id, item.title, item.content)
        )
    }

//    fun search(query : String) : List<NoteItem> {
//            return adapter.currentList.filter {
//                it.title.contains(query, ignoreCase = true)
//            }
//    }



    override fun onItemLongListener(itemId: Int) {
        dialogDeleteItem(itemId)
        deleteItem.show()
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

        binding.edSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // Действия при отправке текста поиска
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                  //  adapter.filter(newText)
                return false
            }
        })


        lifecycle.coroutineScope.launch {
            viewModel.getNotesNow().collect() {
                Log.d("adapterLog", "$it")
               adapter.submitList(it)
              //  adapter.setItems(it.toMutableList())
               // adapter.notifyDataSetChanged()
            }
        }

        binding.newNote.setOnClickListener {
            findNavController().navigate(
                R.id.action_noteFragment2_to_newNoteFragment,
                NewNoteFragment.createArgs(null, null, null)
            )
        }



    }

    private fun dialogDeleteItem(id : Int){
        deleteItem = MaterialAlertDialogBuilder(requireContext())
            .setMessage("Удалить заметку?")
            .setNegativeButton("Нет") { dialog, which ->

            }
            .setPositiveButton("Да") { dialog, which ->
                viewModel.deleteNote(id)
            }

    }

}